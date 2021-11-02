package INT222.Project.Services;

import INT222.Project.Models.Colors;
import INT222.Project.Repositories.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ColorService {

    @Autowired
    ColorRepository colorRepository;

    //PostMapping admin
    public Colors addColor(@RequestBody Colors newColor) {
        return  colorRepository.save(newColor);
    }

    //DeleteMapping admin
    public void deleteColor(@PathVariable Integer colorId) {
        colorRepository.deleteColor(colorId);
        colorRepository.deleteById(colorId);
    }

}
