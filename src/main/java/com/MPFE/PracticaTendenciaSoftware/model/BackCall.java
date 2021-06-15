package com.MPFE.PracticaTendenciaSoftware.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "backcall")
public class BackCall {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idBackcall;

    @JsonBackReference
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idapp", nullable = false)
    private App idApp;

    @Column(name = "callurl", nullable = false)
    private String callurl;

    public BackCall() {
    }

    public BackCall(long idBackcall, App idApp, String callurl) {
        this.idBackcall = idBackcall;
        this.idApp = idApp;
        this.callurl = callurl;
    }
    

    public long getIdBackcall() {
        return this.idBackcall;
    }

    public void setIdBackcall(long idBackcall) {
        this.idBackcall = idBackcall;
    }

    public App getIdApp() {
        return this.idApp;
    }

    public void setIdApp(App idApp) {
        this.idApp = idApp;
    }

    public String getCallurl() {
        return this.callurl;
    }

    public void setCallurl(String callurl) {
        this.callurl = callurl;
    }

}
