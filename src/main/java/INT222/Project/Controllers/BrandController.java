package INT222.Project.Controllers;

import INT222.Project.Models.Brands;
import INT222.Project.Models.Colors;
import INT222.Project.Repositories.BrandRepository;
import INT222.Project.Services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class BrandController {

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    BrandService brandService;

    @GetMapping("/brand")
    public List<Brands> showAllBrands(){
        return brandRepository.findAll();
    }

    //admin
    @PostMapping("/brand/add")
    public Brands newBrand(@RequestPart Brands newBrand) {
        return brandService.addBrand(newBrand);
    }

    //admin
    @DeleteMapping("/brand/delete/{brandId}")
    public void dropBrand(@PathVariable Integer brandId) {
        brandService.deleteBrand(brandId);
    }
}
