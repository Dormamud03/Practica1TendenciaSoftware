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

    public ConfigurationEmail(long idConfigEmail, String emailNotification, String passEmail, String hostEmail,
            String portEmail, Application application) {
        this.idConfigEmail = idConfigEmail;
        this.emailNotification = emailNotification;
        this.passEmail = passEmail;
        this.hostEmail = hostEmail;
        this.portEmail = portEmail;
        this.application = application;
    }

    /**
     * @return long return the idConfigEmail
     */
    public long getIdConfigEmail() {
        return idConfigEmail;
    }

    /**
     * @param idConfigEmail the idConfigEmail to set
     */
    public void setIdConfigEmail(long idConfigEmail) {
        this.idConfigEmail = idConfigEmail;
    }

    /**
     * @return String return the emailNotification
     */
    public String getEmailNotification() {
        return emailNotification;
    }

    /**
     * @param emailNotification the emailNotification to set
     */
    public void setEmailNotification(String emailNotification) {
        this.emailNotification = emailNotification;
    }

    /**
     * @return String return the passEmail
     */
    public String getPassEmail() {
        return passEmail;
    }

    /**
     * @param passEmail the passEmail to set
     */
    public void setPassEmail(String passEmail) {
        this.passEmail = passEmail;
    }

    /**
     * @return String return the hostEmail
     */
    public String getHostEmail() {
        return hostEmail;
    }

    /**
     * @param hostEmail the hostEmail to set
     */
    public void setHostEmail(String hostEmail) {
        this.hostEmail = hostEmail;
    }

    /**
     * @return String return the portEmail
     */
    public String getPortEmail() {
        return portEmail;
    }

    /**
     * @param portEmail the portEmail to set
     */
    public void setPortEmail(String portEmail) {
        this.portEmail = portEmail;
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

}
