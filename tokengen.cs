using System;
using System.Text;
using System.Collections.Generic;
using System.Security.Cryptography;
using System.Web.Script.Serialization;

namespace VxTokenGenerator
{
    class TokenGenerator
    {
        static void Main(string[] args)
        {
            Console.WriteLine(vxGenerateToken("secret", "issuer", 1559359105, "join", 123456, "sip:.username.@domain.vivox.com", "sip:confctl-g-channelname@domain.vivox.com"));
        }

        static string vxGenerateToken(string key, string issuer, int exp, string vxa, int vxi, string f, string t)
        {
            var claims = new Claims
            {
                iss = issuer,
                exp = exp,
                vxa = vxa,
                vxi = vxi,
                f = f,
                t = t
            };

            List<string> segments = new List<string>();
            // Header is static - base64url encoded {} - Can also be defined as a constant "e30"
            var header = Base64URLEncode("{}");
            segments.Add(header);

            // Encode payload
            var claimsString = new JavaScriptSerializer().Serialize(claims);
            var encodedClaims = Base64URLEncode(claimsString);

            // Join segments to prepare for signing
            segments.Add(encodedClaims);
            string toSign = String.Join(".", segments);

            // Sign token with key and SHA256
            string sig = SHA256Hash(key, toSign);
            segments.Add(sig);

            // Join all 3 parts of token with . and return
            string token = String.Join(".", segments);

            return token;
        }

        private static string Base64URLEncode(string plainText)
        {
            var plainTextBytes = System.Text.Encoding.UTF8.GetBytes(plainText);
            // Remove padding at the end
            var encodedString = System.Convert.ToBase64String(plainTextBytes).TrimEnd('=');
            // Substitute URL-safe characters
            string urlEncoded = encodedString.Replace("+", "-").Replace("/", "_");

            return urlEncoded;
        }

        private static string SHA256Hash(string secret, string message)
        {
            var encoding = new System.Text.ASCIIEncoding();
            byte[] keyByte = encoding.GetBytes(secret);
            byte[] messageBytes = encoding.GetBytes(message);
            // The instance of HMACSHA256 is constructed and disposed in this method because it is not thread safe
            using (var hmacsha256 = new HMACSHA256(keyByte))
            {
                byte[] hashmessage = hmacsha256.ComputeHash(messageBytes);
                var hashString = Convert.ToBase64String(hashmessage).TrimEnd('=');
                string urlEncoded = hashString.Replace("+", "-").Replace("/", "_");

                return urlEncoded;
            }
        }

        public class Claims
        {
            public string iss { get; set; }
            public int exp { get; set; }
            public string vxa { get; set; }
            public int vxi { get; set; }
            public string f { get; set; }
            public string t { get; set; }
            public string sub { get; set; }
        }
    }
}
