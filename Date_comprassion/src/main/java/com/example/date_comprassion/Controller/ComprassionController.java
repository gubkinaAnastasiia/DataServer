package com.example.date_comprassion.Controller;

import com.example.date_comprassion.service.ComprassionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;

@Controller
public class ComprassionController {

    @Autowired
    private final ComprassionService service;

    public ComprassionController(ComprassionService service) {
        this.service = service;
    }

    @GetMapping("/time/comprassion")
    public String comprassion(Model model) {
        /*Получение локального времени*/
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/time";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entityString = new HttpEntity<String>(headers);
        String date = restTemplate.exchange(url, HttpMethod.GET, entityString, String.class).getBody();

        model.addAttribute("localtime", date);
        model.addAttribute("giventime", service.getGivenTime());
        model.addAttribute("result", service.comprassion(service.getGivenTime()));
        return "comprassion";
    }

    @GetMapping("/time/gettime")
    public String getTime(@ModelAttribute("givenTime") String time) {
        return "gettime";
    }

    @PostMapping("/time/gettime")
    public String saveTime(@RequestParam("givenTime") String givenTime) {
        service.setGivenTime(givenTime);
        return "redirect:/time/comprassion";
    }

}
