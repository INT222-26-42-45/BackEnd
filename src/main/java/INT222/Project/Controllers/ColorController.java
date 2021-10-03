package INT222.Project.Controllers;

import INT222.Project.Models.Colors;
import INT222.Project.Repositories.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class ColorController {

    @Autowired
    ColorRepository colorRepository;

    @GetMapping("/color")
    public List<Colors> showAllColor(){
        return colorRepository.findAll();
    }

}
