package com.au.pereira.integration.controller;

import com.au.pereira.integration.model.Category;
import com.au.pereira.integration.model.Product;
import com.au.pereira.integration.model.dtos.ProductDto;
import com.au.pereira.integration.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> save(@RequestBody @Valid ProductDto product) {
        Product saved = service.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(Product.toDto(saved));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("list")
    public ResponseEntity<List<ProductDto>> list(@PathParam("page") Pageable page) {
        List<ProductDto> productsDto = service.listPaginated(page);
        return ResponseEntity.ok(productsDto);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("list-by-category")
    public ResponseEntity<List<ProductDto>> listByCategory(@PathParam("category") Category category) {
        List<ProductDto> productsDto = service.listAllByCategory(category);
        return ResponseEntity.ok(productsDto);
    }
}
