# language: en

Feature: HTTP GET
    In order to retrieve the current state of a collection
    As a collection consumer
    I want to allow the HTTP GET method

    Scenario Outline: HTTP Get verb, empty collection.
        Given I have started a message exchange
        When I perform a HTTP "GET" request to "/messages" with headers "Content-Type: application/json, Accept: application/json"
        Then I should see a response status code of "200" "OK"
        And I should see a "Server" header value "messengerd"
        And I should see a "Content-Type" header value "application/json; charset=utf-8"
        And I should see a "Content-Length" header value "34"
        And I should see a "Content-MD5" header value
        And I should see a "Connection" header value "close"
        And I should see a "Date" header value
        And I should see a "ETag" header value
        And I should see a "Last-Modified" header value
        And I should see a "Expires" header value "0"
        And I should see a "Pragma" header value "no-cache"
        And I should see a "Cache-Control" header value "private,max-age=0,no-cache,no-store"
        And I should see a "Vary" header value "Accept,Accept-Encoding,Accept-Charset,Accept-Language"
        And I should not see a "WWW-Authenticate" header value
        And I should not see a "Trailer" header value
        And I should not see a "Warning" header value
        And I should not see a "Accept-Ranges" header value
        And I should not see a "Content-Range" header value
        And I should not see a "Content-Encoding" header value
        And I should not see a "Content-Language" header value
        And I should not see a "Content-Location" header value
        And I should not see a "Retry-After" header value
        And I should not see a "Allow" header value
        And I should not see a "Age" header value
        And I should not see a "Location" header value
        And I should not see a "Via" header value
        And I should not see a "Upgrade" header value
        And I should not see a "Transfer-Encoding" header value
        And I should not see a "Proxy-Authentication" header value
        And I should see a response body describing the resource:
        """
        " { "meta": {                                                          "
        "     "count": 0                                                       "
        "   },                                                                 "
        "   "data": [ ]                                                        "
        " }                                                                    "
        """

    Scenario Outline: HTTP Get verb, non-empty collection.
        Given I have started a message daemon
        And I perform a HTTP "POST" request to "/messages" with headers "Content-Type: application/json, Accept: application/json":
        """
        " { "meta": {                                                                     "
        "     "key": "6198159a-a27b-4992-92e9-672d2ff68261"                               "
        "   },                                                                            "
        "   "data": {                                                                     "
        "     "to": "ben.crowhurst@outlook.com",                                          "
        "     "from": "ben.crowhurst@hotmail.com",                                        "
        "     "message": "If Cinderella's shoe fits perfectly, then why did it fall off?" "
        "   }                                                                             "
        " }                                                                               "
        """
        And I should see a response status code of "201" "Accepted"
        And I perform a HTTP "POST" request to "/messages" with headers "Content-Type: application/json, Accept: application/json":
        """
        " { "meta": {                                                          "
        "     "key": "2b7d54f8-ffbd-4236-9ff9-6b4cf48b6f9b"                    "
        "   },                                                                 "
        "   "data": {                                                          "
        "     "to": "ben.crowhurst@outlook.com",                               "
        "     "from": "ben.crowhurst@hotmail.com",                             "
        "     "message": "If we were created in God's image, how do we exist?" "
        "   }                                                                  "
        " }                                                                    "
        """
        And I should see a response status code of "201" "Accepted"
        When I perform a HTTP "GET" request to "/messages" with headers "Content-Type: application/json, Accept: application/json"
        Then I should see a response status code of "200" "OK"
        And I should see a "Server" header value "messengerd"
        And I should see a "Content-Type" header value "application/json; charset=utf-8"
        And I should see a "Content-Length" header value "123"
        And I should see a "Content-MD5" header value
        And I should see a "Connection" header value "close"
        And I should see a "Date" header value
        And I should see a "ETag" header value
        And I should see a "Last-Modified" header value
        And I should see a "Expires" header value "0"
        And I should see a "Pragma" header value "no-cache"
        And I should see a "Cache-Control" header value "private,max-age=0,no-cache,no-store"
        And I should see a "Vary" header value "Accept,Accept-Encoding,Accept-Charset,Accept-Language"
        And I should not see a "WWW-Authenticate" header value
        And I should not see a "Trailer" header value
        And I should not see a "Warning" header value
        And I should not see a "Accept-Ranges" header value
        And I should not see a "Content-Range" header value
        And I should not see a "Content-Encoding" header value
        And I should not see a "Content-Language" header value
        And I should not see a "Content-Location" header value
        And I should not see a "Retry-After" header value
        And I should not see a "Allow" header value
        And I should not see a "Age" header value
        And I should not see a "Location" header value
        And I should not see a "Via" header value
        And I should not see a "Upgrade" header value
        And I should not see a "Transfer-Encoding" header value
        And I should not see a "Proxy-Authentication" header value
        And I should see a response body describing the resource:
        """
        " { "meta": {                                                                                  "
        "     "count": 2                                                                               "
        "   },                                                                                         "
        "   "data": [ "6198159a-a27b-4992-92e9-672d2ff68261", "2b7d54f8-ffbd-4236-9ff9-6b4cf48b6f9b" ] "
        " }                                                                                            "
        """