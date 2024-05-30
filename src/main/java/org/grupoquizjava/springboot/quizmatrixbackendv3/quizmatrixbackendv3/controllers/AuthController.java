package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.controllers;

import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.repository.IUserDao;
import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private IUserDao userDaoImp;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String loginUser(@RequestBody UserModel userModel) {

        if(userDaoImp.credentials(userModel)) {
            return "OK";
        }
        return "FAIL";

    }

}
