package productmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import productmanagement.model.Category;
import productmanagement.model.Product;
import productmanagement.service.category.ICategoryService;
import productmanagement.service.product.IProductService;

import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/{id}/products")
    public ResponseEntity<Iterable<Product>> findProductsByCategory(@PathVariable Optional<String> id) {
        Optional<Category> categoryOptional = categoryService.findById(Long.valueOf(id.get()));
        Iterable<Product> products = productService.findAllByCategory(categoryOptional.get());
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
