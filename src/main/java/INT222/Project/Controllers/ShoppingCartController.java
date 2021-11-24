package INT222.Project.Controllers;

import INT222.Project.Models.Carts;
import INT222.Project.Models.Users;
import INT222.Project.Services.ProductService;
import INT222.Project.Services.ShoppingCartService;
import INT222.Project.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
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
    @GetMapping("/cart/{userId}")
    public List<Carts> showCart (@PathVariable Integer userId){
        return  shoppingCartService.listItems(userId);
    }

    @Transactional
    @PostMapping("/cart/add/{productId}/{quantity}")
    public ResponseEntity<?> addProductToCart(@PathVariable Integer productId, @PathVariable Integer quantity,
                                           @AuthenticationPrincipal UserDetails userDetails){
        if (userDetails == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Users users = userService.getUser(userDetails.getUsername());

        Integer addQuantity = shoppingCartService.addToCart(productId, quantity, users);
        return ResponseEntity.ok().body(addQuantity + "this product added to your carts.");
    }



    @Transactional
    @PostMapping("/cart/delete/{productId}/{quantity}")
    public String deleteProductFromCart(@PathVariable Integer productId ,@PathVariable Integer quantity,  @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return "You must login to remove product.";
        }
        Users users = userService.getUser(userDetails.getUsername());
        shoppingCartService.removeProduct(productId,quantity, users);
        return "The product has been remove from your cart.";
    }
}
