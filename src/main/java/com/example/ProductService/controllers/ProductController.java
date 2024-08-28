package com.example.ProductService.controllers;

import com.example.ProductService.Exceptions.ProductNotFoundException;
import com.example.ProductService.models.Products;
import com.example.ProductService.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
public class ProductController {


    @Autowired
    private ProductServices productServices;
    @GetMapping("/products/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable("id") long productId) throws ProductNotFoundException {
      //  if(productId < 1 || productId > 20){
      //      return new ResponseEntity<>(HttpStatusCode.valueOf(400));
      //  }
        Products products = productServices.getProductById(productId);
        return new ResponseEntity<>(products, HttpStatusCode.valueOf(200));
    }


}
