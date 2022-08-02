package com.nlu.bookonlinebe.controllers;

import com.nlu.bookonlinebe.models.Product;
import com.nlu.bookonlinebe.models.ResponseObject;
import com.nlu.bookonlinebe.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "**")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping
    public ResponseEntity<ResponseObject> getAllProducts(){
        ResponseObject result = productService.getAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getProduct(@PathVariable("id") long id){
        ResponseObject result = productService.getProduct(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @GetMapping("/findName")
    public ResponseEntity<ResponseObject> findName(@RequestParam String name){
        ResponseObject result = productService.findProductname(name);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @GetMapping("/search")
    public ResponseEntity<ResponseObject> searchByNameOrAuthor(@RequestParam("q") String q){
        ResponseObject result = productService.searchByNameOrAuthor(q);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping()
    public ResponseEntity<ResponseObject> createProduct(@RequestBody Product product){
        ResponseObject result = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> updateProduct(
            @PathVariable("id") long id,
            @RequestBody Product newProduct){
        ResponseObject result = productService.updateProduct(id, newProduct);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> deleteProduct(@PathVariable("id") long id){
        ResponseObject result = productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/top")
    public ResponseEntity<ResponseObject> getTop(){
        ResponseObject result = productService.findTop10ByName();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/news")
    public ResponseEntity<ResponseObject> getNews(){
        ResponseObject result = productService.findTop10New();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
