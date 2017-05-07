/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.creasig.recherche;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import org.creasig.inspire.Colonnes;
import org.creasig.inspire.Donnee;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

/**
 * REST Web Service
 *
 * @author eric
 */
@Path("recherche")
public class RechercheResource {

    @Context
    private UriInfo context;
    EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction transac;

    /**
     * Creates a new instance of RechercheResource
     */
    public RechercheResource() {
        emf = Persistence.createEntityManagerFactory("ServeurPU");
        em = emf.createEntityManager();
        transac = em.getTransaction();
    }

    @GET
    @Path("{id}")
    public String getContact(@PathParam("id") String id) {
        try {
            List<Donnee> listedonnees = em.createNamedQuery("Donnee.findById").setParameter("id", Integer.parseUnsignedInt(id)).getResultList();
            if (listedonnees.isEmpty()) {
                return "{}";
            } else {
                return getJsonOject(listedonnees.get(0)).toString();
            }
        } catch (JSONException e) {

        }
        return "{}";

    }

    /**
     * Retrieves representation of an instance of
     * org.creasig.recherche.RechercheResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        JSONObject resultat = new JSONObject();
        try {
            Collection<JSONObject> liste = new ArrayList<>();
            Collection<Donnee> listedonnees = em.createNamedQuery("Donnee.findAll").getResultList();
            for (Iterator<Donnee> iterator = listedonnees.iterator(); iterator.hasNext();) {
                Donnee donnee = iterator.next();
                liste.add(getJsonOject(donnee));
            }
            resultat.put("liste", liste);
        } catch (JSONException e) {

        }
        return resultat.toString();
    }

    /**
     * PUT method for updating or creating an instance of RechercheResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    private JSONObject getJsonOject(Donnee donnee) throws JSONException {
        JSONObject o = new JSONObject();
        o.put("id", donnee.getId());
        o.put("nomtable", donnee.getNomtable());
        o.put("serveur", donnee.getServeur().getNom());
        o.put("nomtable", donnee.getNomtable());
        o.put("intitule", donnee.getIntitule());
        o.put("idtable", donnee.getIdtable());
        if (Objects.isNull(donnee.getLanguedescription())) {
            o.put("languedescription", donnee.getLanguedescription().getNom());
        } else {
            o.put("languedescription", "");
        }
        if (Objects.isNull(donnee.getLanguedescription())) {
            o.put("languemetadonnee", donnee.getLanguemetadonnee().getNom());
        } else {
            o.put("languemetadonnee", "");
        }

        o.put("cattheme1", donnee.getCattheme1().getNom());
        o.put("cattheme2", donnee.getCattheme2().getNom());
        o.put("cattheme3", donnee.getCattheme3().getNom());
        o.put("themeinspire", donnee.getThemeinspire().getNom());
        o.put("region", donnee.getRegion().getNom());
        o.put("departement", donnee.getDepartement().getNom());
        o.put("commune", donnee.getCommune().getNom());
        o.put("late", donnee.getLate());
        o.put("lato", donnee.getLato());
        o.put("lats", donnee.getLats());
        o.put("latn", donnee.getLatn());

        o.put("datecreation", donnee.getDatecreation());
        o.put("datedebutpublication", donnee.getDatedebutpublication());
        o.put("datederniererevision", donnee.getDatederniererevision());
        o.put("datepublication", donnee.getDatedebutpublication());

        o.put("restrictionsinspire", donnee.getRestrictionsinspire().getNom());
        o.put("contraintelegale", donnee.getContraintelegale().getNom());
        o.put("typeressource", donnee.getTyperessource().getNom());
        o.put("jeucaractere", donnee.getJeucaractere().getNom());
        o.put("representationspatiale", donnee.getRepresentationspatiale().getNom());
        o.put("coherencetopologique", donnee.getCoherencetopologique().getNom());
        o.put("ressourceconforme", donnee.getRessourceconforme().getNom());
        o.put("refcoordonnees", donnee.getRefcoordonnees().getNom());
        o.put("contraintesecurite", donnee.getContraintelegale().getNom());
        Collection<Colonnes> listecolonnes = donnee.getColonnes();
        ArrayList<JSONObject> l = new ArrayList<>();
        for (Colonnes colonne : listecolonnes) {
            JSONObject co = new JSONObject();
            co.put("id", colonne.getId());
            co.put("idunique", colonne.getIdunique());
            co.put("nom", colonne.getNom());
            co.put("type", colonne.getType());
            co.put("description", colonne.getDescription());
            l.add(co);
        }
        o.put("colonnes", l);
        return o;
    }

}
