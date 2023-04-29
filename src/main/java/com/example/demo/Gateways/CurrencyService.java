package com.example.demo.Gateways;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.Models.CurrencyDTO;

@FeignClient(name="currency", url="${feign.url}")
public interface CurrencyService {
    //
    // Formats:
    // 
    // date
    //  The date should either be latest or in YYYY-MM-DD format
    //   version 
    //   The api version number (should use 1)
    // endpoint
    // currencies
    //   GET https://api.exchangerate.host/latest
    //
    @RequestMapping(method = RequestMethod.GET, value = "/latest?base={base}", consumes = "application/json")
    CurrencyDTO getCurrencies(@PathVariable("base") String base);
}

