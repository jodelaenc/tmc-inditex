package com.prueba.inditex.tmc.price.application.services;

import com.prueba.inditex.tmc.price.domain.model.Prices;
import com.prueba.inditex.tmc.price.domain.repository.PriceRepository;
import com.prueba.inditex.tmc.price.domain.service.PricesService;
import com.prueba.inditex.tmc.price.application.dto.PricesDto;
import com.prueba.inditex.tmc.price.application.mapper.PricesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PricesServiceImpl implements PricesService {
    
    @Autowired
    private PriceRepository repository;
    @Autowired
    private PricesMapper mapper;
    
    @Override
    public List<PricesDto> findPriceByFilter(Long productId, Short brandId, LocalDateTime applicationDate) {
        List<Prices> listPrices = this.repository.findPriceByFilter(productId, brandId, applicationDate);
        return listPrices.stream().map(p -> this.mapper.toServiceDto(p)).toList();
    }
}
