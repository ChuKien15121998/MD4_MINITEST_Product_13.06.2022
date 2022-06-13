package productmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import productmanagement.model.Category;
import productmanagement.model.Product;
import productmanagement.service.category.ICategoryService;
import productmanagement.service.product.IProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("category")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping
    public ResponseEntity<Iterable<Product>> findAll() {
        Iterable<Product> products = productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Iterable<Product>> findAllByName(@PathVariable String name) {
        Iterable<Product> products = productService.findAllByNameContaining(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/top4new")
    public ResponseEntity<Iterable<Product>> findTop4New() {
        Iterable<Product> products = productService.getTop4New();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/orderbyname")
    public ResponseEntity<Iterable<Product>> findAllOrderByName() {
        Iterable<Product> products = productService.findAllByOrderByName();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/findbypricerange/{price1}/{price2}")
    public ResponseEntity<Iterable<Product>> findAllByPriceRange(@PathVariable String price1, @PathVariable String price2) {
        Iterable<Product> products = productService.findByPriceRange(price1,price2);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
