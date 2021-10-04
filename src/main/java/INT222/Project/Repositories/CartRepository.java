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

//    List<Carts> findAllByUser(Users users);
//
//    List<Carts> deleteByUsers(Users users);

//    List<Carts> findByUsers(Users users);

    Carts findByUsersAndProducts(Users user, Products product);

    @Modifying
    @Query(value = "select * from Carts where UserId= :userId", nativeQuery = true)
    List<Carts> findByUsers(@Param("userId") Integer userId);

    @Modifying
    @Query(value = "update Carts c set c.quantity = ?1 where c.products.productId = ?2 and c.users.userId= ?3")
    void updateQuantity(Integer quantity, Integer productId, Integer userId);

    @Modifying
    @Query(value = "delete from Carts c where c.users.userId = ?1 and c.products.productId = ?2")
    void deleteByUserAndProducts(Integer userId, Integer productId);
}

