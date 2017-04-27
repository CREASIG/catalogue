/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.creasig.gestion;

import org.creasig.inspire.Serveur;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author eric
 */
public class GestionServeur {

    EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction transac;

    public GestionServeur() {

        emf = Persistence.createEntityManagerFactory("ServeurPU");
        em = emf.createEntityManager();
        transac = em.getTransaction();

    }

    public void ajouter(String nom, String adresse, String port, String bdd, String utilisateur, String passe) {
        transac.begin();

        Serveur s = new Serveur();
        s.setNom(nom);
        s.setAdresse(adresse);
        s.setPort(port);
        s.setBdd(bdd);
        s.setUtilisateur(utilisateur);
        s.setPasse(passe);
        em.persist(s);
        transac.commit();
    }

    public void modifier(int id, String nom, String adresse, String port, String bdd, String utilisateur, String passe) {
        transac.begin();

        Serveur s = (Serveur) em.createNamedQuery("Serveur.findById").setParameter("id", id).getResultList().get(0);
        s.setId(id);
        s.setNom(nom);
        s.setAdresse(adresse);
        s.setPort(port);
        s.setBdd(bdd);
        s.setUtilisateur(utilisateur);
        s.setPasse(passe);
        em.persist(s);
        transac.commit();
    }

    public List<Serveur> getServeurs() {
        return em.createNamedQuery("Serveur.findAll").getResultList();

    }

    public void supprimer(String id) {
        transac.begin();
        Serveur s = (Serveur) em.createNamedQuery("Serveur.findById").setParameter("id", Integer.decode(id)).getResultList().get(0);
        em.remove(s);
        transac.commit();
    }

    public Serveur getServeur(String id) {
        System.err.println(Integer.parseInt(id));
        List l = em.createNamedQuery("Serveur.findById").setParameter("id", Integer.parseInt(id)).getResultList();
        if (l.size() >= 1) {
            return (Serveur)l.get(0);
        }else
        return null;
    }

}
