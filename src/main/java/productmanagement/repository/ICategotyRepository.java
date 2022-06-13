package productmanagement.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import productmanagement.model.Category;

public interface ICategotyRepository extends PagingAndSortingRepository<Category, Long> {

}
