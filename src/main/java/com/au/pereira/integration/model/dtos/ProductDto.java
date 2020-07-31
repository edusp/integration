package com.au.pereira.integration.model.dtos;

import com.au.pereira.integration.model.Category;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Builder
@JsonDeserialize(builder = ProductDto.ProductDtoBuilder.class)
@Value
public class ProductDto {

    @JsonProperty private String name;
    @JsonProperty private String description;
    @JsonProperty private BigDecimal price;
    @JsonProperty private Category category;

    public static class ProductDtoBuilder{}


}
