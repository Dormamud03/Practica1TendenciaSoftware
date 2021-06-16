package com.MPFE.PracticaTendenciaSoftware.controller;

import java.util.List;

import com.MPFE.PracticaTendenciaSoftware.repository.configurationEmailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ConfigurationEmailController {

    @Autowired
    private configurationEmailRepository configurationEmailRepository;

    @GetMapping("/configurationemail")
    public List<ConfigurationEmail> getConfigEmail() {
        return configurationEmailRepository.findAll();
    }

    @PostMapping("/save-configurationemail")
    @ResponseBody
    public ConfigurationEmail saveConfigurationEmail(@RequestBody ConfigurationEmail configurationEmail) {
        return configurationEmailRepository.save(configurationEmail);
    }

    @RequestMapping(value = "/configurationemail/id/{id}", method = RequestMethod.GET)
    public ConfigurationEmail getConfigurationEmailById(@PathVariable("id") long id) {
        return configurationEmailRepository.findById(id).orElse(new ConfigurationEmail());
    }

    @RequestMapping(value = "/edit-configurationemail/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ConfigurationEmail updateConfigurationEmail(@PathVariable("id") long id,
            @RequestBody ConfigurationEmail configurationEmail) {
        configurationEmail.setIdUser(id);
        return configurationEmailRepository.save(configurationEmail);
    }

}