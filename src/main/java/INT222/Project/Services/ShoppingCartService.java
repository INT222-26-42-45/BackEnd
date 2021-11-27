package INT222.Project.Services;


import INT222.Project.Models.Carts;
import INT222.Project.Models.Products;
import INT222.Project.Models.Users;
import INT222.Project.Repositories.CartRepository;
import INT222.Project.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ShoppingCartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    public List<Carts> listItems(Integer userId) {
        return cartRepository.getCartByUserId(userId);
    }

    public Integer addToCart(Integer productId, Integer quantity, Users users) {
        Integer addQuantity = quantity;
        Products product = productRepository.findById(productId).get();
        Carts carts;
            carts = new Carts();
            carts.setQuantity(quantity);
            carts.setUsers(users);
            carts.setProducts(product);
            carts.setTotal(product.getProductPrice()*quantity);
//        }
        cartRepository.save(carts);
        return addQuantity;
    }

    public void updateCart(Integer cartId,Integer quantity){
        Carts carts = cartRepository.findById(cartId).get();
        Double total = carts.getProducts().getProductPrice()*quantity;

         cartRepository.updateQuantity(cartId,quantity,total);
    }

    public void removeProduct(Integer cartId) {
        cartRepository.deleteById(cartId);
    }
}
