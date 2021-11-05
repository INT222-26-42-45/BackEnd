package INT222.Project.Controllers;

import INT222.Project.Models.Products;
import INT222.Project.Models.Users;
import INT222.Project.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    //admin
    @GetMapping("/listuser")
    public List<Users> showAllUser() {
        return userService.allUsers();
    }

    //user
    @GetMapping("/user/{userId}")
    public Users showUser(@PathVariable Integer userId){
        return userService.showUser(userId);
    }

    //user
    @PutMapping("/user/edit/{userId}")
    public Optional<Users> updateUser(@PathVariable Integer userId, @RequestPart Users newUser){
        return userService.editUser(userId, newUser);
    }

    //admin
    @Transactional
    @DeleteMapping("/user/delete/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
    }



}
