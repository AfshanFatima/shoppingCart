package com.lambdaschool.coffeebean.controller;

import com.lambdaschool.coffeebean.SendGrid.EmailModel;
import com.lambdaschool.coffeebean.SendGrid.SendGridService2;
import com.lambdaschool.coffeebean.model.User;
import com.lambdaschool.coffeebean.repository.Userrepository;
import com.lambdaschool.coffeebean.service.CheckIsAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/signup", produces = MediaType.APPLICATION_JSON_VALUE)
public class Signupcontroller extends CheckIsAdmin
{

    @Autowired
    private Userrepository userrepos;

    @Autowired
    SendGridService2 emailService;

    @PostMapping("")
    public Object addNewUser(@RequestBody User newuser) throws URISyntaxException, IOException
    {
        HashMap<String, Object> returnObject = CheckIsAdmin.CheckUsernameEmailIsUnique(newuser, userrepos);
        if (newuser.getPassword() == null) returnObject.put("passwordError", "passwordRequired");
        if (newuser.getEmail() == null) returnObject.put("emailError", "emailRequired");
        if (!returnObject.isEmpty()) return returnObject;

        EmailModel welcomeEmail = new EmailModel("meanmeancoffebean2019@gmail.com", newuser.getEmail(), "Thanks for joining the mean team", "welcome message");
        emailService.sendEmail(welcomeEmail);

        newuser.setRole("user");
        return userrepos.save(newuser);
    }
}