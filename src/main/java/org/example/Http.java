package main.java.org.example;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Http {

//    Unirest.setTimeouts(5000, 10000);

    public String response;
    {
        try {
            response = Unirest.post("https://cloudpaygateway.59wanmei.com:8087/paygateway/smallpaygateway/trade")
                    .header("User-Agent", "Mozilla/5.0 (Linux; Android 11; SAMSUNG SM-G973U) AppleWebKit/537.36 (KHTML, like Gecko) SamsungBrowser/14.2 Chrome/87.0.4280.141 Mobile Safari/537.36")
                    .header("Accept", "application/json, text/plain, */*")
                    .header("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2")
                    .header("Origin", "https://cloudpaygateway.59wanmei.com:8087")
                    .header("Connection", "keep-alive")
                    .header("Referer", "https://cloudpaygateway.59wanmei.com:8087/pay/index.html?token=9d50babf-49b2-4c2f-a98f-f09a0d8e4857&_timestamp=1668578948720&customerId=1402")
                    .header("Sec-Fetch-Dest", "empty")
                    .header("Sec-Fetch-Mode", "cors")
                    .header("Sec-Fetch-Site", "same-origin")
                    .header("TE", "trailers")
                    .header("Cookie", "SERVERID=b82512854b884d91ab4d85c59fa4706e|1668580570|1668579876")
                    .header("Content-Type", "application/json;charset=utf-8")
                    .header("Host", "cloudpaygateway.59wanmei.com:8087")
                    .body("{\"timestamp\":\"2022-11-16 14:35:33\",\"method\":\"samllProgramGetRoomState\",\"bizcontent\":\"{\\\"payproid\\\":953,\\\"schoolcode\\\":\\\"1402\\\",\\\"roomverify\\\":\\\"2-1--3-7301\\\",\\\"businesstype\\\":2}\",\"sourceId\":2}")
                    .asString()
                    .getBody();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }
}
