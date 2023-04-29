package com.example.demo.Controllers;

import javax.inject.Qualifier;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Gateways.CurrencyService;
import com.example.demo.Mappers.IMapCurrencyDTOToCurrencyRate;
import com.example.demo.Mappers.MapCurrencyDTOToCurrencyRate;
import com.example.demo.Models.CurrencyDTO;

import io.swagger.api.RateApi;
import io.swagger.model.CurrencyRate;

@RestController
public class ControllerV2 implements RateApi{

    @Autowired
    private IMapCurrencyDTOToCurrencyRate mapCurrencyDTOToCurrencyRate;

    @Autowired
	private CurrencyService currencySrv;
    
   @Override
    public ResponseEntity<CurrencyRate> getRate(@PathVariable("base") String base, @PathVariable("exchange") String exchange){
  
        CurrencyDTO currencyResponse = null;
        try {
            currencyResponse = currencySrv.getCurrencies(base);
        } catch (Exception e) {
            return new ResponseEntity<CurrencyRate>(null, null, HttpStatus.SC_INTERNAL_SERVER_ERROR);
        }
        
        CurrencyRate currency = mapCurrencyDTOToCurrencyRate.map(currencyResponse, base, exchange);
        return ResponseEntity.ok(currency);
    }

    public void setMapCurrencyDTOToCurrencyRate(MapCurrencyDTOToCurrencyRate mapCurrencyDTOToCurrencyRate){
        this.mapCurrencyDTOToCurrencyRate = (IMapCurrencyDTOToCurrencyRate) mapCurrencyDTOToCurrencyRate;
    }

}
