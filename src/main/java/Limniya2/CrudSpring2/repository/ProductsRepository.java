package Limniya2.CrudSpring2.repository;

import Limniya2.CrudSpring2.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products,Long> {
}
