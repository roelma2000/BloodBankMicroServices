package com.assignment4.microserviceswebinterface.controller;

import com.assignment4.microserviceswebinterface.model.BloodStock;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Arrays;

@Controller
@RequestMapping("/bloodstocks")
public class BloodStockController {

    private final String apiUrl = "http://localhost:8083/bloodstocks";

    @GetMapping
    public String getAllBloodStocks(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        BloodStock[] bloodStocks = restTemplate.getForObject(apiUrl, BloodStock[].class);
        model.addAttribute("bloodstocks", Arrays.asList(bloodStocks));
        return "stock-list";
    }

    @GetMapping("/add")
    public String showAddBloodStockForm(Model model) {
        model.addAttribute("bloodStock", new BloodStock());
        return "addstock";
    }

    @PostMapping("/add")
    public String createBloodStock(@ModelAttribute @Valid BloodStock bloodStock, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("bloodStock", bloodStock);
            return "addstock";
        }

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(apiUrl, bloodStock, BloodStock.class);
        redirectAttributes.addFlashAttribute("message", "Blood stock added successfully.");
        return "redirect:/bloodstocks";
    }

    @GetMapping("/{bsid}/edit")
    public String editBloodStock(@PathVariable int bsid, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        BloodStock bloodStock = restTemplate.getForObject(apiUrl + "/{bsid}", BloodStock.class, bsid);
        model.addAttribute("bloodStock", bloodStock);
        return "editstock";
    }

    @PostMapping("/{bsid}/edit")
    public String updateBloodStock(@PathVariable int bsid, @Valid BloodStock updatedBloodStock, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "editstock";
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<BloodStock> request = new HttpEntity<>(updatedBloodStock);
        restTemplate.exchange(apiUrl + "/{bsid}", HttpMethod.PUT, request, Void.class, bsid);
        redirectAttributes.addFlashAttribute("message", "Blood stock updated successfully.");
        return "redirect:/bloodstocks";
    }

    @PostMapping("/{bsid}/delete")
    public String deleteBloodStock(@PathVariable int bsid, RedirectAttributes redirectAttributes) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(apiUrl + "/{bsid}", bsid);
        redirectAttributes.addFlashAttribute("message", "Blood stock deleted successfully.");
        return "redirect:/bloodstocks";
    }
}
