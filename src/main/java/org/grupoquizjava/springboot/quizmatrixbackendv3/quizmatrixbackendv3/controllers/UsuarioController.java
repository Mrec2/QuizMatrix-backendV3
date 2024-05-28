package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.controllers;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.repository.IUserDao;
import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private IUserDao userDaoImp;


    @RequestMapping(value = "api/users", method = RequestMethod.GET)
    public List<UserModel> getAllUsers() {

        return userDaoImp.getAllUsers();

    }


    @RequestMapping(value = "api/usersInsert", method = RequestMethod.POST)
    public String insertUser(@RequestBody UserModel usermodel) {

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usermodel.getPassworduser());
        usermodel.setPassworduser(hash);

        if(userDaoImp.insert(usermodel)) {
            return "user created successfully";
        }
        return "email already exists";

    }


    @RequestMapping(value = "api/usersDelete/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable int id) {

        if(userDaoImp.delete(id)) {
            return "user deleted successfully";
        }
        return "user id does not exist";

    }

}
