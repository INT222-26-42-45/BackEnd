package INT222.Project.Repositories;

import INT222.Project.Models.Carts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartRepository extends JpaRepository<Carts, Integer> {

    @Modifying
    @Query(value = "select * from carts where UserId= :userId", nativeQuery = true)
    List<Carts> findByUser(@Param("userId") Integer userId);
}
