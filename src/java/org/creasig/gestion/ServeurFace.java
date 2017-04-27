/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.creasig.gestion;

import org.creasig.inspire.Serveur;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author eric
 */
@ManagedBean
@SessionScoped

public class ServeurFace implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nom;
    private String adresse;
    private int port;
    private int id;
    private String bdd;
    private String utilisateur;
    private String passe;
    private String action;
    private String descriptionaction;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescriptionaction() {
        return descriptionaction;
    }

    public void setDescriptionaction(String descriptionaction) {
        this.descriptionaction = descriptionaction;
    }

    
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getBdd() {
        return bdd;
    }

    public void setBdd(String bdd) {
        this.bdd = bdd;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getPasse() {
        return passe;
    }

    public void setPasse(String passe) {
        this.passe = passe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Serveur> getServeurs() {
        return (new GestionServeur()).getServeurs();
    }

    public void viderformulaire() {
        System.err.println("vider");
        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
        action = bundle.getString("ajouter");

        bundle = context.getApplication().getResourceBundle(context, "msg");
        descriptionaction = bundle.getString("ajouterbdd");

        id=0;
        nom = "";
        adresse = "";
        port = 0;
        bdd = "";
        utilisateur = "";
        passe = "";
    }

    public String supprimer() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String id = params.get("id");
        (new GestionServeur()).supprimer(id);
        return "result";
    }

    public String ajouter() {
        
        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
        String nomaction = bundle.getString("ajouter");
        if (action.equals(nomaction)) {
            (new GestionServeur()).ajouter(nom, adresse, Integer.toString(port), bdd, utilisateur, passe);
        } else {
            (new GestionServeur()).modifier(id,nom, adresse, Integer.toString(port), bdd, utilisateur, passe);
        }
        return "result";
    }

    public void chargerserveur() {
        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
        action = bundle.getString("modifier");

        bundle = context.getApplication().getResourceBundle(context, "msg");
        descriptionaction = bundle.getString("modifierbdd");
        
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String id = params.get("id");
        Serveur s = (new GestionServeur()).getServeur(id);
        nom = s.getNom();
        adresse = s.getAdresse();
        port = Integer.decode(s.getPort());
        bdd = s.getBdd();
        utilisateur = s.getUtilisateur();
        passe = s.getPasse();
        this.id=s.getId();

    }

}
