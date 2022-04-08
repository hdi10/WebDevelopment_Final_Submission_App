package com.okta.springbootjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    private ProductRepository productRepository;

    List<Product> productList = new ArrayList<Product>();

    @Autowired
    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    Iterable<Product> all(){
        return productRepository.findAll();
    }

    @PostMapping("/products")
    void addProduct(@RequestBody Product product) {
        productRepository.save(product);
    }

    @DeleteMapping("/products")
    void deleteProduct(@RequestBody Product product){ productRepository.delete(product);}

    @DeleteMapping(path = { "/{product_id}" })
    public Product delete(@PathVariable("product_id") int product_id) {
        Product deletedProd = null;
        for (Product prod : productList) {
            if (prod.getId()== (product_id)) {
                productList.remove(product_id);
                deletedProd = prod;
                break;
            }
        }
        return deletedProd;
    }

    @DeleteMapping(path = { "/{name}" })
    public Product delete(@PathVariable("name") String name) {
        Product deletedProd = null;
        for (Product prod : productList) {
            if (prod.getName().equals(name)) {
                productList.remove(name);
                deletedProd = prod;

                break;
            }
        }
        return deletedProd;
    }

}
