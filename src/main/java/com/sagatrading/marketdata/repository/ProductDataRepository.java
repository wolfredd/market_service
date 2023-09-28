package com.sagatrading.marketdata.repository;

import com.sagatrading.marketdata.model.ProductData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDataRepository extends JpaRepository<ProductData, Integer> {
}
