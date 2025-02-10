package com.prueba.inditex.tmc.price.domain.service;

import com.prueba.inditex.tmc.price.application.dto.PricesDto;

import java.time.LocalDateTime;
import java.util.List;

public interface PricesService {

    List<PricesDto> findPriceByFilter(Long productId, Short brandId, LocalDateTime applicationDate);
}
