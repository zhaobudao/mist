package org.zhaobudao.mist.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zhaobudao.mist.model.User;
import org.zhaobudao.mist.service.UserService;
import org.zhaobudao.mist.util.Constants;
import org.zhaobudao.mist.util.CryptoUtil;


@Controller
public class SignController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String signin(@Valid User user, BindingResult result, HttpServletResponse response) throws NoSuchAlgorithmException {
        System.out.println("signin start");
        if (result.hasErrors()) {
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println(error.getField() + error.getDefaultMessage());
            }
        } else {
            user.setPassword(CryptoUtil.digest(user.getPassword(), userService.getSalt(user.getEmail())));
            if (userService.verifyPassword(user.getEmail(), user.getPassword())) {
                Cookie cookie = new Cookie(Constants.COOKIE_SU, user.getEmail() + ":" + user.getPassword());
                cookie.setPath("/");
                cookie.setMaxAge(Integer.MAX_VALUE);
                response.addCookie(cookie);
            }
        }
        System.out.println("signin end");
        return "redirect:/";
    }

    @RequestMapping(value = "/cookie", method = RequestMethod.GET)
    @ResponseBody
    public String cookie(@CookieValue(value = "SU", required = false) String su) {
        return su;
    }

}
