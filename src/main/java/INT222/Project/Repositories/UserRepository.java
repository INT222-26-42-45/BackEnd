package INT222.Project.Repositories;

import INT222.Project.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    @Modifying
    @Query(value = "delete from UserRole where UserId= :UserId", nativeQuery = true)
    void deleteUser(@Param("UserId") Integer userId);

    Boolean findByPassword(String password);







}
