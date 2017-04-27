/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.creasig.gestion;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.creasig.inspire.Contacts;

/**
 *
 * @author eric
 */
@ManagedBean
@SessionScoped
public class ContactsFace implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String nom;
    private String organisme;
    private String adresse;
    private String ville;
    private String cp;
    private String email;
    private String action;
    private String descriptionaction;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getOrganisme() {
        return organisme;
    }

    public void setOrganisme(String organisme) {
        this.organisme = organisme;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDescriptionaction() {
        return descriptionaction;
    }

    public void setDescriptionaction(String descriptionaction) {
        this.descriptionaction = descriptionaction;
    }

    public List<Contacts> getContacts() {
        return (new GestionContacts()).getContacts();
    }

    public void viderformulaire() {
        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
        action = bundle.getString("ajouter");

        bundle = context.getApplication().getResourceBundle(context, "msg");
        descriptionaction = bundle.getString("ajouterbdd");

        id = 0;
        nom = "";
        organisme = "";
        adresse = "";
        ville = "";
        cp = "";
        email = "";
    }

    public String supprimer() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String id = params.get("id");
        (new GestionContacts()).supprimer(id);
        return "";
    }

    public String ajouter() {

        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
        String nomaction = bundle.getString("ajouter");
        if (action.equals(nomaction)) {
            (new GestionContacts()).ajouter(nom, organisme, adresse,  ville,  cp,  email);
        } else {
            (new GestionContacts()).modifier(id,nom, organisme, adresse,  ville,  cp,  email);
        }
        return "result";
    }

    public void charger() {
        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
        action = bundle.getString("modifier");

        bundle = context.getApplication().getResourceBundle(context, "msg");
        descriptionaction = bundle.getString("modifierbdd");

        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String id = params.get("id");
        Contacts s = (new GestionContacts()).getContact(id);
        nom = s.getNom();
        adresse = s.getAdresse();
        organisme = s.getOrganisme();
        ville = s.getVille();
        cp = s.getCp();
        email = s.getEmail();
        this.id = s.getId();

    }

}
