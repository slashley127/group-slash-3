package com.slash3.travelapp;

import com.slash3.travelapp.Controllers.UserController;
import com.slash3.travelapp.DTO.UserDTO;
import com.slash3.travelapp.Models.AppUser;
import com.slash3.travelapp.Repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;


public class AuthenticationFilter implements HandlerInterceptor {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserController authenticationController;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();

        AppUser user =  (AppUser) session.getAttribute("user");

        //ResponseEntity<UserDTO> user = authenticationController.getUserById( );

        // The user is logged in
        if (user != null) {
            return true;
        }

        // The user is NOT logged in
        response.sendRedirect("/email");
        return false;
    }

}
