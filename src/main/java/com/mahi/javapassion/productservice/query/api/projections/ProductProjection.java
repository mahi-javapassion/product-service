package com.mahi.javapassion.productservice.query.api.projections;

import com.mahi.javapassion.productservice.command.api.ProductRepository;
import com.mahi.javapassion.productservice.command.api.entity.Product;
import com.mahi.javapassion.productservice.command.api.model.ProductRestModel;
import com.mahi.javapassion.productservice.query.api.query.GetProductsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductProjection {

    private final ProductRepository productRepository;

    public ProductProjection(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryHandler
    public List<ProductRestModel> handle(GetProductsQuery getProductsQuery) {
        List<Product> result = productRepository.findAll();
        return result.stream().map(product -> ProductRestModel.builder()
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build()).collect(Collectors.toList());
    }
}
