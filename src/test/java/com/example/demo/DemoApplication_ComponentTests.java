package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.WebServerException;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.Controllers.ControllerV2;
import com.example.demo.Controllers.HealthController;
import com.example.demo.Gateways.CurrencyService;
import com.example.demo.Mappers.IMapCurrencyDTOToCurrencyRate;
import com.example.demo.Mappers.MapCurrencyDTOToCurrencyRate;
import com.example.demo.Models.CurrencyDTO;
import com.example.demo.Models.HealthCheck;
import com.example.demo.Models.MOTD;

import io.swagger.model.CurrencyRate;

@ExtendWith(SpringExtension.class)
@ComponentScan(basePackages = { "io.swagger", "io.swagger.model", "io.swagger.api", "com.example.demo" })
@SpringBootTest
class DemoApplication_ComponentTests {

	@Autowired
	HealthController controller;

	@Autowired
	IMapCurrencyDTOToCurrencyRate mapCurrencyDTOToCurrencyRate;

	@InjectMocks	
	ControllerV2 controllerV2;

	@Mock
	CurrencyService currencySrv;

	@Test
	void testHealthSuccess() {
		HealthCheck health = controller.health();
		String lower = health.message.toLowerCase();
		assertTrue(lower.equals("success"), "default string should success");
	}

	@Test
	void testGetRate_Success_MoreThanZeroResults(){
		// Given
		CurrencyDTO currencyDTO = new CurrencyDTO();
		currencyDTO.base = "USD";
		currencyDTO.motd = new MOTD();
		currencyDTO.motd.msg = "my message";
		currencyDTO.motd.url = "http://url.com";
		currencyDTO.success = true;
		currencyDTO.rates = new HashMap<String, Double>(); 
		currencyDTO.rates.put("EUR", 1.111);

		// When
		when(currencySrv.getCurrencies("USD")).thenReturn(currencyDTO);
		controllerV2.setMapCurrencyDTOToCurrencyRate((MapCurrencyDTOToCurrencyRate) mapCurrencyDTOToCurrencyRate);
		ResponseEntity<CurrencyRate> response = controllerV2.getRate("USD", "EUR");
		CurrencyRate currency = response.getBody();
		
		// Then
		assertTrue(currency.getBase().equalsIgnoreCase("USD"), "should be USD base");
		assertTrue(!currency.getValue().isEmpty(), "should not be empty");
	}

	@Test
	void testGetRate_Failure_External_Api_Error(){
		// Given
		when(currencySrv.getCurrencies("USD")).thenThrow(new RuntimeException("internal server error"));

		// When
		ResponseEntity<CurrencyRate> response = controllerV2.getRate("USD", "EUR");
		
		// Then
		assertTrue(response.getStatusCode().equals(HttpStatus.INTERNAL_SERVER_ERROR), "should be server error");
	}
}

