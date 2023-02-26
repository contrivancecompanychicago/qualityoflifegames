```
public class MyTokenGenOverride : VxTokenGen
{
    public override string GetToken(string issuer = null, TimeSpan? expiration = null, string userUri = null, string action = null, string tokenKey = null, string conferenceUri = null, string fromUserUri = null)
    {
        //Server Token Generation calls go here
    }
}

public void SetTokenOverride()
{
    Client.tokenGen = new MyTokenGenOverride();
}
```
