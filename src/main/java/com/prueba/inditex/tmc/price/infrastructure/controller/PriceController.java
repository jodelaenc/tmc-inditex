package com.prueba.inditex.tmc.price.infrastructure.controller;

import com.prueba.inditex.tmc.price.infrastructure.response.PricesResponseDto;
import com.prueba.inditex.tmc.price.domain.service.PricesService;
import com.prueba.inditex.tmc.price.application.dto.PricesDto;
import com.prueba.inditex.tmc.price.application.mapper.PricesMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/prices")
@Tag(name = "Price Controller", description = "Controlador para gestionar los precios de productos")
public class PriceController {
    
    @Autowired
    private PricesService service;

    @Autowired
    private PricesMapper mapper;

    @Operation(
            summary = "Obtener precios",
            description = "Devuelve el precio de un producto según la marca, el identificador del producto y la fecha de aplicación."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Precio obtenido correctamente"),
            @ApiResponse(responseCode = "400", description = "Parámetros incorrectos"),
            @ApiResponse(responseCode = "404", description = "No se encontró un precio para los parámetros dados")
    })
    @GetMapping("/getPrices")
    public List<PricesResponseDto> getPrice(@RequestParam(value = "productId",required = false) @Parameter(description = "Identificador del producto")Long productId,
                                      @RequestParam(value = "brandId",required = false) @Parameter(description = "Identificador de la marca") Short brandId,
                                      @RequestParam(value = "date",required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @Parameter(description = "Fecha de aplicación en formato yyyy-MM-dd HH:mm:ss") LocalDateTime date) {
        List<PricesDto> listDto = this.service.findPriceByFilter(productId, brandId, date);
        return listDto.stream().map(p -> this.mapper.toResponseDto(p)).toList();
    }
    
    
}
