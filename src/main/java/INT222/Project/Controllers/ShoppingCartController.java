package INT222.Project.Controllers;

import INT222.Project.Models.Carts;
import INT222.Project.Models.Users;
import INT222.Project.Services.ProductService;
import INT222.Project.Services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;


@CrossOrigin
@RestController
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;


    @Transactional
    @GetMapping("/cart/{userId}")
    public List<Carts> showCart (@PathVariable Integer userId){
        return  shoppingCartService.listItems(userId);
    }

    @Transactional
    @PostMapping("/cart/add/{productId}/{quantity}")
    public String addProductToCart(@PathVariable Integer productId, @PathVariable Integer quantity, Users users){
        Integer addQuantity = shoppingCartService.addToCart(productId, quantity, users);
        return addQuantity + "this product added to your carts.";
    }

    @Transactional
    @PostMapping("/cart/update/{productId}/{quantity}")
    public void updateProductToCart(@PathVariable Integer productId, @PathVariable Integer quantity, Users users){
        shoppingCartService.updateQuantity(productId, quantity, users);
    }

    @Transactional
    @PostMapping("/cart/delete/{productId}")
    public void deleteProductFromCart(@PathVariable Integer productId,  Users users) {
        shoppingCartService.removeProduct(productId, users);
    }
}
