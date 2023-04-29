package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import io.swagger.model.CurrencyRate;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@ComponentScan(basePackages = { "io.swagger", "io.swagger.model", "io.swagger.api", "com.example.demo" })
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplication_ApiTest {
    
    String serverHost = "localhost";
    
    @LocalServerPort
    String serverPort;

    @Test
	public void test_getCurrencyExchangeRateApi_USD_EUR() {

        String base = "USD";
        String exchange = "EUR";

        // Given
        String url = "http://" + serverHost + ":" + serverPort + "/v2/rate/"+base+"/"+exchange;
		Response response = RestAssured.get(url);

        // When
		int statusCode = response.getStatusCode();
		assertEquals(statusCode, 200);

        // Then
        CurrencyRate currentyRate = (CurrencyRate)response.getBody().as(CurrencyRate.class);
        assertEquals(currentyRate.getBase(), base);
        assertEquals(currentyRate.getExchange(), exchange);
        assertNotEquals(currentyRate.getValue(), "0");
	}

}
