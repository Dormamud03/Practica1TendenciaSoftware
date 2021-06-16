package com.MPFE.PracticaTendenciaSoftware.controller;

import java.util.List;

import com.MPFE.PracticaTendenciaSoftware.model.Application;
import com.MPFE.PracticaTendenciaSoftware.repository.appRepository;

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
public class AppController {

    @Autowired
    private appRepository repository;

    @GetMapping("/app")
    public List<Application> getApp() {
        return repository.findAll();
    }

    @PostMapping("/save-app")
    @ResponseBody
    public Application saveApp(@RequestBody Application app) {
        return repository.save(app);
    }

    @RequestMapping(value = "/app/id/{id}", method = RequestMethod.GET)
    public Application getAppById(@PathVariable("id") long id) {
        return repository.findById(id).orElse(new Application());
    }

    // Metodo no existente en Repositorio
    /*
     * @RequestMapping(value = "/app/name/{name}", method = RequestMethod.GET)
     * public List<App> getAppByName(@PathVariable("name") String name) { return
     * repository.findByName(name); }
     */

    @RequestMapping(value = "/edit-app/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Application updateApp(@PathVariable("id") long id, @RequestBody Application app) {
        app.setIdApp(id);
        return repository.save(app);
    }

    @RequestMapping(value = "/delete-app/{id}", method = RequestMethod.DELETE)
    public void deleteApp(@PathVariable("id") long id) {
        Application app = repository.findById(id).get();
        if (app != null) {
            repository.delete(app);
        }
    }

}
