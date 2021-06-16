package com.MPFE.PracticaTendenciaSoftware.controller; 

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.MPFE.PracticaTendenciaSoftware.model.App;
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
    public List<App> getApp() {
        return repository.findAll();
    }

    @PostMapping("/save-app")
    @ResponseBody
    public App saveApp(@RequestBody App app) {
        return repository.save(app);
    }

    @RequestMapping(value = "/app/id/{id}", method = RequestMethod.GET)
    public App getAppById(@PathVariable("id") long id) {
        return repository.findById(id).orElse(new App());
    }

    @RequestMapping(value = "/app/name/{name}", method = RequestMethod.GET)
    public List<App> getAppByName(@PathVariable("name") String name) {
        return repository.findByName(name);
    }

    @RequestMapping(value = "/edit-app/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public App updateApp(@PathVariable("id") long id, @RequestBody App app) {
        app.setIdApp(id);
        return repository.save(app);
    }

    @RequestMapping(value = "/delete-app/{id}", method = RequestMethod.DELETE)
    public void deleteApp(@PathVariable("id") long id) {
        App app = repository.findById(id).get();
        if (app != null) {
            repository.delete(app);
        }
    }
    
}
