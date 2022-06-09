package com.ilhamel.asuransi.services;

import com.ilhamel.asuransi.dtos.product.ProductHeaderDto;
import com.ilhamel.asuransi.dtos.product.UpsertProductDto;
import com.ilhamel.asuransi.models.Product;
import com.ilhamel.asuransi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ProductServices {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductHeaderDto> findAll() {
        return ProductHeaderDto.toList(productRepository.findAll());
    }


    public List<ProductHeaderDto> insertNewProduct(UpsertProductDto newProduct) {
        Stream.of(newProduct).forEach(field -> {
            if (field != null) {
                productRepository.save(newProduct.toModel());
            }
        });
        return findAll();
    }

    public ProductHeaderDto updateProduct(Integer productId, UpsertProductDto updatedProduct) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        Stream.of(updatedProduct).forEach(field -> {
            if (field != null) {
                productRepository.save(field.setValue(product));
            }
        });
        return ProductHeaderDto.set(product);
    }

    public List<ProductHeaderDto> deleteProduct(Integer productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product not found"));
        try{
            productRepository.delete(product);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Product is still used by other data");
        }
        return findAll();
    }
}
