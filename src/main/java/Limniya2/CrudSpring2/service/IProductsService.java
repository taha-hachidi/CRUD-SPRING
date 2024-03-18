package Limniya2.CrudSpring2.service;

import Limniya2.CrudSpring2.model.Products;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface IProductsService {

    Products newProduct(Products newProduct);

    List<Products> getProducts();

    Optional<Products> getProductById(Long id);

    Optional<Products> updateProduct(Products newProduct,Long id);

    String deleteProduct(Long id);


}
