package productmanagement.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import productmanagement.model.Category;
import productmanagement.model.Product;
import productmanagement.repository.IProductRepository;

import java.util.Optional;

public class ProductService implements IProductService{

    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Iterable<Product> getTop4New() {
        return productRepository.findTop4New();
    }

    @Override
    public Iterable<Product> findAllByNameContaining(String name) {
        return productRepository.findAllByNameContaining(name);
    }

    @Override
    public Iterable<Product> findAllByOrderByName() {
        return productRepository.findAllByOrderByName();
    }

    @Override
    public Iterable<Product> findAllByCategory(Category category) {
        return productRepository.findAllByCategory(category);
    }

}
