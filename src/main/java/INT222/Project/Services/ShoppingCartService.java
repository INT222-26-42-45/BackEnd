package INT222.Project.Services;


import INT222.Project.Models.Carts;
import INT222.Project.Models.Products;
import INT222.Project.Models.Users;
import INT222.Project.Repositories.CartRepository;
import INT222.Project.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class ShoppingCartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;


//    public void deleteItem(int cartId, int userId){
//        cartRepository.deleteById(cartId);
//    }
//

    public List<Carts> listItems(@PathVariable Integer userId) {
        return cartRepository.findByUsers(userId);
    }

//    public List<Carts> listItems(Users user) {
//        return cartRepository.findByUser(user);
//    }

    public Integer addToCart(Integer productId, Integer quantity, Users users) {
        Integer addQuantity = quantity;
        Products product = productRepository.findById(productId).get();
        Carts carts = cartRepository.findByUsersAndProducts(users, product);
        if (carts != null) {
            addQuantity = carts.getQuantity() + quantity;
            carts.setQuantity(addQuantity);
        } else {
            carts = new Carts();
            carts.setQuantity(quantity);
            carts.setUsers(users);
            carts.setProducts(product);
        }
        cartRepository.save(carts);
        return addQuantity;
    }

    public void updateQuantity (Integer productId, Integer quantity, Users users) {
        cartRepository.updateQuantity(quantity, productId, users.getUserId());
    }

    public void removeProduct(Integer productId, Users users) {
        cartRepository.deleteByUserAndProducts(users.getUserId(), productId);
    }
}
