package com.assignment4.microserviceswebinterface.controller;

import com.assignment4.microserviceswebinterface.model.BloodBank;
import com.assignment4.microserviceswebinterface.model.Seeker;
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
import java.util.List;

@Controller
@RequestMapping("/bloodbanks")
public class BloodBankController {

    private final String apiUrl = "http://localhost:8082/bloodbanks";

    @GetMapping
    public String getAllBloodBanks(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        BloodBank[] bloodBanks = restTemplate.getForObject(apiUrl, BloodBank[].class);
        model.addAttribute("bloodbanks", Arrays.asList(bloodBanks));
        return "bloodbank-list";
    }

    @GetMapping("/{id}")
    public String getBloodBankById(@PathVariable Integer id, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        BloodBank bloodBank = restTemplate.getForObject(apiUrl + "/" + id, BloodBank.class);
        model.addAttribute("bloodbanks", bloodBank);
        return "bloodbank-details";
    }
    @GetMapping("/add")
    public String addBloodBankForm(Model model) {
        model.addAttribute("bloodBank", new BloodBank());
        return "addbloodbank";
    }
    @PostMapping("/add")
    public String createBloodBank(@ModelAttribute @Valid BloodBank bloodBank, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
//            System.out.println("Binding Result: " + bindingResult); // checking
            model.addAttribute("bloodBank", bloodBank);
            return "addbloodbank";
        }

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(apiUrl, bloodBank, BloodBank.class);
        redirectAttributes.addFlashAttribute("message", "Blood bank created successfully.");
        return "redirect:/bloodbanks";
    }
    @GetMapping("/{bbnid}/edit")
    public String editBloodBank(@PathVariable int bbnid, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        BloodBank bloodBank = restTemplate.getForObject(apiUrl + "/{bbnid}", BloodBank.class, bbnid);
        model.addAttribute("bloodBank", bloodBank);
        return "editbloodbank";
    }
    @PostMapping("/{id}")
    public String updateBloodBank(@PathVariable Integer id, @Valid BloodBank updatedBloodBank, RedirectAttributes redirectAttributes) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<BloodBank> request = new HttpEntity<>(updatedBloodBank);
        restTemplate.exchange(apiUrl + "/" + id, HttpMethod.PUT, request, Void.class);
        redirectAttributes.addFlashAttribute("message", "Blood bank updated successfully.");
        return "redirect:/bloodbanks";
    }

    @PostMapping("/{id}/delete")
    public String deleteBloodBank(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(apiUrl + "/" + id);
        redirectAttributes.addFlashAttribute("message", "Blood bank deleted successfully.");
        return "redirect:/bloodbanks";
    }
}