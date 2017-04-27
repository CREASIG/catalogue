/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.creasig.gestion;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.creasig.inspire.Contacts;

/**
 *
 * @author eric
 */
public class GestionContacts {
        EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction transac;

    public GestionContacts() {

        emf = Persistence.createEntityManagerFactory("ServeurPU");
        em = emf.createEntityManager();
        transac = em.getTransaction();

    }

    public void ajouter(String nom, String organisme,String adresse, String ville, String cp, String email) {
        transac.begin();

        Contacts s = new Contacts();
        s.setNom(nom);
        s.setOrganisme(organisme);
        s.setAdresse(adresse);
        s.setVille(ville);
        s.setCp(cp);
        s.setEmail(email);
        em.persist(s);
        transac.commit();
    }

    public void modifier(int id,String nom, String organisme,String adresse, String ville, String cp, String email) {
        transac.begin();

        Contacts s = (Contacts) em.createNamedQuery("Contacts.findById").setParameter("id", id).getResultList().get(0);
        s.setId(id);
        s.setNom(nom);
        s.setAdresse(adresse);
        s.setOrganisme(organisme);
        s.setVille(ville);
        s.setCp(cp);
        s.setEmail(email);
        em.persist(s);
        transac.commit();
    }

    public List<Contacts> getContacts() {
        return em.createNamedQuery("Contacts.findAll").getResultList();
    }

    public void supprimer(String id) {
        transac.begin();
        Contacts s = (Contacts) em.createNamedQuery("Contacts.findById").setParameter("id", Integer.decode(id)).getResultList().get(0);
        em.remove(s);
        transac.commit();
    }

    public Contacts getContact(String id) {
        return (Contacts) em.createNamedQuery("Contacts.findById").setParameter("id", Integer.decode(id)).getResultList().get(0);
    }

}
