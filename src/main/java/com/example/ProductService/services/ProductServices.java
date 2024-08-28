package com.example.ProductService.services;

import com.example.ProductService.Exceptions.ProductNotFoundException;
import com.example.ProductService.models.Products;

public interface ProductServices {

    public Products getProductById(long id) throws ProductNotFoundException;
}
