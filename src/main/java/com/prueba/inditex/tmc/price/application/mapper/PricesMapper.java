package com.prueba.inditex.tmc.price.application.mapper;

import com.prueba.inditex.tmc.price.infrastructure.response.PricesResponseDto;
import com.prueba.inditex.tmc.price.domain.model.Prices;
import com.prueba.inditex.tmc.price.application.dto.PricesDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PricesMapper {

    PricesMapper INSTANCE = Mappers.getMapper(PricesMapper.class);

    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "brandId", target = "brandId")
    @Mapping(source = "priceList", target = "priceList")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    @Mapping(source = "price", target = "price")
    PricesDto toServiceDto(Prices price);

    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "brandId", target = "brandId")
    @Mapping(source = "priceList", target = "priceList")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    @Mapping(source = "price", target = "price")
    PricesResponseDto toResponseDto(PricesDto serviceDto);
}
