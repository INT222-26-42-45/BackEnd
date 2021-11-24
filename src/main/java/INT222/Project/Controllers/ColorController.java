package INT222.Project.Controllers;

import INT222.Project.Models.Colors;
import INT222.Project.Repositories.ColorRepository;
import INT222.Project.Services.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class ColorController {

    @Autowired
    ColorRepository colorRepository;

    @Autowired
    ColorService colorService;

    @GetMapping("/color")
    public List<Colors> showAllColor(){
        return colorRepository.findAll();
    }

    //admin
    @PostMapping("/color/add")
    public Colors newColors(@RequestPart Colors newColor) {
        System.out.println(newColor.toString());
        return colorService.addColor(newColor);

    }

    //admin
    @DeleteMapping("/color/delete/{colorId}")
    public void dropColor(@PathVariable Integer colorId) {
        colorService.deleteColor(colorId);
    }



}
