// package com.flightreservation.controller;

// import com.flightreservation.model.User;
// import com.flightreservation.service.UserService;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.validation.BindingResult;
// import org.springframework.beans.factory.annotation.Autowired;
// import javax.validation.Valid;
// import javax.servlet.http.HttpSession;
// import org.springframework.web.bind.annotation.*;

// @Controller
// public class AuthController {

//     @Autowired
//     private UserService userService;

//     @GetMapping("/signup")
//     public String signupForm(Model model) {
//         model.addAttribute("user", new User());
//         return "signup";
//     }

//     @PostMapping("/signup")
//     public String register(@Valid @ModelAttribute("user") User user,
//                            BindingResult result) {

//         if(result.hasErrors()) {
//             return "signup";
//         }

//         userService.register(user);
//         return "redirect:/login";
//     }

//     @GetMapping("/login")
//     public String loginForm(Model model) {
//         model.addAttribute("user", new User());
//         return "login";
//     }

//     @PostMapping("/login")
//     public String login(@ModelAttribute User user,
//                         HttpSession session,
//                         Model model) {

//         try {
//             User dbUser = userService.login(user.getEmail(), user.getPassword());
//             session.setAttribute("loggedUser", dbUser);
//             return "redirect:/search";
//         } catch(Exception e) {
//             model.addAttribute("error", "Invalid Credentials");
//             return "login";
//         }
//     }
// }

=================================================================================================================================


// package com.flightreservation.controller;

// import com.flightreservation.model.User;
// import com.flightreservation.service.UserService;

// import javax.servlet.http.HttpSession;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.*;

// @Controller
// public class AuthController {

//     @Autowired
//     private UserService userService;

//     // SIGNUP PAGE
//     @GetMapping("/signup")
//     public String signupForm(Model model) {

//         model.addAttribute("user",new User());

//         return "signup";
//     }

//     // REGISTER USER
//     @PostMapping("/signup")
//     public String register(@ModelAttribute User user){

//         userService.register(user);

//         return "redirect:/login";
//     }

//     // LOGIN PAGE
//     @GetMapping("/login")
//     public String loginForm(Model model){

//         model.addAttribute("user",new User());

//         return "login";
//     }

//     // LOGIN PROCESS
//     @PostMapping("/login")
//     public String login(@ModelAttribute User user,
//                         HttpSession session,
//                         Model model){

//         try{

//             User dbUser =
//                     userService.login(user.getEmail(),user.getPassword());

//             session.setAttribute("loggedUser",dbUser);

//             return "redirect:/";

//         }
//         catch(Exception e){

//             model.addAttribute("error","Invalid Email or Password");

//             return "login";
//         }
//     }

//     // LOGOUT
//     @GetMapping("/logout")
//     public String logout(HttpSession session){

//         session.invalidate();

//         return "redirect:/";
//     }
// }

==============================================================================================================================
package com.flightreservation.controller;

import com.flightreservation.model.User;
import com.flightreservation.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    // ======================
    // SIGNUP PAGE
    // ======================
    @GetMapping("/signup")
    public String signupForm(Model model) {

        model.addAttribute("user", new User());
        return "signup";
    }

    // ======================
    // REGISTER USER
    // ======================
    @PostMapping("/signup")
    public String register(
            @Valid @ModelAttribute("user") User user,
            BindingResult result,
            Model model,
            RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "signup";
        }

        if (userService.emailExists(user.getEmail())) {
            model.addAttribute("emailError", "Email already exists");
            return "signup";
        }

        userService.register(user);

        redirectAttributes.addFlashAttribute(
                "successMessage",
                "Registration successful! Please login."
        );

        return "redirect:/login";
    }

    // ======================
    // LOGIN PAGE
    // ======================
    @GetMapping("/login")
    public String loginForm(Model model) {

        model.addAttribute("user", new User());
        return "login";
    }

    // ======================
    // LOGIN USER
    // ======================
    @PostMapping("/login")
    public String login(
            @Valid @ModelAttribute("user") User user,
            BindingResult result,
            HttpSession session,
            Model model,
            RedirectAttributes redirectAttributes) {

        // STEP 1 — FIELD VALIDATION
        if (result.hasErrors()) {
            return "login";
        }

        // STEP 2 — CHECK DATABASE
        User dbUser = userService.login(user.getEmail(), user.getPassword());

        if (dbUser == null) {

            model.addAttribute(
                    "error",
                    "Invalid email or password"
            );

            return "login";
        }

        // STEP 3 — SUCCESS LOGIN
        session.setAttribute("loggedUser", dbUser);

        redirectAttributes.addFlashAttribute(
                "loginSuccess",
                "Login successful!"
        );

        return "redirect:/";
    }
}
