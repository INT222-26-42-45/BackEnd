package INT222.Project.Services;

import INT222.Project.Models.Products;
import INT222.Project.Models.Users;
import INT222.Project.Repositories.RoleRepository;
import INT222.Project.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;


    //GetMapping admin
    public List<Users> allUsers() {
        return userRepository.findAll();
    }

    //GetMapping user
    public Users showUser(@PathVariable Integer userId){
        return userRepository.findById(userId).orElse(null);
    }

    //PutMapping user
    public Optional<Users> editUser(@PathVariable Integer userId, @RequestBody Users newUser){
        return userRepository.findById(userId).map(users -> {
            users.setFirstname(newUser.getFirstname());
            users.setLastname(newUser.getLastname());
            users.setEmail(newUser.getEmail());
            users.setTel(newUser.getTel());
            users.setBirth(newUser.getBirth());
            users.setGender(newUser.getGender());
            users.setUsername(newUser.getUsername());
            return userRepository.save(newUser);
        });
    }

    //DeleteMapping admin
    public void deleteUser(@PathVariable Integer userId) {
            userRepository.deleteUser(userId);
            userRepository.deleteById(userId);

    }



}
