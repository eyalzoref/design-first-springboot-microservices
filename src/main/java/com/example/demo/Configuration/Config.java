package com.example.demo.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.demo.Mappers.IMapCurrencyDTOToCurrencyRate;
import com.example.demo.Mappers.MapCurrencyDTOToCurrencyRate;

@Configuration
public class Config {
 
    @Bean
    @Primary
    public IMapCurrencyDTOToCurrencyRate mapCurrencyDTOToCurrencyRate() {
        return (IMapCurrencyDTOToCurrencyRate) new MapCurrencyDTOToCurrencyRate();
    }
 
}
