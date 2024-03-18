package Limniya2.CrudSpring2.service;

import Limniya2.CrudSpring2.model.Products;
import Limniya2.CrudSpring2.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductsService implements IProductsService{
    @Autowired
    private ProductsRepository productsRepository;
    public Products newProduct(Products newProduct) {
        return productsRepository.save(newProduct);
    }

    @Override
    public List<Products> getProducts() {
        return productsRepository.findAll();
    }

    @Override
    public Optional<Products> getProductById(Long id) {
        return productsRepository.findById(id);
    }

    @Override
    public Optional<Products> updateProduct(Products newProduct, Long id) {
        return productsRepository.findById(id)
                .map(pr->{
                    pr.setName(newProduct.getName());
                    pr.setDescription(newProduct.getDescription());
                    pr.setPrice(newProduct.getPrice());
                    return productsRepository.save(pr);
                });
    }

    @Override
    public String deleteProduct(Long id) {
        productsRepository.deleteById(id);
        return "deleted with success";
    }
}
