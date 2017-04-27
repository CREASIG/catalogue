/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.creasig.inspire;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eric
 */
@Entity
@Table(name = "projection", catalog = "catalogue", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Projection.findAll", query = "SELECT p FROM Projection p")
    , @NamedQuery(name = "Projection.findById", query = "SELECT p FROM Projection p WHERE p.id = :id")
    , @NamedQuery(name = "Projection.findByNom", query = "SELECT p FROM Projection p WHERE p.nom = :nom")})
public class Projection implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false, precision = 131089, scale = 0)
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "nom", length = 2147483647)
    private String nom;

    public Projection() {
    }

    public Projection(Integer id) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projection)) {
            return false;
        }
        Projection other = (Projection) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.creasig.inspire.Projection[ id=" + id + " ]";
    }
    
}
