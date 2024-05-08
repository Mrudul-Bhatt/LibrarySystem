package com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Search_Catalogue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Product_Category_Review.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Catalogue implements Search {
    private HashMap<String, List<Product>> products;

    public List<Product> searchProductsByName(String name) {
        List<Product> result = new ArrayList<>();
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                    result.add(product);
                }
            }
        }
        return result;
    }

    public List<Product> searchProductsByCategory(String category) {
        List<Product> result = new ArrayList<>();
        if (products.containsKey(category)) {
            result.addAll(products.get(category));
        }
        return result;
    }

    public boolean addProduct(Product product) {
        String category = product.getCategory().getName();
        if (!products.containsKey(category)) {
            products.put(category, new ArrayList<>());
        }
        return products.get(category).add(product);
    }

    public boolean editProduct(Product product) {
        String category = product.getCategory().getName();
        if (products.containsKey(category)) {
            List<Product> productList = products.get(category);
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getProductId().equals(product.getProductId())) {
                    productList.set(i, product);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean deleteProduct(Product product) {
        String category = product.getCategory().getName();
        if (products.containsKey(category)) {
            List<Product> productList = products.get(category);
            return productList.remove(product);
        }
        return false;
    }

}
