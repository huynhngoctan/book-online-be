package com.nlu.bookonlinebe.services.impl;

import com.nlu.bookonlinebe.models.Product;
import com.nlu.bookonlinebe.models.ResponseObject;
import com.nlu.bookonlinebe.repositories.ProductRepository;
import com.nlu.bookonlinebe.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepo;

    @Override
    public ResponseObject getAllProducts() {
        List<Product> products = productRepo.findAll();
        return new ResponseObject("success", "Get all product successfull", products);
    }

    @Override
    public ResponseObject getProduct(long id) {
        Optional<Product> productOptional = productRepo.findById(id);
        if (productOptional.isPresent()) {
            return new ResponseObject("success", "Get product successfull", productOptional.get());
        } else return new ResponseObject("failed", "Product does not exist", "");
    }

    @Override
    public ResponseObject createProduct(Product product) {
        Optional<Product> productOptional = productRepo.findByName(product.getName());
        if (productOptional.isPresent()) {
            return new ResponseObject("failed", "Product's name is exist", "");
        } else {
            Product savedProduct = productRepo.save(product);
            return new ResponseObject("success", "Create product successfull", savedProduct);
        }
    }

    @Override
    public ResponseObject updateProduct(long id, Product newProduct) {
        Optional<Product> productOptional = productRepo.findById(id);
        if(!productOptional.isPresent()) return new ResponseObject("failed","Product does not exist",null);

        Product updatedProduct = productOptional.map(product -> {
            product.setLinkImage(newProduct.getLinkImage());
            product.setPrice(newProduct.getPrice());
            product.setStatus(newProduct.getStatus());
            product.setStock(newProduct.getStock());
            product.setDescription(newProduct.getDescription());
            return productRepo.save(product);
        }).orElseGet(null);

        if(updatedProduct == null) return new ResponseObject("failed","Update unsuccessfull",null);
        else return new ResponseObject("success","Update successfull",updatedProduct);
    }

    @Override
    public ResponseObject deleteProduct(long id) {
        boolean isExist = productRepo.existsById(id);
        if(isExist){
             productRepo.deleteById(id);
             return new ResponseObject("success","Delete product succesfull","");
        }else return new ResponseObject("failed","Product's id does not exist","");
    }

    @Override
    public ResponseObject findProductname(String productname) {
        Optional<Product> productOptional = productRepo.findByName(productname);
        if(productOptional.isPresent()){
            return new ResponseObject("success", "Product's name is exist", "");
        }else
            return new ResponseObject("failed", "Product's name does not exist", "");
    }

    @Override
    public ResponseObject searchByNameOrAuthor(String q) {
        List<Product> products = productRepo.findByKeywordsContainingIgnoreCase(q);
        return new ResponseObject("success","Search completed",products);
    }

}
