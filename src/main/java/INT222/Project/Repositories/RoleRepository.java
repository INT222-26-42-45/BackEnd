package INT222.Project.Repositories;

import INT222.Project.Models.ERole;
import INT222.Project.Models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RoleRepository extends JpaRepository<Roles, Integer> {

    Optional<Roles> findByRolename(ERole rolename);
}
