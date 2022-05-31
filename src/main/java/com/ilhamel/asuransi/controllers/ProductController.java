package com.ilhamel.asuransi.controllers;

import com.ilhamel.asuransi.dtos.product.ProductHeaderDto;
import com.ilhamel.asuransi.dtos.product.UpsertProductDto;
import com.ilhamel.asuransi.rest.RestResponse;
import com.ilhamel.asuransi.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductServices productServices;

    @GetMapping
    public ResponseEntity<RestResponse<List<ProductHeaderDto>>> findAll(){
        return new ResponseEntity<>(
                new RestResponse<>(productServices.findAll(),
                        "Data ditemukan",
                        HttpStatus.OK.value()
                ),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<RestResponse<List<ProductHeaderDto>>> insertNewProduct(@RequestBody UpsertProductDto newProduct){
        return new ResponseEntity<>(
                new RestResponse<>(productServices.insertNewProduct(newProduct),
                        "Data berhasil ditambahkan",
                        HttpStatus.OK.value()
                ),
                HttpStatus.OK
        );
    }

    @PutMapping
    public ResponseEntity<RestResponse<ProductHeaderDto>> updateProduct(@RequestParam Integer productId, @RequestBody UpsertProductDto updatedProduct){
        return new ResponseEntity<>(
                new RestResponse<>(productServices.updateProduct(productId,updatedProduct),
                        "Data berhasil diupdate",
                        HttpStatus.OK.value()
                ),
                HttpStatus.OK
        );
    }

    @DeleteMapping
    public ResponseEntity<RestResponse<List<ProductHeaderDto>>> deleteProduct(@RequestParam Integer productId){
        return new ResponseEntity<>(
                new RestResponse<>(productServices.deleteProduct(productId),
                        "Data berhasil dihapus",
                        HttpStatus.OK.value()
                ),
                HttpStatus.OK
        );
    }

}
