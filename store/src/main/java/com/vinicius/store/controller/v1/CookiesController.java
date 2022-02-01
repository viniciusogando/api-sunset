package com.vinicius.store.controller.v1;

import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

@RestController
@RequestMapping("/v1/cookies")
public class CookiesController {
    @PostMapping("")
    public String setCookie(HttpServletResponse response, @RequestParam("user") String user) {
        Cookie cookie = new Cookie("user", user);
        response.addCookie(cookie);
        return user;
    }

    @GetMapping("")
    public String getCookie(@CookieValue(value = "user",
            defaultValue = "No user found in cookie") String user) {
        return "User is: " + user;
    }

    @PatchMapping("/expiry")
    public String setCookieExpiry(HttpServletResponse response) {
        int cookieAgeInSeconds = 86400;

        Cookie cookie = new Cookie("website", "https://sunset.org");
        cookie.setMaxAge(cookieAgeInSeconds); // expire in 1 day
        response.addCookie(cookie);
        return "Cookie will expire in " + cookieAgeInSeconds + " seconds.";
    }

    @DeleteMapping("")
    public String deleteCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("user", null);
        cookie.setMaxAge(0); // delete cookie
        response.addCookie(cookie);
        return "Cookie deleted";
    }
}