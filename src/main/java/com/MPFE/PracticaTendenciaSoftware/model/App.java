package com.MPFE.PracticaTendenciaSoftware.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "app")
public class App {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idapp", nullable = false)
    private long idApp;

    @Column(name = "appname", nullable = false)
    private String appName;


    public App() {
    }
    
    public App(long idApp, String appName) {
        this.idApp = idApp;
        this.appName = appName;
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


}

    