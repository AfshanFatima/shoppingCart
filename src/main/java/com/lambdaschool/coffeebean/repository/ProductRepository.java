package com.lambdaschool.coffeebean.repository;

import com.lambdaschool.coffeebean.CriteriaAPIProducts.ProductrepositoryCustom;
import com.lambdaschool.coffeebean.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductrepositoryCustom
{
    @Query(value = "SELECT * FROM products LIMIT :start, 10", nativeQuery = true)
    List<Product> get10Products(int start);


    @Query(value = "SELECT * FROM products WHERE MATCH(product_name) AGAINST(:searchString) LIMIT :start, 10;", nativeQuery = true)
    List<Product> naturalSearchForProductByName(@PathVariable String searchString, @PathVariable int start);

    @Transactional
    @Modifying
    @Query(value = "UPDATE products p SET inventory = p.inventory-:quantityinorder, total_ordered = p.total_ordered+:quantityinorder WHERE (product_id = :productid)", nativeQuery = true)
    void removeOrderedQtyFromInventory(long productid, int quantityinorder);

}
