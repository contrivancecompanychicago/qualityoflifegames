// Create a WireMock client instance to talk to this API
            WireMock wm = WireMock.create()
  .scheme("https")
  .host("qualityoflifegamesworld.wiremockapi.cloud")
  .port(443)
  .authenticator(new TokenAuthenticator("8d583e31437d02cc69ae2d24d8bbcaa3"))
  .build();

          // Configure a stub
wm.register(get("/hello-world").willReturn(ok("Hi!")));
          
