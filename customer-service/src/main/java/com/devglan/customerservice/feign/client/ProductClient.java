package com.devglan.customerservice.feign.client;

import com.devglan.customerservice.feign.config.CustomFeignConfig;

import feign.RequestLine;

import com.devglan.commons.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="product-service", configuration = CustomFeignConfig.class)
public interface ProductClient {

   // @GetMapping("/products")
    @RequestLine(value = "GET /products")
    List<Product> listProducts();

    //@GetMapping("/products/{id}")
    @RequestLine(value = "GET /products/{id}")
    Product getProductById(@PathVariable String id);

	/*
	 * @PostMapping("/products") Product create(@RequestBody Product product);
	 */

   // @GetMapping("/products/customer/{custId}")
    @RequestLine(value = "GET /products/customer/{custId}")
    List<Product> listProductsByCustomerId(@PathVariable String custId);
}
