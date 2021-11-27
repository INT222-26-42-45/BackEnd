package INT222.Project.Repositories;

import INT222.Project.Models.Carts;

import INT222.Project.Models.Products;
import INT222.Project.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;


public interface CartRepository extends JpaRepository<Carts, Integer> {

    @Modifying
    @Query(value = "select * from Carts where UserId= :userId", nativeQuery = true)
    List<Carts> getCartByUserId(@Param("userId") Integer userId);

    @Modifying
    @Query(value = "update Carts set Quantity= :quantity, Total= :total where CartId= :cartId ", nativeQuery = true)
    void updateQuantity(@Param("cartId") Integer cartId, @Param("quantity") Integer quantity, @Param("total") Double total);



}

