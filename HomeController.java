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
=========================================================================================================================================

// package com.flightreservation.controller;

// import javax.validation.Valid;

// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.validation.BindingResult;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;

// import com.flightreservation.model.SearchFlight;

// @Controller
// public class HomeController {

//     @GetMapping("/")
//     public String showHome(Model model) {
//         model.addAttribute("searchFlight", new SearchFlight());
//         return "home";
//     }

//     @PostMapping("/search")
//     public String searchFlights(
//             @Valid SearchFlight searchFlight,
//             BindingResult result,
//             Model model) {

//         if (result.hasErrors()) {
//             return "home";
//         }

//         // For now just redirect (later connect DB)
//         model.addAttribute("source", searchFlight.getSource());
//         model.addAttribute("destination", searchFlight.getDestination());

//         return "search-results";
//     }
// }


    ============================================================================================================


//     package com.flightreservation.controller;

// import com.flightreservation.model.SearchFlight;
// import com.flightreservation.model.Flight;
// import com.flightreservation.service.FlightService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.validation.BindingResult;
// import org.springframework.web.bind.annotation.*;

// import javax.validation.Valid;
// import java.util.List;

// @Controller
// @RequestMapping("/")
// public class HomeController {

//     @Autowired
//     private FlightService flightService;

//     // =========================
//     // HOME PAGE
//     // =========================
//     @GetMapping
//     public String showHome(Model model) {

//         model.addAttribute("searchFlight", new SearchFlight());

//         return "home";
//     }

//     // =========================
//     // SEARCH FLIGHTS
//     // =========================
//     @PostMapping("/search")
//     public String searchFlights(
//             @Valid @ModelAttribute("searchFlight") SearchFlight searchFlight,
//             BindingResult result,
//             Model model) {

//         if (result.hasErrors()) {
//             return "home";
//         }

//         // Fetch flights from service
//         List<Flight> flights =
//                 flightService.search(searchFlight.getSource(),
//                                      searchFlight.getDestination());

//         // Send flights to JSP
//         model.addAttribute("flights", flights);

//         return "home";   // stay on same page
//     }
// }
====================================================================================================================




package com.flightreservation.controller;

import com.flightreservation.model.SearchFlight;
import com.flightreservation.model.Flight;
import com.flightreservation.service.FlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private FlightService flightService;

    // ================= HOME PAGE =================
    @GetMapping
    public String showHome(Model model) {

        model.addAttribute("searchFlight", new SearchFlight());

        return "home";
    }

    // ================= SEARCH FLIGHTS =================
    @PostMapping("/search")
    public String searchFlights(
            @Valid @ModelAttribute("searchFlight") SearchFlight searchFlight,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {

            return "home";
        }

        List<Flight> flights =
                flightService.search(
                        searchFlight.getSource(),
                        searchFlight.getDestination()
                );

        model.addAttribute("flights", flights);

        // MESSAGE WHEN NO FLIGHTS FOUND
        if (flights.isEmpty()) {

            model.addAttribute(
                    "noFlightsMessage",
                    "No flights available for this route"
            );
        }

        return "home";
    }
}
