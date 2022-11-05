import requests
import json
url = "https://data.mongodb-api.com/app/data-xngwl/endpoint/data/v1/action/findOne"

payload = json.dumps({
    "collection": "QOLGamesBackend",
    "database": "QOLGames",
    "dataSource": "COSINE-Cluster0",
    "projection": {
        "_id": 1
    }
})
headers = {
  'Content-Type': 'application/json',
  'Access-Control-Request-Headers': '*',
  'api-key': eVO3TuuzwDZF3lSQhK1KlUNizm0aXh08N9xqNWsaYb82bNq9cPBrkY90bT4HWORE,
  'Accept': 'application/ejson' 
}

response = requests.request("POST", url, headers=headers, data=payload)

print(response.text)
