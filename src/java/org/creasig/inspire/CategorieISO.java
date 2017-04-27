/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.creasig.inspire;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author eric
 */
@Entity
@Table(name = "categorieiso", catalog = "catalogue", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategorieISO.findAll", query = "SELECT c FROM CategorieISO c")
    , @NamedQuery(name = "CategorieISO.findById", query = "SELECT c FROM CategorieISO c WHERE c.id = :id")
    , @NamedQuery(name = "CategorieISO.findByNom", query = "SELECT c FROM CategorieISO c WHERE c.nom = :nom")
    , @NamedQuery(name = "CategorieISO.findByDescription", query = "SELECT c FROM CategorieISO c WHERE c.description = :description")})
public class CategorieISO implements Serializable {

    @OneToMany(mappedBy = "cattheme1")
    private Collection<Donnee> donneeCollection;
    @OneToMany(mappedBy = "cattheme2")
    private Collection<Donnee> donneeCollection1;
    @OneToMany(mappedBy = "cattheme3")
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
    @Column(name = "description", length = 2147483647)
    private String description;

    public CategorieISO() {
    }

    public CategorieISO(Integer id) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof CategorieISO)) {
            return false;
        }
        CategorieISO other = (CategorieISO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.creasig.inspire.CategorieISO[ id=" + id + " ]";
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
