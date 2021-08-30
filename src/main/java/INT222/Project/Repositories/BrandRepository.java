package INT222.Project.Repositories;

import INT222.Project.Models.Brands;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brands, Integer> {
}
