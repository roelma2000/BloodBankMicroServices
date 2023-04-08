package com.assignment4.microserviceswebinterface.controller;

import com.assignment4.microserviceswebinterface.model.Seeker;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

@Controller
@RequestMapping({"/","/seekers"})
public class SeekerController {

    private final String apiUrl = "http://localhost:8081/seekers";

    @GetMapping({"", "/"})
    public String getSeekers(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        Seeker[] seekers = restTemplate.getForObject(apiUrl, Seeker[].class);
        model.addAttribute("seekers", Arrays.asList(seekers));
        return "seeker-list";
    }

    @GetMapping("/add")
    public String addSeekersForm(Model model) {
        model.addAttribute("seeker", new Seeker());
        return "addseeker";
    }

    @PostMapping("/add")
    public String addSeeker(@Valid Seeker seeker, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "addseeker";
        }

        seeker.setAge(calculateAge(seeker.getBirthdate()));
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(apiUrl, seeker, Seeker.class);
        redirectAttributes.addFlashAttribute("message", "Seeker added successfully.");

        return "redirect:/seekers";
    }

    @GetMapping("/{seekerId}/edit")
    public String editSeeker(@PathVariable int seekerId, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        Seeker seeker = restTemplate.getForObject(apiUrl + "/{seekerId}", Seeker.class, seekerId);
        model.addAttribute("seeker", seeker);
        return "editseeker";
    }

    @PostMapping("/{seekerId}/edit")
    public String updateSeeker(@PathVariable int seekerId, @Valid Seeker updatedSeeker, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "editseeker";
        }

        updatedSeeker.setAge(calculateAge(updatedSeeker.getBirthdate()));
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Seeker> request = new HttpEntity<>(updatedSeeker);
        restTemplate.exchange(apiUrl + "/{seekerId}", HttpMethod.PUT, request, Void.class, seekerId);
        redirectAttributes.addFlashAttribute("message", "Seeker record updated successfully.");

        return "redirect:/seekers";
    }

    @PostMapping("/{seekerId}/delete")
    public String deleteSeeker(@PathVariable int seekerId, RedirectAttributes redirectAttributes) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(apiUrl + "/{seekerId}", seekerId);
        redirectAttributes.addFlashAttribute("message", "Seeker record deleted successfully.");

        return "redirect:/seekers";
    }

    private int calculateAge(LocalDate birthdate) {
        LocalDate now = LocalDate.now();
        Period period = Period.between(birthdate, now);
        return period.getYears();
    }
}
