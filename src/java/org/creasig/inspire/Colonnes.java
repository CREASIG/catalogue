/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.creasig.inspire;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eric
 */
@Entity
@Table(name = "colonnes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Colonnes.findAll", query = "SELECT c FROM Colonnes c")
    , @NamedQuery(name = "Colonnes.findById", query = "SELECT c FROM Colonnes c WHERE c.id = :id")
    , @NamedQuery(name = "Colonnes.findByIdunique", query = "SELECT c FROM Colonnes c WHERE c.idunique = :idunique")
    , @NamedQuery(name = "Colonnes.findByNom", query = "SELECT c FROM Colonnes c WHERE c.nom = :nom")
    , @NamedQuery(name = "Colonnes.findByDescription", query = "SELECT c FROM Colonnes c WHERE c.description = :description")})
public class Colonnes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "idunique")
    private Integer idunique;
    @Size(max = 2147483647)
    @Column(name = "nom")
    private String nom;
    @Size(max = 2147483647)
    @Column(name = "type")
    private String type;
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "iddonnee", referencedColumnName = "id")
    @ManyToOne()
    private Donnee iddonnee;

    public Colonnes() {
    }

    public Colonnes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdunique() {
        return idunique;
    }

    public void setIdunique(Integer idunique) {
        this.idunique = idunique;
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

    public Donnee getIdDonnee() {
        return iddonnee;
    }

    public void setIdDonnee(Donnee iddonnee) {
        this.iddonnee = iddonnee;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        if (!(object instanceof Colonnes)) {
            return false;
        }
        Colonnes other = (Colonnes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.creasig.inspire.Colonnes[ id=" + id + "; nom="+nom+"; type="+type+"; description="+description+"; idunique="+idunique+" ]";
    }
    
}
