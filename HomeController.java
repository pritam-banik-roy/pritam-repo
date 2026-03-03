// com.flightreservation.controller

// HomeController.java


// package com.flightreservation.controller;

// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.RequestMapping;

// @Controller
// public class HomeController {

//     @RequestMapping("/")
//     public String home() {
//         return "home";
//     }
// }


package com.flightreservation.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.flightreservation.model.SearchFlight;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showHome(Model model) {
        model.addAttribute("searchFlight", new SearchFlight());
        return "home";
    }

    @PostMapping("/search")
    public String searchFlights(
            @Valid SearchFlight searchFlight,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            return "home";
        }

        // For now just redirect (later connect DB)
        model.addAttribute("source", searchFlight.getSource());
        model.addAttribute("destination", searchFlight.getDestination());

        return "search-results";
    }
}
