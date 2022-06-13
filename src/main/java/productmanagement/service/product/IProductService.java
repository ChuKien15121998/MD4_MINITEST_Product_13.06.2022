package productmanagement.service.product;

import productmanagement.model.Category;
import productmanagement.model.Product;
import productmanagement.service.IGeneralService;

public interface IProductService extends IGeneralService<Product> {
    Iterable<Product> findAllByNameContaining (String name);
    Iterable<Product> findAllByOrderByName();
    Iterable<Product> findAllByCategory (Category category);
    Iterable<Product> findByPriceRange(String price1, String price2);

}
