def middleware(request, response):
    response['Public-Key-Pins'] = \
        'pin-sha256="cUPcTAZWKaASuYWhhneDttWpY3oBAkE3h2+soZS7sWs="; ' \
        'pin-sha256="M8HztCzM3elUxkcjR2S5P4hhyBNf6lHkmjAHKhpGPWE="; ' \
        'max-age=5184000; includeSubDomains; ' \
        'report-uri="https://o229048.ingest.sentry.io/api/4503937007157248/security/?sentry_key=a35a59ffdbb24b90a82df3d8c5e33494"' 
    return response
