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




    public List<Carts> listItems(@PathVariable Integer userId) {
        return cartRepository.findByUsers(userId);
    }

//    public List<Carts> listItems(Users user) {
//        return cartRepository.findByUser(user);
//    }

    public Integer addToCart(Integer productId, Integer quantity, Users users) {
        Integer addQuantity = quantity;
        Products product = productRepository.findById(productId).get();
        Carts carts;
        if (cartRepository.findByUsersAndProducts(users, product).isPresent()) {
            carts = cartRepository.findByUsersAndProducts(users, product).get();
            addQuantity = carts.getQuantity() + quantity;
            carts.setQuantity(addQuantity);
            carts.setTotal(carts.getTotal() + (product.getProductPrice()*quantity) );
        } else {
            carts = new Carts();
            carts.setQuantity(quantity);
            carts.setUsers(users);
            carts.setProducts(product);
            carts.setTotal(product.getProductPrice()*quantity);
        }
        cartRepository.save(carts);
        return addQuantity;
    }



    public void removeProduct(Integer productId,Integer quantity, Users users) {
        Products products = productRepository.findById(productId).orElse(null);
        Carts carts ;
        // can find cart
        if(cartRepository.findByUsersAndProducts(users,products).isPresent()) {
            carts = cartRepository.findByUsersAndProducts(users, products).get();
            if(carts.getQuantity() < quantity ){
                carts.setQuantity(carts.getQuantity()-quantity);
                carts.setTotal(carts.getTotal() - (quantity * carts.getProducts().getProductPrice()));
                cartRepository.save(carts);
            }else if (carts.getQuantity() == quantity){
                cartRepository.deleteByUserAndProducts(users.getUserId(), productId);
            }else{
                return;
            }
        }
    }
}
