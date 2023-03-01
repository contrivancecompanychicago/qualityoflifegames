import http.client

conn = http.client.HTTPSConnection("qol-games.p.rapidapi.com")

conn.request("GET", "%7BPATH%7D")

res = conn.getresponse()
data = res.read()

print(data.decode("utf-8"))
