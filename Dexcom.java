OverrideDexcom.java:
package com.contrivancecompanychicago.dexcom;
import com.unity3d.player.UnityPlayerActivity;
import java.lang.Math;
import java.net.*;
import java.net.http.*;
import java.util.*;

public class OverrideDexcom implements Main extends UnityPlayerActivity {
  public static void main(String[] args) throws Exception {
    var httpClient = HttpClient.newBuilder().build();

    var host = "https://api.dexcom.com";
    var pathname = "/v3/users/self/devices";
    var request = HttpRequest.newBuilder()
      .GET()
      .uri(URI.create(host + pathname ))
      .header("Authorization", "Bearer <YOUR_TOKEN_HERE>")
      .build();

    var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

    System.out.println(response.body());
  }
}
