/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.21).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.CurrencyRate;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-04-29T16:57:13.639+03:00")

@Validated
@Api(value = "rate", description = "the rate API")
@RequestMapping(value = "/v2")
public interface RateApi {

    @ApiOperation(value = "Get current currency rate exchange according to the specified currency base", nickname = "getRate", notes = "", response = CurrencyRate.class, tags={ "currency exchange", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = CurrencyRate.class),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 401, message = "Authentication information is missing or invalid"),
        @ApiResponse(code = 404, message = "Curreny not found") })
    @RequestMapping(value = "/rate/{base}/{exchange}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<CurrencyRate> getRate(@ApiParam(value = "Currency base for exchange rate calculation. for example: USD",required=true) @PathVariable("base") String base,@ApiParam(value = "Currency exchange rate calculation. for example: EUR",required=true) @PathVariable("exchange") String exchange);

}
