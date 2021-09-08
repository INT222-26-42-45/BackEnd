package INT222.Project.Repositories;

import INT222.Project.Models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Roles, Integer> {
//    Roles findByRole(@Param("role") String role);
}
