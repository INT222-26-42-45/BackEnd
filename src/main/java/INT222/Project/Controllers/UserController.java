package INT222.Project.Controllers;


import INT222.Project.Models.Users;
import INT222.Project.Repositories.UserRepository;
import INT222.Project.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


import javax.transaction.Transactional;
import java.util.List;


@CrossOrigin("*")
@RestController
public class UserController {
    @Autowired
    UserService userService;


    @Autowired
    UserRepository userRepository;

    //admin
    @GetMapping("/listuser")
    public List<Users> showAllUser() {
        return userService.allUsers();
    }

    //user
    @GetMapping("/user")
    public List<Users> showUser(@AuthenticationPrincipal UserDetails userDetails){
        Users users = userService.getUser(userDetails.getUsername());
        return userService.listUser(users.getUserId());
    }

    //user
    @PutMapping("/user/edit/{userId}")
    public String updateUser(@PathVariable Integer userId,@RequestPart Users newUser){
        userService.editUser(userId, newUser);
        return "Your profile has been update.";
    }

    //admin
    @Transactional
    @DeleteMapping("/user/delete/{userId}")
    public void deleteUser(@PathVariable Integer userId){
        userService.deleteUser(userId);
    }

}
