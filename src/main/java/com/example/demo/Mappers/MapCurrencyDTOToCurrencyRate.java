package com.example.demo.Mappers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.example.demo.Models.CurrencyDTO;
import io.swagger.model.CurrencyRate;

public class MapCurrencyDTOToCurrencyRate implements IMapCurrencyDTOToCurrencyRate{

    @Override
    public CurrencyRate map(CurrencyDTO currencyDTO, String base, String exchange){
        if(currencyDTO == null) return null;

        CurrencyRate currency = new CurrencyRate();
		currency.setBase(base);
		currency.setExchange(exchange);
		Double rate = currencyDTO.rates.getOrDefault(exchange, 0.0);
		currency.setValue(String.format("%f", rate));
        return currency;
    }
}
