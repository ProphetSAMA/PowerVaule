package main.java.org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Json {
    Double doubleQuantity;

    // 获取json字符串中的quantity值
    ObjectMapper objectMapper = new ObjectMapper();

    public void processResponse(Http http) {
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(http.response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 提取json字符串中的电量值
        String quantity = jsonNode.get("businessData").get("quantity").textValue();

        // 将提取到的值从string强转为double类型，并赋值给类的成员变量
        this.doubleQuantity = Double.parseDouble(quantity);
    }
}
