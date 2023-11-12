package main.java.org.example;

public class Main {

    public static void main(String[] args) {
        Http http = new Http();
        Json json = new Json();
        Email email = new Email();

        json.processResponse(http);

        email.sendEmail("3085971975@qq.com", "\uD83D\uDEA8电费预警\uD83D\uDEA8", "电量剩余:" + json.doubleQuantity + "度");

        System.out.println("电量剩余:" + "\033[38;2;255;165;0m" +json.doubleQuantity + "\u001B[0m" + "度");
    }
}

//        long startTime = System.nanoTime();
//        int count = 0;
//        Timer timer = new Timer();
//        // 每隔30分钟执行一次
//        timer.schedule(new MyTask(), 0, 10 * 1000);
//        count++;
//        long endTime = System.nanoTime();
//        long duration = (endTime - startTime) / 1000000;  // 单位为毫秒
//        System.out.println("代码执行了 " + count + " 次，耗时 " + duration + " 毫秒。");


//    static class MyTask extends TimerTask {
//        public void run() {


//                Unirest.setTimeouts(0, 0);
//
//                String response;
//                try {
//                    response = Unirest.post("https://cloudpaygateway.59wanmei.com:8087/paygateway/smallpaygateway/trade")
//                            .header("User-Agent", "Mozilla/5.0 (Linux; Android 11; SAMSUNG SM-G973U) AppleWebKit/537.36 (KHTML, like Gecko) SamsungBrowser/14.2 Chrome/87.0.4280.141 Mobile Safari/537.36")
//                            .header("Accept", "application/json, text/plain, */*")
//                            .header("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2")
//                            .header("Origin", "https://cloudpaygateway.59wanmei.com:8087")
//                            .header("Connection", "keep-alive")
//                            .header("Referer", "https://cloudpaygateway.59wanmei.com:8087/pay/index.html?token=9d50babf-49b2-4c2f-a98f-f09a0d8e4857&_timestamp=1668578948720&customerId=1402")
//                            .header("Sec-Fetch-Dest", "empty")
//                            .header("Sec-Fetch-Mode", "cors")
//                            .header("Sec-Fetch-Site", "same-origin")
//                            .header("TE", "trailers")
//                            .header("Cookie", "SERVERID=b82512854b884d91ab4d85c59fa4706e|1668580570|1668579876")
//                            .header("Content-Type", "application/json;charset=utf-8")
//                            .header("Host", "cloudpaygateway.59wanmei.com:8087")
//                            .body("{\"timestamp\":\"2022-11-16 14:35:33\",\"method\":\"samllProgramGetRoomState\",\"bizcontent\":\"{\\\"payproid\\\":953,\\\"schoolcode\\\":\\\"1402\\\",\\\"roomverify\\\":\\\"2-1--3-7301\\\",\\\"businesstype\\\":2}\",\"sourceId\":2}")
//                            .asString()
//                            .getBody();
//                } catch (UnirestException e) {
//                    throw new RuntimeException(e);
//                }
//
//                //获取json字符串中的quantity值
//                ObjectMapper objectMapper = new ObjectMapper();
//
//                JsonNode jsonNode;
//                try {
//                    jsonNode = objectMapper.readTree(response);
//                } catch (JsonProcessingException e) {
//                    throw new RuntimeException(e);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//
//                //提取json字符串中的电量值
//                String quantity = jsonNode.get("businessData").get("quantity").textValue();
//
//                //将提取到的值从string强转为double类型
//                Double doubleQuantity = Double.parseDouble(quantity);

                //如果剩余电量少于2
//                if (doubleQuantity <= 4){
//                //则发送邮件提示
//
//                    //创建一个配置文件并保存
//                    Properties properties = new Properties();
//                    properties.setProperty("mail.host","smtp.qq.com");
//                    properties.setProperty("mail.transport.protocol","smtp");
//                    properties.setProperty("mail.smtp.auth","true");
//
//                    //QQ存在一个特性设置SSL加密
//                    MailSSLSocketFactory sf;
//                    try {
//                        sf = new MailSSLSocketFactory();
//                    } catch (GeneralSecurityException e) {
//                        throw new RuntimeException(e);
//                    }
//                    sf.setTrustAllHosts(true);
//                    properties.put("mail.smtp.ssl.enable", "true");
//                    properties.put("mail.smtp.ssl.socketFactory", sf);
//
//                    //创建一个session对象
//                    Session session = Session.getDefaultInstance(properties, new Authenticator() {
//                        @Override
//                        protected PasswordAuthentication getPasswordAuthentication() {
//                            return new PasswordAuthentication("hxdfserver@qq.com","qccfpwlpfjjzccjg");
//                        }
//                    });
//
//                    //是否开启debug模式
//                    session.setDebug(false);
//
//                    //获取连接对象
//                    Transport transport;
//                    try {
//                        transport = session.getTransport();
//                    } catch (NoSuchProviderException e) {
//                        throw new RuntimeException(e);
//                    }
//
//                    //连接服务器
//                    try {
//                        transport.connect("smtp.qq.com","hxdfserver@qq.com","qccfpwlpfjjzccjg");
//                    } catch (MessagingException e) {
//                        throw new RuntimeException(e);
//                    }
//
//                    //创建邮件对象
//                    MimeMessage mimeMessage = new MimeMessage(session);
//
//                    //邮件发送人
//                    try {
//                        mimeMessage.setFrom(new InternetAddress("hxdfserver@qq.com"));
//                    } catch (MessagingException e) {
//                        throw new RuntimeException(e);
//                    }
//
//                    //邮件接收人
//                    try {
//                        mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress("m3085971975@hotmail.com"));
//                    } catch (MessagingException e) {
//                        throw new RuntimeException(e);
//                    }
//
//                    try {
//                        mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress("3085971975@qq.com"));
//                    } catch (MessagingException e) {
//                        throw new RuntimeException(e);
//                    }
//
//                    //邮件标题
//                    try {
//                        mimeMessage.setSubject("🚨电费预警🚨");
//                    } catch (MessagingException e) {
//                        throw new RuntimeException(e);
//                    }
//
//                    //邮件内容
//                    try {
//                        mimeMessage.setContent("电费仅剩:" + quantity + "度","text/html;charset=UTF-8");
//                    } catch (MessagingException e) {
//                        throw new RuntimeException(e);
//                    }
//
//                    //发送邮件
//                    try {
//                        transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients());
//                    } catch (MessagingException e) {
//                        throw new RuntimeException(e);
//                    }
//
//                    //关闭连接
//                    try {
//                        transport.close();
//                    } catch (MessagingException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//        }
//    }
//}

//    public static void OkHttp() throws UnirestException, JsonProcessingException {
//        Unirest.setTimeouts(0, 0);
//
//        String response = Unirest.post("https://cloudpaygateway.59wanmei.com:8087/paygateway/smallpaygateway/trade")
//                .header("User-Agent", "Mozilla/5.0 (Linux; Android 11; SAMSUNG SM-G973U) AppleWebKit/537.36 (KHTML, like Gecko) SamsungBrowser/14.2 Chrome/87.0.4280.141 Mobile Safari/537.36")
//                .header("Accept", "application/json, text/plain, */*")
//                .header("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2")
//                .header("Origin", "https://cloudpaygateway.59wanmei.com:8087")
//                .header("Connection", "keep-alive")
//                .header("Referer", "https://cloudpaygateway.59wanmei.com:8087/pay/index.html?token=9d50babf-49b2-4c2f-a98f-f09a0d8e4857&_timestamp=1668578948720&customerId=1402")
//                .header("Sec-Fetch-Dest", "empty")
//                .header("Sec-Fetch-Mode", "cors")
//                .header("Sec-Fetch-Site", "same-origin")
//                .header("TE", "trailers")
//                .header("Cookie", "SERVERID=b82512854b884d91ab4d85c59fa4706e|1668580570|1668579876")
//                .header("Content-Type", "application/json;charset=utf-8")
//                .header("Host", "cloudpaygateway.59wanmei.com:8087")
//                .body("{\"timestamp\":\"2022-11-16 14:35:33\",\"method\":\"samllProgramGetRoomState\",\"bizcontent\":\"{\\\"payproid\\\":953,\\\"schoolcode\\\":\\\"1402\\\",\\\"roomverify\\\":\\\"2-1--5-7520\\\",\\\"businesstype\\\":2}\",\"sourceId\":2}")
//                .asString()
//                .getBody();
//
//       //获取json字符串中的quantity值
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        JsonNode jsonNode = objectMapper.readTree(response);
//
//        String quantity = jsonNode.get("businessData").get("quantity").textValue();
//
//        System.out.println(quantity);
//
//        }
//    static void Person() throws JsonProcessingException {
//        //获取json字符串中的quantity值
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        JsonNode jsonNode = objectMapper.readTree(response);
//
//        String quantity = jsonNode.get("businessData").get("quantity").textValue();
//
//        System.out.println(quantity);
//
//    }
