package com.prueba.inditex.tmc.price;

import com.prueba.inditex.tmc.price.infrastructure.controller.PriceController;
import com.prueba.inditex.tmc.price.infrastructure.response.PricesResponseDto;
import com.prueba.inditex.tmc.price.domain.service.PricesService;
import com.prueba.inditex.tmc.price.application.dto.PricesDto;
import com.prueba.inditex.tmc.price.application.mapper.PricesMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class PricesTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private PricesService pricesService;

    @Mock
    private PricesMapper pricesMapper;

    @InjectMocks
    private PriceController priceController;

    @BeforeEach
    public void setup() {
        // Inicializa MockMvc
        mockMvc = MockMvcBuilders.standaloneSetup(priceController).build();
    }

    @Test
    void testGetPricesTest1() throws Exception {
        Long productId = 35455L;
        Short brandId = 1;
        LocalDateTime date = LocalDateTime.parse("2020-06-14T10:00:00");

        PricesDto pricesDto = new PricesDto();
        pricesDto.setProductId(productId);
        pricesDto.setBrandId(brandId);
        pricesDto.setStartDate(LocalDateTime.parse("2020-06-14T00:00:00"));
        pricesDto.setEndDate(LocalDateTime.parse("2020-12-31T23:59:59"));
        pricesDto.setPrice(new BigDecimal("35.50"));

        PricesResponseDto responseDto = new PricesResponseDto();
        responseDto.setProductId(productId);
        responseDto.setBrandId(brandId);
        responseDto.setPrice(new BigDecimal("35.50"));
        responseDto.setStartDate(LocalDateTime.parse("2020-06-14T00:00:00"));
        responseDto.setEndDate(LocalDateTime.parse("2020-12-31T23:59:59"));

        List<PricesDto> pricesDtos = List.of(pricesDto);
        when(pricesService.findPriceByFilter(productId, brandId, date)).thenReturn(pricesDtos);
        when(pricesMapper.toResponseDto(pricesDto)).thenReturn(responseDto);

        // Realizar la solicitud GET
        mockMvc.perform(MockMvcRequestBuilders.get("/prices/getPrices")
                        .param("productId", productId.toString())
                        .param("brandId", brandId.toString())
                        .param("date", "2020-06-14 10:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].productId").value(productId))
                .andExpect(jsonPath("$[0].price").value(35.50))
                .andExpect(jsonPath("$[0].startDate").value("2020-06-14T00:00:00"))
                .andExpect(jsonPath("$[0].endDate").value("2020-12-31T23:59:59"));
    }

    @Test
    void testGetPricesTest2() throws Exception {
        Long productId = 35455L;
        Short brandId = 1;
        LocalDateTime date = LocalDateTime.parse("2020-06-14T16:00:00");

        PricesDto pricesDto = new PricesDto();
        pricesDto.setProductId(productId);
        pricesDto.setBrandId(brandId);
        pricesDto.setStartDate(LocalDateTime.parse("2020-06-14T15:00:00"));
        pricesDto.setEndDate(LocalDateTime.parse("2020-06-14T18:30:00"));
        pricesDto.setPrice(BigDecimal.valueOf(25.45));

        PricesResponseDto responseDto = new PricesResponseDto();
        responseDto.setProductId(productId);
        responseDto.setBrandId(brandId);
        responseDto.setPrice(BigDecimal.valueOf(25.45));
        responseDto.setStartDate(LocalDateTime.parse("2020-06-14T15:00:00"));
        responseDto.setEndDate(LocalDateTime.parse("2020-06-14T18:30:00"));

        List<PricesDto> pricesDtos = List.of(pricesDto);
        when(pricesService.findPriceByFilter(productId, brandId, date)).thenReturn(pricesDtos);
        when(pricesMapper.toResponseDto(pricesDto)).thenReturn(responseDto);

        // Realizar la solicitud GET
        mockMvc.perform(MockMvcRequestBuilders.get("/prices/getPrices")
                        .param("productId", productId.toString())
                        .param("brandId", brandId.toString())
                        .param("date", "2020-06-14 16:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].productId").value(productId))
                .andExpect(jsonPath("$[0].price").value(25.45))
                .andExpect(jsonPath("$[0].startDate").value("2020-06-14T15:00:00"))
                .andExpect(jsonPath("$[0].endDate").value("2020-06-14T18:30:00"));
    }

    @Test
    void testGetPricesTest3() throws Exception {
        Long productId = 35455L;
        Short brandId = 1;
        LocalDateTime date = LocalDateTime.parse("2020-06-14T21:00:00");

        PricesDto pricesDto = new PricesDto();
        pricesDto.setProductId(productId);
        pricesDto.setBrandId(brandId);
        pricesDto.setStartDate(LocalDateTime.parse("2020-06-14T00:00:00"));
        pricesDto.setEndDate(LocalDateTime.parse("2020-12-31T23:59:59"));
        pricesDto.setPrice(BigDecimal.valueOf(35.50));

        PricesResponseDto responseDto = new PricesResponseDto();
        responseDto.setProductId(productId);
        responseDto.setBrandId(brandId);
        responseDto.setPrice(BigDecimal.valueOf(35.50));
        responseDto.setStartDate(LocalDateTime.parse("2020-06-14T00:00:00"));
        responseDto.setEndDate(LocalDateTime.parse("2020-12-31T23:59:59"));

        List<PricesDto> pricesDtos = List.of(pricesDto);
        when(pricesService.findPriceByFilter(productId, brandId, date)).thenReturn(pricesDtos);
        when(pricesMapper.toResponseDto(pricesDto)).thenReturn(responseDto);

        // Realizar la solicitud GET
        mockMvc.perform(MockMvcRequestBuilders.get("/prices/getPrices")
                        .param("productId", productId.toString())
                        .param("brandId", brandId.toString())
                        .param("date", "2020-06-14 21:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].productId").value(productId))
                .andExpect(jsonPath("$[0].price").value(35.50))
                .andExpect(jsonPath("$[0].startDate").value("2020-06-14T00:00:00"))
                .andExpect(jsonPath("$[0].endDate").value("2020-12-31T23:59:59"));
    }

    @Test
    void testGetPricesTest4() throws Exception {
        Long productId = 35455L;
        Short brandId = 1;
        LocalDateTime date = LocalDateTime.parse("2020-06-15T10:00:00");

        PricesDto pricesDto = new PricesDto();
        pricesDto.setProductId(productId);
        pricesDto.setBrandId(brandId);
        pricesDto.setStartDate(LocalDateTime.parse("2020-06-15T00:00:00"));
        pricesDto.setEndDate(LocalDateTime.parse("2020-06-15T11:00:00"));
        pricesDto.setPrice(BigDecimal.valueOf(30.50));

        PricesResponseDto responseDto = new PricesResponseDto();
        responseDto.setProductId(productId);
        responseDto.setBrandId(brandId);
        responseDto.setPrice(BigDecimal.valueOf(30.50));
        responseDto.setStartDate(LocalDateTime.parse("2020-06-15T00:00:00"));
        responseDto.setEndDate(LocalDateTime.parse("2020-06-15T11:00:00"));

        List<PricesDto> pricesDtos = List.of(pricesDto);
        when(pricesService.findPriceByFilter(productId, brandId, date)).thenReturn(pricesDtos);
        when(pricesMapper.toResponseDto(pricesDto)).thenReturn(responseDto);

        // Realizar la solicitud GET
        mockMvc.perform(MockMvcRequestBuilders.get("/prices/getPrices")
                        .param("productId", productId.toString())
                        .param("brandId", brandId.toString())
                        .param("date", "2020-06-15 10:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].productId").value(productId))
                .andExpect(jsonPath("$[0].price").value(30.50))
                .andExpect(jsonPath("$[0].startDate").value("2020-06-15T00:00:00"))
                .andExpect(jsonPath("$[0].endDate").value("2020-06-15T11:00:00"));
    }

    @Test
    void testGetPricesTest5() throws Exception {
        Long productId = 35455L;
        Short brandId = 1;
        LocalDateTime date = LocalDateTime.parse("2020-06-16T21:00:00");

        PricesDto pricesDto = new PricesDto();
        pricesDto.setProductId(productId);
        pricesDto.setBrandId(brandId);
        pricesDto.setStartDate(LocalDateTime.parse("2020-06-16T18:00:00"));
        pricesDto.setEndDate(LocalDateTime.parse("2020-06-16T23:59:59"));
        pricesDto.setPrice(BigDecimal.valueOf(38.99));

        PricesResponseDto responseDto = new PricesResponseDto();
        responseDto.setProductId(productId);
        responseDto.setBrandId(brandId);
        responseDto.setPrice(BigDecimal.valueOf(38.99));
        responseDto.setStartDate(LocalDateTime.parse("2020-06-16T18:00:00"));
        responseDto.setEndDate(LocalDateTime.parse("2020-06-16T23:59:59"));

        List<PricesDto> pricesDtos = List.of(pricesDto);
        when(pricesService.findPriceByFilter(productId, brandId, date)).thenReturn(pricesDtos);
        when(pricesMapper.toResponseDto(pricesDto)).thenReturn(responseDto);

        // Realizar la solicitud GET
        mockMvc.perform(MockMvcRequestBuilders.get("/prices/getPrices")
                        .param("productId", productId.toString())
                        .param("brandId", brandId.toString())
                        .param("date", "2020-06-16 21:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].productId").value(productId))
                .andExpect(jsonPath("$[0].price").value(38.99))
                .andExpect(jsonPath("$[0].startDate").value("2020-06-16T18:00:00"))
                .andExpect(jsonPath("$[0].endDate").value("2020-06-16T23:59:59"));
    }

}
