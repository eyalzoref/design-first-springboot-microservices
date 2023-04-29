package com.example.demo;

import static org.mockito.ArgumentMatchers.isNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.Mappers.IMapCurrencyDTOToCurrencyRate;
import com.example.demo.Mappers.MapCurrencyDTOToCurrencyRate;
import com.example.demo.Models.CurrencyDTO;
import com.example.demo.Models.MOTD;

import io.swagger.model.CurrencyRate;
import jakarta.validation.constraints.AssertTrue;

public class DemoApplication_UnitTests {

    @Test
    void test_Failure_NullInput() {
        IMapCurrencyDTOToCurrencyRate mapperCurrencyDTOToCurrencyRate = (IMapCurrencyDTOToCurrencyRate) new MapCurrencyDTOToCurrencyRate(); 
        CurrencyRate currenyRate = mapperCurrencyDTOToCurrencyRate.map(null, null, null);
		assertTrue(currenyRate == null, "should return null");
	}

    @Test
    void test_Success() {
        // given
        CurrencyDTO dto = new CurrencyDTO();
        dto.motd = new MOTD();
        dto.base="USD";
		dto.rates = new HashMap<>();
        dto.rates.put("EUR", 1.111);
        dto.success = true;

        // when
        IMapCurrencyDTOToCurrencyRate mapperCurrencyDTOToCurrencyRate = (IMapCurrencyDTOToCurrencyRate) new MapCurrencyDTOToCurrencyRate(); 
        CurrencyRate currenyRate = mapperCurrencyDTOToCurrencyRate.map(dto, "USD", "EUR");
		
        // then
        assertTrue(currenyRate != null, "should not be null");
        String value = currenyRate.getValue();
        assertTrue(value.equals("1.111000"), "value should be 1.111");
	}
}
