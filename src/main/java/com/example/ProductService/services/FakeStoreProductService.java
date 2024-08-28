package com.example.ProductService.services;

import com.example.ProductService.Exceptions.ProductNotFoundException;
import com.example.ProductService.dtos.FakeStoreProductDto;
import com.example.ProductService.models.Products;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductServices{
    @Override
    public Products getProductById(long id) throws ProductNotFoundException{
        String url = "https://fakestoreapi.com/products/" + id;
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(url, FakeStoreProductDto.class);
        if(fakeStoreProductDto == null){
            throw new ProductNotFoundException("Product with id:" + id + "was not found");
        }
        return convertFakeStoreProductToProduct(fakeStoreProductDto);
    }

    private Products convertFakeStoreProductToProduct(FakeStoreProductDto dto){
        Products product = new Products();
        product.setCategory(dto.getCategory());
        product.setDescription(dto.getDescription());
        product.setName(dto.getTitle());
        return product;
    }
}
