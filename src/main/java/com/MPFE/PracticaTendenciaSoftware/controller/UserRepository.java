package com.MPFE.PracticaTendenciaSoftware.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.MPFE.PracticaTendenciaSoftware.model.User;
import com.MPFE.PracticaTendenciaSoftware.repository.userRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserRepository {

    @Autowired
    private userRepository repository;

    @GetMapping("/user")
    public List<User> getUser() {
        return repository.findAll();
    }

    @PostMapping("/save-user")
    @ResponseBody
    public User saveUser(@RequestBody User user) {
        return repository.save(user);
    }

    @RequestMapping(value = "/user/id/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") long id) {
        return repository.findById(id).orElse(new User());
    }
    // Metodo no existente en Repositorio
    /*
     * @RequestMapping(value = "/user/name/{name}", method = RequestMethod.GET)
     * public List<User> getUserByName(@PathVariable("name") String name) { return
     * repository.findByName(name); }
     */

    @RequestMapping(value = "/edit-user/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public User updateUser(@PathVariable("id") long id, @RequestBody User user) {
        user.setIdUser(id);
        return repository.save(user);
    }

    @RequestMapping(value = "/delete-app/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") long id) {
        User user = repository.findById(id).get();
        if (user != null) {
            repository.delete(user);
        }
    }

    @GetMapping("login")
    public User login(@RequestParam("login") String login, @RequestParam("password") String password) {
        User user = repository.loginUser(login, password);

        if (user != null) {
            if (user.getToken() == null || user.getToken().isEmpty()) {
                user.setToken(getJWTToken(login));
                updateUser(user.getIdUser(), user);
            }
            return user;
        }

        return new User();

    }

    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 15);

        String token = Jwts.builder().setId("softtekJWT").setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(calendar.getTime())
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

        return "Bearer " + token;
    }

}
