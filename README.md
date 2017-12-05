# rest-call
A light weight service for calling rest get and post request with token authentication integrated.

Simple different constructor, with and without body for get and post request with single method calling.

Usages example:
Map<String,String> headerParams = new HashMap<String, String>(){{
            put("Content-Type","application/json");
        }};
String body = "{ \"key\":\"value\" }";
RestService service = new RestService("https://api.myurl.com:port/samplrUrl", body, headerParams);
Or
RestService service = new RestService("https://api.myurl.com:port/samplrUrl", headerParams);
Or 
RestService service = new RestService("https://api.myurl.com:port/samplrUrl", body, headerParams, pingUrl, clientId, clientSecret);
Or
RestService service = new RestService("https://api.myurl.com:port/samplrUrl", headerParams, pingUrl, clientId, clientSecret);
Or easy for configuration such as bean creation with
RestService service = new RestService(pingUrl, clientId, clientSecret);

Returns back JsonObject from Google Gson library.
