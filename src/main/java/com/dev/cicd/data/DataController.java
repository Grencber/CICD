package com.dev.cicd.data;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class DataController {

    @GetMapping("/")
    public String healthCheck(){
        return "Health check is OK";
    }

    @GetMapping("/version")
    public String version(){
        return "The actual version is 1.0.0";
    }

    @GetMapping("/nations")
    public JsonNode getRandomNations(){
        var objectMapper = new ObjectMapper();
        var faker = new Faker(new Locale("en-US"));
        var nations = objectMapper.createArrayNode();
        for (int i = 0; i < 10; i++) {
            var nation = faker.nation();
            nations.add(objectMapper.createObjectNode()
                            .put("nationality",nation.nationality())
                            .put("capitalCity",nation.capitalCity())
                            .put("flag",nation.flag())
                            .put("language",nation.language())
            );
        }
        return nations;
    }

    @GetMapping("/currencies")
    public JsonNode getCurrencies(){
        var objectMapper = new ObjectMapper();
        var faker = new Faker(new Locale("en-US"));
        var currencies = objectMapper.createArrayNode();
        for (int i = 0; i < 10; i++) {
            var currency = faker.currency();
            currencies.add(objectMapper.createObjectNode()
                                        .put("currency", currency.name())
                                        .put("currencyCode", currency.code()));

        }
        return currencies;
    }
}
