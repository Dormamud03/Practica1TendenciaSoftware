package com.MPFE.PracticaTendenciaSoftware.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "email_templates")
public class EmailTemplates {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idemailtemplate", nullable = false)
    private long idEmailTemplate;

    @Column(name = "notification_type", nullable = false)
    private String notifiationType;

    @Column(name = "value", nullable = false)
    private String value;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idapp", nullable = true)
    private Application application;


    public EmailTemplates() {
    }


    public EmailTemplates(long idEmailTemplate, String notifiationType, String value, Application application) {
        this.idEmailTemplate = idEmailTemplate;
        this.notifiationType = notifiationType;
        this.value = value;
        this.application = application;
    }


    public long getIdEmailTemplate() {
        return this.idEmailTemplate;
    }

    public void setIdEmailTemplate(long idEmailTemplate) {
        this.idEmailTemplate = idEmailTemplate;
    }

    public String getNotifiationType() {
        return this.notifiationType;
    }

    public void setNotifiationType(String notifiationType) {
        this.notifiationType = notifiationType;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Application getApplication() {
        return this.application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }


}
