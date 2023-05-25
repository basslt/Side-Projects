package controller

import dao.UserDAO;
import model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@PreAuthorize("isAuthenticated()")
public class UserController {

    private UserDAO userDao;

    public UserController(UserDAO userDao){
        this.userDao = userDao;

    }

    @GetMapping("/{username}")
    public ResponseEntity<User>  getUserByUsername(@PathVariable String username) {
        try {
            User user = userDao.getUserByUsername(username);
            return ResponseEntity.ok(user);
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findAll")
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public boolean addUser(@RequestParam String username, @RequestParam String password) {
        if (userDao.getUserByUsername(username) != null) {
            return false;
        }
        return userDao.addUser();
    }

    @GetMapping("/{username}/id")
    public int getUserbyId(@PathVariable int id) {
        return userDao.getUserById(id);
    }

}



