package INT222.Project.Controllers;

import INT222.Project.Models.Brands;
import INT222.Project.Repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class BrandController {

    @Autowired
    BrandRepository brandRepository;

    @GetMapping("/brand")
    public List<Brands> showAllBrands(){
        return brandRepository.findAll();
    }

}
