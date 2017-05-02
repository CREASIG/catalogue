/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.creasig.gestion;

import java.util.ArrayList;
import java.util.Collection;
import org.creasig.inspire.Serveur;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.creasig.inspire.CategorieISO;
import org.creasig.inspire.CoherenceTopologique;
import org.creasig.inspire.Colonnes;
import org.creasig.inspire.Communes;
import org.creasig.inspire.ConditionUtilisation;
import org.creasig.inspire.Contacts;
import org.creasig.inspire.ContrainteLegale;
import org.creasig.inspire.ContraintesSecurite;
import org.creasig.inspire.Departements;
import org.creasig.inspire.Donnee;
import org.creasig.inspire.Encodage;
import org.creasig.inspire.Langues;
import org.creasig.inspire.Projection;
import org.creasig.inspire.Regions;
import org.creasig.inspire.RepresentationSpatiale;
import org.creasig.inspire.RessourceConforme;
import org.creasig.inspire.RestrictionInspire;
import org.creasig.inspire.ThemeInspire;
import org.creasig.inspire.TypeRessource;

/**
 *
 * @author eric
 */
public class GestionDonnees {

    EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction transac;

    public GestionDonnees() {

        emf = Persistence.createEntityManagerFactory("ServeurPU");
        em = emf.createEntityManager();
        transac = em.getTransaction();

    }

    public Donnee ajouter(int idserveur, String nomtable, int idtable) {

        em.getTransaction().begin();

        List<Donnee> liste = em.createNamedQuery("Donnee.findByIdserveurAndidTable").setParameter("id", idserveur).setParameter("idtable", idtable).getResultList();
        if (liste.size() != 0) {
            return liste.get(0);
        } else {
            Donnee d = new Donnee();
            d.setServeur(new Serveur(idserveur));
            d.setNomtable(nomtable);
            d.setIntitule(nomtable);
            d.setIdtable(idtable);
            d.setLanguedescription(new Langues("fre"));
            d.setLanguemetadonnee(new Langues("fre"));
            d.setCattheme1(new CategorieISO(1));
            d.setCattheme2(new CategorieISO(1));
            d.setCattheme3(new CategorieISO(1));
            d.setThemeinspire(new ThemeInspire(1));
            d.setRegion(new Regions(1));
            d.setDepartement(new Departements(1));
            d.setCommune(new Communes(1));
            d.setLate(0);
            d.setLato(0);
            d.setLats(0);
            d.setLatn(0);

            d.setDatecreation(new Date());
            d.setDatedebutpublication(new Date());
            d.setDatederniererevision(new Date());
            d.setDatepublication(new Date());

            d.setRestrictionsinspire(new RestrictionInspire(1));
            d.setContraintelegale(new ContrainteLegale(1));
            d.setTyperessource(new TypeRessource(1));
            d.setJeucaractere(new Encodage(1));
            d.setRepresentationspatiale(new RepresentationSpatiale(1));
            d.setCoherencetopologique(new CoherenceTopologique(1));
            d.setRessourceconforme(new RessourceConforme(1));
            d.setRefcoordonnees(new Projection(1));
            d.setContraintesecurite(new ContraintesSecurite(1));

            em.persist(d);
            em.getTransaction().commit();
            return d;
        }
    }

    public void modifier(Donnee donnee) {

        em.getTransaction().begin();

        Donnee s = (Donnee) em.createNamedQuery("Donnee.findById").setParameter("id", donnee.getId()).getResultList().get(0);
        //s.setId(donnee.getId());
        s.setIntitule(donnee.getIntitule());
//        s.setIdtable(donnee.getIdtable());
        s.setNomtable(donnee.getNomtable());
        s.setResume(donnee.getResume());

        s.setCattheme1(donnee.getCattheme1());
        s.setCattheme2(donnee.getCattheme2());
        s.setCattheme3(donnee.getCattheme3());
        s.setThemeinspire(donnee.getThemeinspire());
        s.setDepartement(donnee.getDepartement());
        s.setRegion(donnee.getRegion());
//        s.setCommune(donnee.getCommune());
        System.err.println(donnee.getCommune());
        if (Objects.isNull(donnee.getCommune()) || Objects.isNull(donnee.getCommune().getNom()) || donnee.getCommune().getNom().trim().equals("")) {
            s.setCommune(null);
        } else {
            List<Communes> c = em.createNamedQuery("Communes.findByNom").setParameter("nom", donnee.getCommune().getNom()).getResultList();
            if (c.size() > 0) {
                s.setCommune(c.get(0));
            }
        }

        s.setLatn(donnee.getLatn());
        s.setLats(donnee.getLats());
        s.setLate(donnee.getLate());
        s.setLato(donnee.getLato());
        s.setDatedebutpublication(donnee.getDatedebutpublication());
        s.setDatecreation(donnee.getDatecreation());
        s.setDatederniererevision(donnee.getDatederniererevision());
        s.setDatepublication(donnee.getDatepublication());
        s.setEtenduemin(donnee.getEtenduemin());
        s.setEtenduemax(donnee.getEtenduemax());
        s.setGenealogieressource(donnee.getGenealogieressource());
        s.setContactmetadonnee(donnee.getContactmetadonnee());
        s.setResponsableressource(donnee.getResponsableressource());
        s.setRestrictionsinspire(donnee.getRestrictionsinspire());
        s.setContraintelegale(donnee.getContraintelegale());
        s.setAdresseinternet(donnee.getAdresseinternet());
        s.setAdressetelechargement(donnee.getAdressetelechargement());
        s.setAdressevisualisation(donnee.getAdressevisualisation());
        s.setNominternet(donnee.getNominternet());
        s.setNomtelechargement(donnee.getNomtelechargement());
        s.setNomvisualisation(donnee.getNomvisualisation());
        s.setLanguemetadonnee(donnee.getLanguemetadonnee());
        s.setMotscle(donnee.getMotscle());
        s.setTyperessource(donnee.getTyperessource());
        s.setLimiteutilisation(donnee.getLimiteutilisation());
        s.setLanguedescription(donnee.getLanguedescription());
        s.setJeucaractere(donnee.getJeucaractere());
        s.setRepresentationspatiale(donnee.getRepresentationspatiale());
        s.setRefcoordonnees(donnee.getRefcoordonnees());
        s.setReferencetemporelle(donnee.getReferencetemporelle());
        s.setCoherencetopologique(donnee.getCoherencetopologique());
        s.setEchelle(donnee.getEchelle());
        s.setResolution(donnee.getResolution());
        s.setAutrecontact(donnee.getAutrecontact());
        s.setTitrespec(donnee.getTitrespec());
        s.setDatedebutpublication(donnee.getDatedebutpublication());
        s.setRessourceconforme(donnee.getRessourceconforme());
        Collection<Colonnes> listecolonnes = em.createNamedQuery("Colonnes.findByIdTable").setParameter("iddonnee", donnee.getIdtable()).getResultList();

        // mise à jour des colonnes existante
        for (Iterator<Colonnes> iteratororigine = listecolonnes.iterator(); iteratororigine.hasNext();) {
            Colonnes origine = iteratororigine.next();
            boolean trouve = false;
            for (Iterator<Colonnes> iterator = donnee.getColonnes().iterator(); iterator.hasNext();) {
                Colonnes maj = iterator.next();
                if (origine.getIdDonnee().getId().equals(maj.getIdDonnee().getId()) && origine.getIdunique().equals(maj.getIdunique())) {
                    origine.setNom(maj.getNom());
                    origine.setDescription(maj.getDescription());
                    trouve = true;
                }
                if (!trouve) {
                    em.remove(origine);
                }
            }
        }

        //Ajout des nouvelles colonnes
        for (Iterator<Colonnes> iterator = donnee.getColonnes().iterator(); iterator.hasNext();) {
            Colonnes maj = iterator.next();
            boolean trouve = false;
            if (!listecolonnes.isEmpty()) {
                for (Iterator<Colonnes> iteratororigine = listecolonnes.iterator(); iteratororigine.hasNext();) {
                    Colonnes origine = iteratororigine.next();
                    if (origine.getIdDonnee().getId().equals(maj.getIdDonnee().getId()) && origine.getIdunique().equals(maj.getIdunique())) {
                        trouve = true;
                    }
                    if (!trouve) {
                        em.persist(maj);
                    }
                }
            } else {
                em.persist(maj);
            }
        }
        em.flush();
        em.getTransaction()
                .commit();
    }

    public List<RessourceConforme> getRessourcesConforme() {
        return em.createNamedQuery("RessourceConforme.findAll").getResultList();
    }

    public List<Donnee> getDonnees() {
        return em.createNamedQuery("Donnee.findAll").getResultList();
    }

    public void supprimer(String id) {
        transac.begin();
        Contacts s = (Contacts) em.createNamedQuery("Donnee.findById").setParameter("id", Integer.decode(id)).getResultList().get(0);
        em.remove(s);
        transac.commit();
    }

    public Donnee getDonnee(String id) {
        List<Donnee> liste = em.createNamedQuery("Donnee.findById").setParameter("id", Integer.decode(id)).getResultList();
        if (liste.size() != 0) {
            return liste.get(0);
        } else {
            return null;
        }
    }

    public List<Serveur> getServeurs() {
        return em.createNamedQuery("Serveur.findAll").getResultList();
    }

    public List<CategorieISO> getCategories() {
        return em.createNamedQuery("CategorieISO.findAll").getResultList();
    }

    public List<ThemeInspire> getThemesInspire() {
        return em.createNamedQuery("ThemeInspire.findAll").getResultList();
    }

    public List<Regions> getRegions() {
        return em.createNamedQuery("Regions.findAll").getResultList();
    }

    public List<Departements> getDepartements() {
        return em.createNamedQuery("Departements.findAll").getResultList();
    }

    public List<Contacts> getContacts() {
        return em.createNamedQuery("Contacts.findAll").getResultList();
    }

    public List<Communes> getCommunes(String debcommmune) {
        return em.createNamedQuery("Communes.findByNomBeginWith").setParameter("nom", debcommmune + "%").getResultList();
    }

    public List<RestrictionInspire> getRestrictionInspire() {
        return em.createNamedQuery("RestrictionInspire.findAll").getResultList();
    }

    public List<ContrainteLegale> getContrainteLegale() {
        return em.createNamedQuery("ContrainteLegale.findAll").getResultList();
    }

    public List<ContraintesSecurite> getContraintesSecurite() {
        return em.createNamedQuery("ContraintesSecurite.findAll").getResultList();
    }

    public List<ConditionUtilisation> getConditionsUtilisation() {
        return em.createNamedQuery("ConditionUtilisation.findAll").getResultList();
    }

    public List<TypeRessource> getTypesRessource() {
        return em.createNamedQuery("TypeRessource.findAll").getResultList();
    }

    public List<Encodage> getEncodages() {
        return em.createNamedQuery("Encodage.findAll").getResultList();
    }

    public List<Langues> getLangues() {
        return em.createNamedQuery("Langues.findAll").getResultList();
    }

    public List<RepresentationSpatiale> getRepresentationsSpaciale() {
        return em.createNamedQuery("RepresentationSpatiale.findAll").getResultList();
    }

    public List<Projection> getProjections() {
        return em.createNamedQuery("Projection.findAll").getResultList();
    }

    public List<CoherenceTopologique> getCoherencesTopologique() {
        return em.createNamedQuery("CoherenceTopologique.findAll").getResultList();
    }

}
