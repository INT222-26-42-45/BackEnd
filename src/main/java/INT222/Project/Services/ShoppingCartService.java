package INT222.Project.Services;

import INT222.Project.Models.Carts;
import INT222.Project.Models.Users;
import INT222.Project.Repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ShoppingCartService {

    @Autowired
    CartRepository cartRepository;

    public List<Carts> listallItems(){
        return cartRepository.findAll();
    }

    public List<Carts> listItems(@PathVariable Integer userId) {
        return cartRepository.findByUser(userId);
    }
}
