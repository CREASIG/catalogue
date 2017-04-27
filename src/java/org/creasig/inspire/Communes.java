/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.creasig.inspire;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "communes", catalog = "catalogue", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Communes.findAll", query = "SELECT c FROM Communes c")
    , @NamedQuery(name = "Communes.findById", query = "SELECT c FROM Communes c WHERE c.id = :id")
    , @NamedQuery(name = "Communes.findByNom", query = "SELECT c FROM Communes c WHERE c.nom = :nom")
    , @NamedQuery(name = "Communes.findByNomBeginWith", query = "SELECT c FROM Communes c WHERE lower(c.nom) LIKE lower(:nom)")
    , @NamedQuery(name = "Communes.findCommune", query = "SELECT d FROM Communes d WHERE d.wgs84Xmin <=:xmin AND :xmax <= d.wgs84Xmax AND d.wgs84Ymin <= :ymin AND :ymax <= d.wgs84Ymax")
    , @NamedQuery(name = "Communes.findByWgs84Xmax", query = "SELECT c FROM Communes c WHERE c.wgs84Xmax = :wgs84Xmax")
    , @NamedQuery(name = "Communes.findByWgs84Xmin", query = "SELECT c FROM Communes c WHERE c.wgs84Xmin = :wgs84Xmin")
    , @NamedQuery(name = "Communes.findByWgs84Ymax", query = "SELECT c FROM Communes c WHERE c.wgs84Ymax = :wgs84Ymax")
    , @NamedQuery(name = "Communes.findByWgs84Ymin", query = "SELECT c FROM Communes c WHERE c.wgs84Ymin = :wgs84Ymin")})
public class Communes implements Serializable {

    @Column(name = "wgs84_xmax")
    private float wgs84Xmax;
    @Column(name = "wgs84_xmin")
    private float wgs84Xmin;
    @Column(name = "wgs84_ymax")
    private float wgs84Ymax;
    @Column(name = "wgs84_ymin")
    private float wgs84Ymin;

    @OneToMany(mappedBy = "commune")
    private Collection<Donnee> donneeCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 255)
    @Column(name = "nom", length = 255)
    private String nom;

    public Communes() {
    }

    public Communes(Integer id) {
        this.id = id;
    }

    public Communes(String nom) {
        this.nom = nom;
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

    public float getWgs84Xmax() {
        return wgs84Xmax;
    }

    public void setWgs84Xmax(float wgs84Xmax) {
        this.wgs84Xmax = wgs84Xmax;
    }

    public float getWgs84Xmin() {
        return wgs84Xmin;
    }

    public void setWgs84Xmin(float wgs84Xmin) {
        this.wgs84Xmin = wgs84Xmin;
    }

    public float getWgs84Ymax() {
        return wgs84Ymax;
    }

    public void setWgs84Ymax(float wgs84Ymax) {
        this.wgs84Ymax = wgs84Ymax;
    }

    public float getWgs84Ymin() {
        return wgs84Ymin;
    }

    public void setWgs84Ymin(float wgs84Ymin) {
        this.wgs84Ymin = wgs84Ymin;
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
        if (!(object instanceof Communes)) {
            return false;
        }
        Communes other = (Communes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nom;
    }

    @XmlTransient
    public Collection<Donnee> getDonneeCollection() {
        return donneeCollection;
    }

    public void setDonneeCollection(Collection<Donnee> donneeCollection) {
        this.donneeCollection = donneeCollection;
    }
    
}
