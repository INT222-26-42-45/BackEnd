package INT222.Project.Services;

import INT222.Project.Models.Users;
import INT222.Project.Repositories.RoleRepository;
import INT222.Project.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    //GetMapping
    public List<Users> allUsers() {
        return userRepository.findAll();
    }

    //PostMapping
//    private static final String USER_ROLE = "ROLE_USER";
//    public Users regisUser(@RequestBody Users newUser){
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encodedPassword = passwordEncoder.encode(newUser.getPassword());
//        newUser.setPassword(encodedPassword);
//        return userRepository.save(newUser);
//    }


}
