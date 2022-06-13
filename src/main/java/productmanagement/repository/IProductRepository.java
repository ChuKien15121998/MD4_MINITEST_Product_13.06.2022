package productmanagement.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import productmanagement.model.Category;
import productmanagement.model.Product;

public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {
    Iterable<Product> findAllByNameContaining (String name);
    Iterable<Product> findAllByOrderByName();
    Iterable<Product> findAllByCategory (Category category);
    @Modifying
    @Query(value = "select * from product order by id desc limit 4 ", nativeQuery = true)
    Iterable<Product> findTop4New();
}
