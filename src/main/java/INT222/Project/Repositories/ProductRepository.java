package INT222.Project.Repositories;

import INT222.Project.Models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProductRepository extends JpaRepository<Products, Integer> {

//    @Modifying
//    @Query(value = "delete from SkorProduct where ProductId= :ProductId", nativeQuery = true)
//    void deleteProduct(@Param("ProductId") Integer productId);

    @Modifying
    @Query(value = "select * from Products where ProductName= :ProductName", nativeQuery = true)
    List<Products> selectProduct(@Param("ProductName") String productName);


}
