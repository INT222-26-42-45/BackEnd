package INT222.Project.Controllers;

import INT222.Project.Models.Carts;
import INT222.Project.Models.Users;
import INT222.Project.Services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;


@CrossOrigin
@RestController
public class ShoppingCartController {

//    @Autowired
//    ShoppingCartService shoppingCartService;
//
//    @GetMapping("/shopping")
//    public List<Carts> listcart(){
//        return shoppingCartService.listallItems();
//    }
//
//    @Transactional
//    @GetMapping("/cart/{userId}")
//    public List<Carts> showCart (@PathVariable Integer userId){
//        return  shoppingCartService.listItems(userId);
//    }
//
//    @Transactional
//    @PostMapping("/cart/add/{productId}/{quantity}")
//    public String addProductToCart(@PathVariable Integer productId, @PathVariable Integer quantity, Users user){
//        Integer addQuantity = shoppingCartService.addToCart(productId, quantity, user);
//        return addQuantity + "this product added to your carts.";
//    }
//
//    @Transactional
//    @PostMapping("/cart/update/{productId}/{quantity}")
//    public void updateProductToCart(@PathVariable Integer productId, @PathVariable Integer quantity, Users user){
//        shoppingCartService.updateQuantity(productId, quantity, user);
//    }
//
//    @Transactional
//    @PostMapping("/cart/delete/{productId}/{quantity}")
//    public void deleteProductFromCart(@PathVariable Integer productId, @PathVariable Integer quantity, Users user) {
//        shoppingCartService.removeProduct(productId, user);
//    }
}
