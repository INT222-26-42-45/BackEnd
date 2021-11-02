package INT222.Project.Repositories;

import INT222.Project.Models.Colors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ColorRepository extends JpaRepository<Colors, Integer> {

    @Modifying
    @Query(value = "delete from SkorProduct where ColorId= :ColorId", nativeQuery = true)
    void deleteColor(@Param("ColorId") Integer colorId);

}
