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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author eric
 */
@Entity
@Table(name = "langues", catalog = "catalogue", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Langues.findAll", query = "SELECT l FROM Langues l")
    , @NamedQuery(name = "Langues.findByNom", query = "SELECT l FROM Langues l WHERE l.nom = :nom")
    , @NamedQuery(name = "Langues.findById", query = "SELECT l FROM Langues l WHERE l.id = :id")})
public class Langues implements Serializable {

    @OneToMany(mappedBy = "languemetadonnee")
    private Collection<Donnee> donneeCollection;
    @OneToMany(mappedBy = "languedescription")
    private Collection<Donnee> donneeCollection1;

    private static final long serialVersionUID = 1L;
    @Size(max = 2147483647)
    @Column(name = "nom", length = 2147483647)
    private String nom;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "id", nullable = false, length = 7)
    private String id;

    public Langues(){
        this.id="fre";
    }
    public Langues(String id){
        this.id=id;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        if (!(object instanceof Langues)) {
            return false;
        }
        Langues other = (Langues) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.creasig.inspire.Langues[ id=" + id + " ]";
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
    
}
