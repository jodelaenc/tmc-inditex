package com.prueba.inditex.tmc.price.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "PRICES")
@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class Prices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long priceId;

    @Column(name = "PRODUCT_ID", nullable = false)
    private Long productId;

    @Column(name = "BRAND_ID", nullable = false)
    private Short brandId;

    @Column(name = "START_DATE", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "END_DATE", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "PRICE_LIST", nullable = false)
    private Short priceList;

    @Column(name = "PRIORITY", nullable = false)
    private Boolean priority;

    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;

    @Column(name = "CURR", nullable = false)
    private String currency;


}
