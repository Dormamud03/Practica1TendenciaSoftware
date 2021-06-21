package com.MPFE.PracticaTendenciaSoftware.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "application")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idapp", nullable = false)
    private long idApp;

    @Column(name = "appname", nullable = false)
    private String appName;

    @Column(name = "appactive", nullable = false)
    private boolean appActive;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idemailtemplate", nullable = true)
    private List<EmailTemplates> emailTemplates = new ArrayList<>();

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "iduser", nullable = true)
    private List<User> applications = new ArrayList<>();

    public Application() {
    }
    
    public Application(long idApp, String appName, boolean appActive) {
        this.idApp = idApp;
        this.appName = appName;
        this.appActive = appActive;
    }
    

    public long getIdApp() {
        return this.idApp;
    }

    public void setIdApp(long idApp) {
        this.idApp = idApp;
    }

    public String getAppName() {
        return this.appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public boolean isAppActive() {
        return this.appActive;
    }

    public boolean getAppActive() {
        return this.appActive;
    }

    public void setAppActive(boolean appActive) {
        this.appActive = appActive;
    }

}

    