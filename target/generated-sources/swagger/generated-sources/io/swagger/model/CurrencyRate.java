package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CurrencyRate
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-04-29T16:57:13.639+03:00")


public class CurrencyRate   {
  @JsonProperty("base")
  private String base = null;

  @JsonProperty("exchange")
  private String exchange = null;

  @JsonProperty("value")
  private String value = null;

  public CurrencyRate base(String base) {
    this.base = base;
    return this;
  }

  /**
   * Get base
   * @return base
  **/
  @ApiModelProperty(value = "")


  public String getBase() {
    return base;
  }

  public void setBase(String base) {
    this.base = base;
  }

  public CurrencyRate exchange(String exchange) {
    this.exchange = exchange;
    return this;
  }

  /**
   * Get exchange
   * @return exchange
  **/
  @ApiModelProperty(value = "")


  public String getExchange() {
    return exchange;
  }

  public void setExchange(String exchange) {
    this.exchange = exchange;
  }

  public CurrencyRate value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
  **/
  @ApiModelProperty(value = "")


  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CurrencyRate currencyRate = (CurrencyRate) o;
    return Objects.equals(this.base, currencyRate.base) &&
        Objects.equals(this.exchange, currencyRate.exchange) &&
        Objects.equals(this.value, currencyRate.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(base, exchange, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CurrencyRate {\n");
    
    sb.append("    base: ").append(toIndentedString(base)).append("\n");
    sb.append("    exchange: ").append(toIndentedString(exchange)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

