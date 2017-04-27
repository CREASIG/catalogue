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
@Table(name = "restrictioninspire", catalog = "catalogue", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RestrictionInspire.findAll", query = "SELECT r FROM RestrictionInspire r")
    , @NamedQuery(name = "RestrictionInspire.findById", query = "SELECT r FROM RestrictionInspire r WHERE r.id = :id")
    , @NamedQuery(name = "RestrictionInspire.findByDescriptions", query = "SELECT r FROM RestrictionInspire r WHERE r.descriptions = :descriptions")
    , @NamedQuery(name = "RestrictionInspire.findByNom", query = "SELECT r FROM RestrictionInspire r WHERE r.nom = :nom")})
public class RestrictionInspire implements Serializable {

    @OneToMany(mappedBy = "restrictionsinspire")
    private Collection<Donnee> donneeCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "descriptions", length = 2147483647)
    private String descriptions;
    @Size(max = 255)
    @Column(name = "nom", length = 255)
    private String nom;

    public RestrictionInspire() {
    }

    public RestrictionInspire(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
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
        if (!(object instanceof RestrictionInspire)) {
            return false;
        }
        RestrictionInspire other = (RestrictionInspire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.creasig.inspire.RestrictionInspire[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<Donnee> getDonneeCollection() {
        return donneeCollection;
    }

    public void setDonneeCollection(Collection<Donnee> donneeCollection) {
        this.donneeCollection = donneeCollection;
    }
    
}
