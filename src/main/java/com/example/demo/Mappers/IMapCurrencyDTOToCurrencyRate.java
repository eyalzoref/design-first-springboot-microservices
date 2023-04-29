package com.example.demo.Mappers;

import com.example.demo.Models.CurrencyDTO;
import io.swagger.model.CurrencyRate;

public interface IMapCurrencyDTOToCurrencyRate {
    CurrencyRate map(CurrencyDTO currencyDTO, String base, String exchange);
}
