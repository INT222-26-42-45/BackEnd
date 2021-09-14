package INT222.Project.Services;

import INT222.Project.Dto.AddToCartDto;
import INT222.Project.Dto.CartDto;
import INT222.Project.Dto.CartItemDto;
import INT222.Project.Models.Carts;
import INT222.Project.Models.Products;
import INT222.Project.Models.Users;
import INT222.Project.Repositories.CartRepository;
import INT222.Project.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class ShoppingCartService {

    @Autowired
    CartRepository cartRepository;


    public void addToCart(AddToCartDto addToCartDto, Products products, Users users){
        Carts carts = new Carts(products, addToCartDto.getQuantity(), users);
        cartRepository.save(carts);
    }

    public CartDto listCart(Users users) {
        List<Carts> cartsList = cartRepository.findAllByUser(users);
        List<CartItemDto> cartItems = new ArrayList<>();
        for (Carts carts : cartsList){
            CartItemDto cartItemDto = getDtoFromCarts(carts);
            cartItems.add(cartItemDto);
        }
        double total = 0;
        for (CartItemDto cartItemDto : cartItems){
            total += (cartItemDto.getProducts().getProductPrice() * cartItemDto.getQuantity());
        }
        CartDto cartDto = new CartDto(cartItems, total);
        return cartDto;
    }

    public static CartItemDto getDtoFromCarts(Carts carts) {
        CartItemDto cartItemDto = new CartItemDto(carts);
        return cartItemDto;
    }

    public void updateCart(AddToCartDto addToCartDto, Users users, Products products){
        Carts carts = cartRepository.getOne(addToCartDto.getCartId());
        carts.setQuantity(addToCartDto.getQuantity());
        cartRepository.save(carts);
    }

    public void deleteItem(int cartId, int userId){
        cartRepository.deleteById(cartId);
    }

    public void deleteCart(int userId) {
        cartRepository.deleteAll();
    }
//    public List<Carts> listallItems(){
//        return cartRepository.findAll();
//    }
//
//    public List<Carts> listItems(@PathVariable Integer userId) {
//        return cartRepository.findByUser(userId);
//    }

//    public List<Carts> listItems(Users user) {
//        return cartRepository.findByUser(user);
//    }

//    public Integer addToCart(Integer productId, Integer quantity, Users user) {
//        Integer addQuantity = quantity;
//        Products product = productRepository.findById(productId).get();
//        Carts carts = cartRepository.findByUsersAndProducts(user, product);
//        if (carts != null) {
//            addQuantity = carts.getQuantity() + quantity;
//            carts.setQuantity(addQuantity);
//        } else {
//            carts = new Carts();
//            carts.setQuantity(quantity);
//            carts.setUsers(user);
//            carts.setProducts(product);
//        }
//        cartRepository.save(carts);
//        return addQuantity;
//    }
//
//    public void updateQuantity (Integer productId, Integer quantity, Users user) {
//        cartRepository.updateQuantity(quantity, productId, user.getUserId());
//    }
//
//    public void removeProduct(Integer productId, Users user) {
//        cartRepository.deleteByUserAndProducts(user.getUserId(), productId);
//    }
}
