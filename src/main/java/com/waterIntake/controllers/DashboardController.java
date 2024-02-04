package com.waterIntake.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.waterIntake.entities.WaterIntake;
import com.waterIntake.services.WaterIntakeService;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private WaterIntakeService waterIntakeService;

    @GetMapping
    public String showDashboard(Model model, Principal principal) {
        String username = principal.getName();
        
        // Fetch user's water intake history
        List<WaterIntake> waterIntakeHistory = waterIntakeService.getUserWaterIntakeHistory(username);

        model.addAttribute("waterIntakeHistory", waterIntakeHistory);
        return "dashboard";
    }

    @PostMapping("/recordWater")
    public String recordWaterIntake(@RequestParam("quantity") int quantity, Principal principal) {
        //get the username from connected
        String username = principal.getName();

        // Save the water intake record
        waterIntakeService.recordWaterIntake(username, quantity);

        // Redirect back to the dashboard after recording water intake
        return "redirect:/dashboard";
    }
}
