package com.prueba.inditex.tmc.price.application.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PricesDto {

    private Long priceId;

    private Long productId;

    private Short brandId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Short priceList;

    private Boolean priority;

    private BigDecimal price;

    private String currency;
}
