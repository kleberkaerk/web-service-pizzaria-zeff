package com.webservicepizzariazeff.www.controller;

import com.webservicepizzariazeff.www.domain.Type;
import com.webservicepizzariazeff.www.dto.response.ProductResponseDTO;
import com.webservicepizzariazeff.www.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    protected ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "find-products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<Type, List<ProductResponseDTO>>> findProductsInStock() {

        return new ResponseEntity<>(this.productService.findAllProductsInStock(), HttpStatus.OK);
    }

    @GetMapping(value = "find-by-type", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<ProductResponseDTO>> findByType(Pageable pageable, @RequestParam() String type) {

        return new ResponseEntity<>(this.productService.findProductsByTypeAndInStock(pageable, type), HttpStatus.OK);
    }

    @GetMapping(value = "find-promotions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<Type, List<ProductResponseDTO>>> findProductsInPromotion() {

        return new ResponseEntity<>(this.productService.findProductsInPromotionAndInStock(), HttpStatus.OK);
    }
}
