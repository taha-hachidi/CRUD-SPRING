package Limniya2.CrudSpring2.controller;

import Limniya2.CrudSpring2.model.Products;
import Limniya2.CrudSpring2.service.IProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductsController {

    @Autowired()
    private IProductsService iProductsService;
    @PostMapping
    Products newProduct(@RequestBody Products newProduct){
        return iProductsService.newProduct(newProduct);
    }
    @GetMapping
    public List<Products> getProducts(){
        return iProductsService.getProducts();
    }

    @GetMapping("/product/{id}")
    Optional<Products> getProductById(@PathVariable Long id){
        return iProductsService.getProductById(id);
    }

    @PutMapping("/update/{id}")
    Optional<Products> updateProduct(@RequestBody Products newProduct,@PathVariable Long id){
        return iProductsService.updateProduct(newProduct,id);
    }

    @DeleteMapping("/delete/{id}")
    void deleteProduct(@PathVariable Long id){
        iProductsService.deleteProduct(id);
    }


}
