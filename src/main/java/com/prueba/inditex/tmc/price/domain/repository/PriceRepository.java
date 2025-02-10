package com.prueba.inditex.tmc.price.domain.repository;

import com.prueba.inditex.tmc.price.domain.model.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Prices,Long> {

    @Query("SELECT p FROM Prices p WHERE " +
            "(:productId IS NULL OR p.productId = :productId) " +
            "AND (:brandId IS NULL OR p.brandId = :brandId) " +
            "AND (:applicationDate IS NULL OR (p.startDate <= :applicationDate AND p.endDate >= :applicationDate))")
    List<Prices> findPriceByFilter(@Param("productId") Long productId,
                                            @Param("brandId") Short brandId,
                                            @Param("applicationDate") LocalDateTime applicationDate);
}
