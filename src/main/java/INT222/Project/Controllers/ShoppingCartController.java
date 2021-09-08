package INT222.Project.Controllers;

import INT222.Project.Models.Carts;
import INT222.Project.Services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;


@CrossOrigin
@RestController
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;

    @GetMapping("/shopping")
    public List<Carts> listcart(){
        return shoppingCartService.listallItems();
    }

    @Transactional
    @GetMapping("/cart/{userId}")
    public List<Carts> showCart (@PathVariable Integer userId){
        return  shoppingCartService.listItems(userId);
    }
}
