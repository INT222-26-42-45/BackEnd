package INT222.Project.Services;

import INT222.Project.Models.Products;
import INT222.Project.Models.Users;
import INT222.Project.Repositories.RoleRepository;
import INT222.Project.Repositories.UserRepository;
import INT222.Project.Security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
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


    @Autowired
    PasswordEncoder passwordEncoder;

    //GetMapping admin
    public List<Users> allUsers() {
        return userRepository.findAll();
    }

    //GetMapping user
    public List<Users> listUser(Integer userId){
        return userRepository.getUserByUserId(userId);
    }

    public Users getUser(String username){
       return userRepository.findByUsername(username).orElse(null);
    }

    public void editUser(Integer userId, Users newUser){
        if(userRepository.findById(userId).isPresent()) {
           Users oldUsers = userRepository.findById(userId).get();
           oldUsers.setBirth(newUser.getBirth());
           oldUsers.setFirstname(newUser.getFirstname());
           oldUsers.setLastname(newUser.getLastname());
           oldUsers.setTel(newUser.getTel());
           oldUsers.setGender(newUser.getGender());
           oldUsers.setEmail(newUser.getEmail());
            userRepository.save(oldUsers);
        }
    }

    //DeleteMapping admin
    public void deleteUser(Integer userId) {
        userRepository.deleteUserRole(userId);
        userRepository.deleteById(userId);
    }



}
