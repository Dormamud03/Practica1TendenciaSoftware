package com.MPFE.PracticaTendenciaSoftware.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "iduser", nullable = false)
    private long idUser;
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "lastname", nullable = false)
    private String lastName;

    @Column(name = "cedula", nullable = false)
    private String cedula;

    @Column(name = "genre", nullable = false)
    private String genre;

    @Column(name = "username", nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "active", nullable = false)
    private String active;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idapp", nullable = true)
    private Application application;

    @Column(name = "source", nullable = false)
    private String souerce;

    @Column(name = "token", nullable = true)
    private String token;

    public User() {
    }

    
    /**
     * @param idUser
     * @param name
     * @param lastName
     * @param cedula
     * @param genre
     * @param userName
     * @param password
     * @param active
     * @param application
     * @param souerce
     * @param token
     */
    public User(long idUser, String name, String lastName, String cedula, String genre, String userName,
            String password, String active, Application application, String souerce, String token) {
        this.idUser = idUser;
        this.name = name;
        this.lastName = lastName;
        this.cedula = cedula;
        this.genre = genre;
        this.userName = userName;
        this.password = password;
        this.active = active;
        this.application = application;
        this.souerce = souerce;
        this.token = token;
    }


    public long getIdUser() {
        return this.idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return String return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * @return String return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * @return String return the active
     */
    public String getActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(String active) {
        this.active = active;
    }

    /**
     * @return Application return the application
     */
    public Application getApplication() {
        return application;
    }

    /**
     * @param application the application to set
     */
    public void setApplication(Application application) {
        this.application = application;
    }

    /**
     * @return String return the souerce
     */
    public String getSouerce() {
        return souerce;
    }

    /**
     * @param souerce the souerce to set
     */
    public void setSouerce(String souerce) {
        this.souerce = souerce;
    }

}
