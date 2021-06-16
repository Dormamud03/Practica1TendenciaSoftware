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

@Entity
@Table(name = "configuration_email")
public class ConfigurationEmail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idconfigemail", nullable = false)
    private long idConfigEmail;

    @Column(name = "email_notification", nullable = false)
    private String emailNotification;

    @Column(name = "pass_email", nullable = false)
    private String passEmail;

    @Column(name = "host_email", nullable = false)
    private String hostEmail;
    
    @Column(name = "port_email", nullable = false)
    private String portEmail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idapp", nullable = true)
    private Application application;

    public ConfigurationEmail() {
    }

    public ConfigurationEmail(long idConfigEmail, String emailNotification, String passEmail, String hostEmail, String portEmail, Application application) {
        this.idConfigEmail = idConfigEmail;
        this.emailNotification = emailNotification;
        this.passEmail = passEmail;
        this.hostEmail = hostEmail;
        this.portEmail = portEmail;
        this.application = application;
    }
    
}
