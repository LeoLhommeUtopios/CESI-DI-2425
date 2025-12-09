package org.example.demoform.controller;

import jakarta.servlet.ServletRequest;
import org.example.demoform.entity.Voiture;
import org.example.demoform.service.VoitureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class VoitureController {

    private VoitureService voitureService;

    public VoitureController(VoitureService voitureService) {
        this.voitureService = voitureService;
    }

    @GetMapping
        public String home(){
        return "home";
    }

    @GetMapping("/list")
    public String getVoiture(Model model){
        List<Voiture> voitures = voitureService.get();
        model.addAttribute("voitures",voitures);
        return "voitureList";
    }

    @GetMapping("/voiture/{id}")
    public String getVoitureById (@PathVariable("id") int id,Model model){
        Voiture voiture = voitureService.get(id);
        model.addAttribute("voiture",voiture);
        return "voitureDetails";
    }

    @GetMapping("/add")
    public String addVoiture (Model model){
        Voiture voiture = new Voiture();
        model.addAttribute("voiture",voiture);
        return "voitureForm";
    }

    @PostMapping("/add")
    public String addVoiture (Voiture voiture){
        voitureService.create(voiture);
        return "redirect:/list";
    }
}
