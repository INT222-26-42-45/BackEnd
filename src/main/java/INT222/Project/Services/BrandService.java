package INT222.Project.Services;

import INT222.Project.Models.Brands;
import INT222.Project.Repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class BrandService {

    @Autowired
    BrandRepository brandRepository;

    //PostMapping admin
    public Brands addBrand(Brands newBrand) {
        return  brandRepository.save(newBrand);
    }

    //DeleteMapping admin
    public void deleteBrand(@PathVariable Integer brandId) {
        brandRepository.deleteById(brandId);
    }
}
