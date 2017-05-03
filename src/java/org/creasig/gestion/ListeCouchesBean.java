/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.creasig.gestion;

import org.creasig.inspire.Serveur;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.creasig.inspire.Colonnes;
import org.creasig.inspire.Communes;
import org.creasig.inspire.Departements;
import org.creasig.inspire.Donnee;
import org.creasig.inspire.Projection;
import org.creasig.inspire.Regions;

/**
 *
 * @author eric
 */
@ManagedBean
public class ListeCouchesBean implements Serializable {

    EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction transac;
    private String texte;

    /**
     * Creates a new instance of ListeCouchesBean
     */
    public ListeCouchesBean() {
        emf = Persistence.createEntityManagerFactory("ServeurPU");
        em = emf.createEntityManager();
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public void rechargerCouches(ActionEvent action) throws SQLException {
        Connection db = null;
        addMessage("Recharger");
        texte = "Rechargement en cours ";
        List<Serveur> liste = em.createNamedQuery("Serveur.findAll").getResultList();
        for (Serveur serveur : liste) {
            addMessage("Connexion au serveur :" + serveur.getNom());
            try {
                db = DriverManager.getConnection("jdbc:postgresql://" + serveur.getAdresse() + ":" + serveur.getPort() + "/" + serveur.getBdd(), serveur.getUtilisateur(), serveur.getPasse());
                //Création d'un objet Statement
                Statement state = db.createStatement();
                Statement state1 = db.createStatement();
                //L'objet ResultSet contient le résultat de la requête SQL
                ResultSet result = state.executeQuery("SELECT oid,pg_tables.* FROM pg_catalog.pg_tables,pg_class where schemaname <> 'pg_catalog' and schemaname <> 'information_schema' and tablename=relname");

                while (result.next()) {
                    Donnee donnee = new GestionDonnees().ajouter(serveur.getId(), result.getObject("tablename").toString(), result.getInt("oid"));

                    ResultSet result2 = state1.executeQuery("select attname as nom,attnum as oid,data_type as type from pg_attribute,information_schema.columns where attrelid='" + donnee.getIdtable() + "' and attnum >0 and table_name='" + donnee.getNomtable() + "' and attname=column_name;");
                    Collection<Colonnes> listecolonnes = new ArrayList<>();

                    while (result2.next()) {
                        Colonnes c = new Colonnes();
                        c.setId(null);
                        c.setIdunique(result2.getInt("oid"));
                        c.setNom(result2.getString("nom"));
                        c.setType(result2.getString("type"));
                        c.setIdDonnee(donnee);
//Récupération de la description de la colonne
                        if (donnee.getColonnes() != null) {
                            for (Iterator<Colonnes> iterator = donnee.getColonnes().iterator(); iterator.hasNext();) {
                                Colonnes next = iterator.next();
                                if (c.getIdunique().equals(next.getIdunique())) {
                                    c.setDescription(next.getDescription());
                                    c.setId(next.getId());
                                }
                            }
                        }
                        listecolonnes.add(c);
                    }

                    donnee.setColonnes(listecolonnes);
                    new GestionDonnees().modifier(donnee);
                }
                try {
                    
                    result = state.executeQuery("select oid,relname, geometry_columns.* from pg_class, geometry_columns where relname= geometry_columns.f_table_name");
                    while (result.next()) {
                        GestionDonnees d = new GestionDonnees();
                        Donnee donnee = d.ajouter(serveur.getId(), result.getObject("f_table_name").toString(), result.getInt("oid"));
                        donnee.setRefcoordonnees(new Projection(Integer.parseInt(result.getObject("srid").toString())));

                        ResultSet result1 = state1.executeQuery("SELECT min(ST_XMin(geometry(st_transform(" + result.getObject("f_geometry_column").toString() + ",4326)))) xmin, max(ST_XMax(geometry(st_transform(" + result.getObject("f_geometry_column").toString() + ",4326)))) xmax, min(ST_YMin(geometry(st_transform(" + result.getObject("f_geometry_column").toString() + ",4326)))) ymin, max(ST_YMax(geometry(st_transform(" + result.getObject("f_geometry_column").toString() + ",4326)))) ymax FROM " + result.getObject("f_table_schema").toString() + "." + result.getObject("f_table_name").toString() + ";");
                        if (result1.next()) {
                            donnee.setLato(result1.getFloat("xmin"));
                            donnee.setLate(result1.getFloat("xmax"));
                            donnee.setLatn(result1.getFloat("ymax"));
                            donnee.setLats(result1.getFloat("ymin"));
                            List<Departements> listedep = em.createNamedQuery("Departements.findDepartement").
                                    setParameter("xmin", result1.getFloat("xmin")).
                                    setParameter("xmax", result1.getFloat("xmax")).
                                    setParameter("ymin", result1.getFloat("ymin")).
                                    setParameter("ymax", result1.getFloat("ymax")).
                                    getResultList();
                            if (listedep.size() >= 1) {
                                donnee.setDepartement(new Departements(listedep.get(0).getId()));
                            }

                            List<Regions> listereg = em.createNamedQuery("Regions.findRegion").
                                    setParameter("xmin", result1.getFloat("xmin")).
                                    setParameter("xmax", result1.getFloat("xmax")).
                                    setParameter("ymin", result1.getFloat("ymin")).
                                    setParameter("ymax", result1.getFloat("ymax")).
                                    getResultList();
                            if (listereg.size() >= 1) {
                                donnee.setRegion(new Regions(listereg.get(0).getId()));
                            }

                            List<Communes> listecomm = em.createNamedQuery("Communes.findCommune").
                                    setParameter("xmin", result1.getFloat("xmin")).
                                    setParameter("xmax", result1.getFloat("xmax")).
                                    setParameter("ymin", result1.getFloat("ymin")).
                                    setParameter("ymax", result1.getFloat("ymax")).
                                    getResultList();

                            if (listecomm.size() >= 1) {
                                Communes c = new Communes();
                                c.setId(listecomm.get(0).getId());
                                c.setNom(listecomm.get(0).getNom());
                                donnee.setCommune(c);
                            }
                        }
                        new GestionDonnees().modifier(donnee);

                    }
                } catch (Exception e) {
                }

            } catch (SQLException e) {
                addMessage("impossible de se connecter au serveur " + serveur.getNom() + "\n" + e.getMessage());
            } finally {
                db.close();
            }
        }
    }

    public void addMessage(String message) {
        texte += message + "\n";
        FacesMessage message1 = new FacesMessage(FacesMessage.SEVERITY_INFO, message, null);
        FacesContext.getCurrentInstance().addMessage(null, message1);
    }

}
