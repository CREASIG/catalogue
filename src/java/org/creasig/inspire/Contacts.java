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

/**
 *
 * @author eric
 */
@Entity
@Table(name = "contacts", catalog = "catalogue", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contacts.findAll", query = "SELECT c FROM Contacts c")
    , @NamedQuery(name = "Contacts.findById", query = "SELECT c FROM Contacts c WHERE c.id = :id")
    , @NamedQuery(name = "Contacts.findByNom", query = "SELECT c FROM Contacts c WHERE c.nom = :nom")
    , @NamedQuery(name = "Contacts.findByOrganisme", query = "SELECT c FROM Contacts c WHERE c.organisme = :organisme")
    , @NamedQuery(name = "Contacts.findByAdresse", query = "SELECT c FROM Contacts c WHERE c.adresse = :adresse")
    , @NamedQuery(name = "Contacts.findByVille", query = "SELECT c FROM Contacts c WHERE c.ville = :ville")
    , @NamedQuery(name = "Contacts.findByCp", query = "SELECT c FROM Contacts c WHERE c.cp = :cp")
    , @NamedQuery(name = "Contacts.findByEmail", query = "SELECT c FROM Contacts c WHERE c.email = :email")
    , @NamedQuery(name = "Contacts.findByRole", query = "SELECT c FROM Contacts c WHERE c.role = :role")})
public class Contacts implements Serializable {

    @OneToMany(mappedBy = "autrecontact")
    private Collection<Donnee> donneeCollection;
    @OneToMany(mappedBy = "contactmetadonnee")
    private Collection<Donnee> donneeCollection1;
    @OneToMany(mappedBy = "responsableressource")
    private Collection<Donnee> donneeCollection2;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "nom", length = 2147483647)
    private String nom;
    @Size(max = 2147483647)
    @Column(name = "organisme", length = 2147483647)
    private String organisme;
    @Size(max = 2147483647)
    @Column(name = "adresse", length = 2147483647)
    private String adresse;
    @Size(max = 2147483647)
    @Column(name = "ville", length = 2147483647)
    private String ville;
    @Size(max = 2147483647)
    @Column(name = "cp", length = 2147483647)
    private String cp;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 2147483647)
    @Column(name = "email", length = 2147483647)
    private String email;
    @Size(max = 2147483647)
    @Column(name = "role", length = 2147483647)
    private String role;

    public Contacts() {
    }

    public Contacts(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
        if (!(object instanceof Contacts)) {
            return false;
        }
        Contacts other = (Contacts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.creasig.inspire.Contacts[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<Donnee> getDonneeCollection() {
        return donneeCollection;
    }

    public void setDonneeCollection(Collection<Donnee> donneeCollection) {
        this.donneeCollection = donneeCollection;
    }

    @XmlTransient
    public Collection<Donnee> getDonneeCollection1() {
        return donneeCollection1;
    }

    public void setDonneeCollection1(Collection<Donnee> donneeCollection1) {
        this.donneeCollection1 = donneeCollection1;
    }

    @XmlTransient
    public Collection<Donnee> getDonneeCollection2() {
        return donneeCollection2;
    }

    public void setDonneeCollection2(Collection<Donnee> donneeCollection2) {
        this.donneeCollection2 = donneeCollection2;
    }
    
}
