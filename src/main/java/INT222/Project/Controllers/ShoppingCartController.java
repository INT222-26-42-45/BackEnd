package INT222.Project.Controllers;

import INT222.Project.Models.Carts;
import INT222.Project.Models.Users;
import INT222.Project.Services.ShoppingCartService;
import INT222.Project.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;



@CrossOrigin("*")
@RestController
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;

    @Autowired
    UserService userService;


    @Transactional
    @GetMapping("/cart")
    public List<Carts> showCart (@AuthenticationPrincipal UserDetails userDetails){
        Users users = userService.getUser(userDetails.getUsername());
        return  shoppingCartService.listItems(users.getUserId());
    }

    @Transactional
    @PostMapping("/cart/add/{productId}/{quantity}")
    public String addProductToCart(@PathVariable Integer productId, @PathVariable Integer quantity,
                                           @AuthenticationPrincipal UserDetails userDetails){
        if (userDetails == null) {
            return "You must login to update quantity.";
        }
        try {
            Users users = userService.getUser(userDetails.getUsername());
            System.out.println(userDetails.getUsername());

            shoppingCartService.addToCart(productId, quantity, users);
            return "this product added to your carts.";
        } catch (Exception e){
            return e.getMessage();
        }

    }

    @Transactional
    @PutMapping("/cart/update/{cartId}/{quantity}")
    public String updateCartInCart(@PathVariable Integer cartId, @PathVariable Integer quantity, @AuthenticationPrincipal UserDetails userDetails ){
        if (userDetails == null) {
            return "You must login to update quantity.";
        }
         shoppingCartService.updateCart(cartId,quantity);
        return "The cart has been update.";
    }


    @Transactional
    @DeleteMapping("/cart/delete/{cartId}")
    public String deleteProductFromCart(@PathVariable Integer cartId , @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return "You must login to remove product.";
        }
        shoppingCartService.removeProduct(cartId);
        return "The product has been remove from your cart.";
    }
}
