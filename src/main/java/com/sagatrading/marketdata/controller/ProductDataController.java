package com.sagatrading.marketdata.controller;

import com.sagatrading.marketdata.service.ProductDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductDataController {

    @Autowired
    private ProductDataService productDataService;

    @GetMapping("/product-data")
    public void getProductData() {
        productDataService.addProduct();
    }

    @GetMapping("/market-price-history")
    public void getMarketPriceHistory() {

    }
}
