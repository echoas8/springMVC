package Controller;

import entity.user;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class restController {
    private Map<Integer, user> Users;

    public restController() {
        this.Users = new HashMap<>();
        Users.put(1, new user(1, "admin"));
        Users.put(2, new user(2, "haha"));
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public user getUser(@PathVariable Integer id) {
        return Users.get(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<user> getAllUser() {
        return new ArrayList<>(Users.values());
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public List<user> addUser(@RequestBody user user) {
        Users.put(user.getId(), user);
        return new ArrayList<>(Users.values());
    }

}
