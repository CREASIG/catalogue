/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.creasig.inspire;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.creasig.inspire.Donnee;

/**
 *
 * @author eric
 */
@Entity
@Table(name = "serveur")

@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Serveur.findAll", query = "SELECT s FROM Serveur s"),
    @NamedQuery(name = "Serveur.findById", query = "SELECT s FROM Serveur s WHERE s.id = :id"),
    @NamedQuery(name = "Serveur.findByAdresse", query = "SELECT s FROM Serveur s WHERE s.adresse = :adresse"),
    @NamedQuery(name = "Serveur.findByPort", query = "SELECT s FROM Serveur s WHERE s.port = :port"),
    @NamedQuery(name = "Serveur.findByUtilisateur", query = "SELECT s FROM Serveur s WHERE s.utilisateur = :utilisateur"),
    @NamedQuery(name = "Serveur.findByPasse", query = "SELECT s FROM Serveur s WHERE s.passe = :passe"),
    @NamedQuery(name = "Serveur.findByBdd", query = "SELECT s FROM Serveur s WHERE s.bdd = :bdd")})
public class Serveur implements Serializable {

    @OneToMany(mappedBy = "serveur")
    private Collection<Donnee> donneeCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "nom")
    private String nom;
    @Size(max = 2147483647)
    @Column(name = "adresse")
    private String adresse;
    @Size(max = 2147483647)
    @Column(name = "port")
    private String port;
    @Size(max = 2147483647)
    @Column(name = "utilisateur")
    private String utilisateur;
    @Size(max = 2147483647)
    @Column(name = "passe")
    private String passe;
    @Size(max = 2147483647)
    @Column(name = "bdd")
    private String bdd;

    public Serveur() {
    }

    public Serveur(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
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

    public String getBdd() {
        return bdd;
    }

    public void setBdd(String bdd) {
        this.bdd = bdd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Serveur)) {
            return false;
        }
        Serveur other = (Serveur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.creasig.gestion.Serveur[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<Donnee> getDonneeCollection() {
        return donneeCollection;
    }

    public void setDonneeCollection(Collection<Donnee> donneeCollection) {
        this.donneeCollection = donneeCollection;
    }
    
}
