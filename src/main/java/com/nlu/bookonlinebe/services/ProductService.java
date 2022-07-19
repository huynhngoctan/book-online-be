package com.nlu.bookonlinebe.services;

import com.nlu.bookonlinebe.models.Product;
import com.nlu.bookonlinebe.models.ResponseObject;

public interface ProductService {
    public ResponseObject getAllProducts();
    public ResponseObject getProduct(long id);
    public ResponseObject createProduct(Product product);
    public ResponseObject updateProduct(long id, Product newProduct);
    public ResponseObject deleteProduct(long id);
    public ResponseObject findProductname(String productname);
}
