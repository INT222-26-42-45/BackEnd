package INT222.Project.Controllers;

import INT222.Project.Models.Users;
import INT222.Project.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/listuser")
    public List<Users> showUser() {
        return userService.allUsers();
    }
//    @PostMapping("/regis")
//    public Users addUser(@RequestPart Users newUser){
//        return userService.regisUser(newUser);
//    }
}
