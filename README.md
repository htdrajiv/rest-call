# rest-call
A light weight service for calling rest get and post request with token authentication integrated.<br /><br />

Simple different constructor, with and without body for get and post request with single method calling.<br /><br />

Usages example:<br />
Map<String,String> headerParams = new HashMap<String, String>(){{<br />
            put("Content-Type","application/json");<br />
        }};<br />
String body = "{ \"key\":\"value\" }";<br />
RestService service = new RestService("https://api.myurl.com:port/samplrUrl", body, headerParams);<br />
Or<br />
RestService service = new RestService("https://api.myurl.com:port/samplrUrl", headerParams);<br />
Or<br />
RestService service = new RestService("https://api.myurl.com:port/samplrUrl", body, headerParams, pingUrl, clientId, clientSecret);<br />
Or<br />
RestService service = new RestService("https://api.myurl.com:port/samplrUrl", headerParams, pingUrl, clientId, clientSecret);<br />
Or<br />
easy for configuration such as bean creation with<br />
RestService service = new RestService(pingUrl, clientId, clientSecret);<br /><br />

Returns back JsonObject from Google Gson library.<br />
