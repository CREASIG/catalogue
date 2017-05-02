/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.creasig.gestion;

import org.creasig.inspire.Serveur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.creasig.inspire.CategorieISO;
import org.creasig.inspire.CoherenceTopologique;
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
@ManagedBean
@SessionScoped
public class DonneeFace implements Serializable {

    private static final long serialVersionUID = 1L;

    private String action;
    private String descriptionaction;

    private String id;
    private String intitule;
    private Integer idtable;
    private String nomtable;
    private String resume;
    private String idunique;
    private String cattheme1;
    private String cattheme2;
    private String cattheme3;
    private float latn;
    private float lats;
    private float late;
    private float lato;
    private Date datecreation;
    private Date datepublication;
    private Date datedebutpublication;
    private Date datederniererevision;
    private Date etenduemin;
    private Date etenduemax;
    private String genealogieressource;
    private String motscle;
    private String adresseinternet;
    private String nominternet;
    private String adressevisualisation;
    private String nomvisualisation;
    private String adressetelechargement;
    private String nomtelechargement;
    private String limiteutilisation;
    private String referencetemporelle;
    private String echelle;
    private String resolution;
    private String titrespec;
    private String contraintelegale;
    private String coherencetopologique;
    private String commune;
    private String conditionacces;
    private String region;
    private String autrecontact;
    private String languemetadonnee;
    private String representationspatiale;
    private String contactmetadonnee;
    private String responsableressource;
    private String contraintesecurite;
    private String themeinspire;
    private String restrictionsinspire;
    private String typeressource;
    private String departement;
    private String jeucaractere;
    private String languedescription;
    private String ressourceconforme;
    private String serveur;
    private String refcoordonnee;
    private List<Donnee> valeursfiltres;

    public DonneeFace() {
        valeursfiltres = new ArrayList<>();
    }

    public void modifier() {
        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");

        bundle = context.getApplication().getResourceBundle(context, "msg");
        descriptionaction = bundle.getString("modifierbdd");

        Donnee s = (new GestionDonnees()).getDonnee(this.id);
        s.setIntitule(getIntitule());
        s.setNomtable(this.getNomtable());
        s.setResume(this.resume);
        s.setIdunique(idunique);
        s.setCattheme1(new CategorieISO(Integer.parseInt(this.cattheme1)));
        s.setCattheme2(new CategorieISO(Integer.parseInt(this.cattheme2)));
        s.setCattheme3(new CategorieISO(Integer.parseInt(this.cattheme3)));
        s.setThemeinspire(new ThemeInspire(Integer.parseInt(this.themeinspire)));
        s.setDepartement(new Departements(Integer.parseInt(this.departement)));
        s.setRegion(new Regions(Integer.parseInt(this.region)));
        s.setCommune(new Communes(this.commune));
        s.setLatn(this.getLatn());
        s.setLats(this.getLats());
        s.setLate(this.getLate());
        s.setLato(this.getLato());
        s.setDatecreation(this.getDatecreation());
        s.setDatedebutpublication(this.getDatedebutpublication());
        s.setDatederniererevision(this.getDatederniererevision());
        s.setDatepublication(this.getDatepublication());
        s.setEtenduemin(this.getEtenduemin());
        s.setEtenduemax(this.getEtenduemax());
        s.setGenealogieressource(this.getGenealogieressource());
        s.setContactmetadonnee(new Contacts(Integer.parseInt(this.getContactmetadonnee())));
        s.setResponsableressource(new Contacts(Integer.parseInt(this.getResponsableressource())));
        s.setRestrictionsinspire(new RestrictionInspire(Integer.parseInt(this.getRestrictionsinspire())));
        s.setContraintelegale(new ContrainteLegale(Integer.parseInt(this.getContraintelegale())));
        s.setMotscle(this.getMotscle());
        s.setAdresseinternet(this.getAdresseinternet());
        s.setAdressetelechargement(this.getAdressetelechargement());
        s.setAdressevisualisation(this.getAdressevisualisation());
        s.setNominternet(this.getNominternet());
        s.setNomtelechargement(this.getNomtelechargement());
        s.setNomvisualisation(this.getNomvisualisation());
        s.setLanguemetadonnee(new Langues(this.getLanguemetadonnee()));
        s.setTyperessource(new TypeRessource(Integer.parseInt(this.getTyperessource())));
        s.setLimiteutilisation(this.getLimiteutilisation());
        s.setLanguedescription(new Langues(this.getLanguedescription()));
        s.setJeucaractere(new Encodage(Integer.parseInt(this.getJeucaractere())));
        s.setRepresentationspatiale(new RepresentationSpatiale(Integer.parseInt(this.getRepresentationspatiale())));
        s.setRefcoordonnees(new Projection(Integer.parseInt(this.getRefcoordonnee())));
        s.setReferencetemporelle(this.getReferencetemporelle());
        s.setCoherencetopologique(new CoherenceTopologique(Integer.parseInt(this.getCoherencetopologique())));
        s.setEchelle(this.getEchelle());
        s.setResolution(this.getResolution());
        s.setAutrecontact(new org.creasig.inspire.Contacts(Integer.parseInt(this.autrecontact)));
        s.setTitrespec(this.titrespec);
        s.setDatedebutpublication(this.getDatedebutpublication());
        s.setRessourceconforme(new RessourceConforme(Integer.parseInt(this.getRessourceconforme())));

        (new GestionDonnees()).modifier(s);
    }

    public List<Donnee> getDonnees() {
        List<Donnee> liste = (new GestionDonnees()).getDonnees();
        return liste;
    }

    public List<String> getRessourcesconforme() {
        List<String> liste = new ArrayList<String>();
        List<RessourceConforme> listeressources = (new GestionDonnees()).getRessourcesConforme();
        for (RessourceConforme ressource : listeressources) {
            liste.add(ressource.getNom());
        }
        return liste;
    }

    public List<String> getNomserveurs() {
        List<String> liste = new ArrayList<>();
        List<Serveur> listeserveurs = (new GestionDonnees()).getServeurs();
        for (Serveur serveur : listeserveurs) {
            liste.add(serveur.getNom());
        }
        return liste;
    }

    public void viderformulaire() {
        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
        action = bundle.getString("ajouter");

        bundle = context.getApplication().getResourceBundle(context, "msg");
        descriptionaction = bundle.getString("ajouterbdd");

        id = "0";
        intitule = "";
        idtable = 0;
        nomtable = "";
        resume = "";
        idunique = "";
        cattheme1 = "1";
        cattheme2 = "1";
        cattheme3 = "1";
        themeinspire = "1";
        departement = "1";
        region = "1";
        commune = "1";
        latn = 0;
        lats = 0;
        late = 0;
        lato = 0;
        datecreation = null;
        datepublication = null;
        datedebutpublication = null;
        datederniererevision = null;
        etenduemin = null;
        etenduemax = null;
        genealogieressource = "";
        motscle = "";
        adresseinternet = "";
        nominternet = "";
        adressevisualisation = "";
        nomvisualisation = "";
        adressetelechargement = "";
        nomtelechargement = "";
        limiteutilisation = "";
        referencetemporelle = "";
        echelle = "";
        resolution = "";
        titrespec = "";
        contraintelegale = "";
        coherencetopologique = "";
        conditionacces = "";
        autrecontact = "";
        languemetadonnee = "";
        representationspatiale = "";
        contactmetadonnee = "";
        responsableressource = "";
        contraintesecurite = "";
        restrictionsinspire = "";
        typeressource = "";
        jeucaractere = "";
        languedescription = "";
        ressourceconforme = "";
        serveur = "";
        refcoordonnee = "";
    }

    public String supprimer() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String id = params.get("id");
        (new GestionDonnees()).supprimer(id);
        return "";
    }

    public void chargerserveur() {
        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
        action = bundle.getString("modifier");

        bundle = context.getApplication().getResourceBundle(context, "msg");
        descriptionaction = bundle.getString("modifierbdd");

        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String id = params.get("id");
        System.err.println("identifiant = "+id);
        Donnee s = (new GestionDonnees()).getDonnee(id);
        this.id = s.getId().toString();
        this.intitule = s.getIntitule();
        this.idtable = s.getIdtable();
        this.nomtable = s.getNomtable();
        this.resume = s.getResume();
        this.idunique = s.getIdunique();
        if (s.getCattheme1() != null) {
            this.cattheme1 = s.getCattheme1().getId().toString();
        }
        if (s.getCattheme2() != null) {
            this.cattheme2 = s.getCattheme2().getId().toString();
        }
        if (s.getCattheme3() != null) {
            this.cattheme3 = s.getCattheme3().getId().toString();
        }
        if (s.getDepartement() != null) {
            this.departement = s.getDepartement().getId().toString();
        }
        if (s.getRegion() != null) {
            this.region = s.getRegion().getId().toString();
        }
        if (s.getCommune() != null) {
            this.commune = s.getCommune().getNom();
        }

        this.latn = s.getLatn();
        this.lats = s.getLats();
        this.late = s.getLate();
        this.lato = s.getLato();
        if (s.getDatecreation() == null) {
            this.datecreation = new Date();
        } else {
            this.datecreation = s.getDatecreation();
        }
        if (s.getDatepublication() == null) {
            this.datepublication = new Date();
        } else {
            this.datepublication = s.getDatepublication();
        }
        if (s.getDatedebutpublication() == null) {
            this.datedebutpublication = new Date();
        } else {
            this.datedebutpublication = s.getDatedebutpublication();
        }
        if (s.getDatederniererevision() == null) {
            this.datederniererevision = new Date();
        } else {
            this.datederniererevision = s.getDatederniererevision();
        }
        this.etenduemin = s.getEtenduemin();
        this.etenduemax = s.getEtenduemax();
        this.genealogieressource = s.getGenealogieressource();
        this.motscle = s.getMotscle();
        this.adresseinternet = s.getAdresseinternet();
        this.nominternet = s.getNominternet();
        this.adressevisualisation = s.getAdressevisualisation();
        this.nomvisualisation = s.getNomvisualisation();
        this.adressetelechargement = s.getAdressetelechargement();
        this.nomtelechargement = s.getNomtelechargement();
        this.limiteutilisation = s.getLimiteutilisation();
        this.referencetemporelle = s.getReferencetemporelle();
        this.echelle = s.getEchelle();
        this.resolution = s.getResolution();
        this.titrespec = s.getTitrespec();
        if (s.getContraintelegale() != null) {
            this.contraintelegale = s.getContraintelegale().getId().toString();
        }
        if (s.getCoherencetopologique() != null) {
            this.coherencetopologique = s.getCoherencetopologique().getId().toString();
        }
        if (s.getConditionacces() != null) {
            this.conditionacces = s.getConditionacces().getId().toString();
        }
        if (s.getAutrecontact() != null) {
            this.autrecontact = s.getAutrecontact().getId().toString();
        }
        if (s.getLanguemetadonnee() != null) {
            this.languemetadonnee = s.getLanguemetadonnee().getId();
        }
        if (s.getRepresentationspatiale() != null) {
            this.representationspatiale = s.getRepresentationspatiale().getId().toString();
        }
        if (s.getContactmetadonnee() != null) {
            this.contactmetadonnee = s.getContactmetadonnee().getId().toString();
        }
        if (s.getResponsableressource() != null) {
            this.responsableressource = s.getResponsableressource().getId().toString();
        }
        if (s.getContraintesecurite() != null) {
            this.contraintesecurite = s.getContraintesecurite().getId().toString();
        }
        if (s.getThemeinspire() != null) {
            this.themeinspire = s.getThemeinspire().getId().toString();
        }
        if (s.getRestrictionsinspire() != null) {
            this.restrictionsinspire = s.getRestrictionsinspire().getId().toString();
        }
        if (s.getTyperessource() != null) {
            this.typeressource = s.getTyperessource().getId().toString();
        }
        if (s.getJeucaractere() != null) {
            this.jeucaractere = s.getJeucaractere().getId().toString();
        }
        if (s.getLanguedescription() != null) {
            this.languedescription = s.getLanguedescription().getId();
        }
        if (s.getRessourceconforme() != null) {
            this.ressourceconforme = s.getRessourceconforme().getId().toString();
        }

        if (s.getServeur() != null) {
            this.serveur = s.getServeur().getId().toString();
        }
        if (s.getRefcoordonnees() != null) {
            this.refcoordonnee = s.getRefcoordonnees().getId().toString();
        }

    }

    public List<Serveur> getServeurs() {
        return (new GestionDonnees()).getServeurs();
    }

    public List<CategorieISO> getCategories() {
        return (new GestionDonnees()).getCategories();
    }

    public List<ThemeInspire> getThemesInspire() {
        return (new GestionDonnees()).getThemesInspire();
    }

    public List<Regions> getRegions() {
        return (new GestionDonnees()).getRegions();
    }

    public List<Departements> getDepartements() {
        return (new GestionDonnees()).getDepartements();
    }

    public List<Contacts> getContacts() {
        return (new GestionDonnees()).getContacts();
    }

    public List<RestrictionInspire> getRestrictionInspire() {
        return (new GestionDonnees()).getRestrictionInspire();
    }

    public List<ContrainteLegale> getContrainteLegale() {
        return (new GestionDonnees()).getContrainteLegale();
    }

    public List<ContraintesSecurite> getContrainteSecurite() {
        return (new GestionDonnees()).getContraintesSecurite();
    }

    public List<ConditionUtilisation> getConditionsUtilisation() {
        return (new GestionDonnees()).getConditionsUtilisation();
    }

    public List<TypeRessource> getTypesRessource() {
        return (new GestionDonnees()).getTypesRessource();
    }

    public List<Encodage> getEncodages() {
        return (new GestionDonnees()).getEncodages();
    }

    public List<Langues> getLangues() {
        return (new GestionDonnees()).getLangues();
    }

    public List<RepresentationSpatiale> getRepresentationsSpaciale() {
        return (new GestionDonnees()).getRepresentationsSpaciale();
    }

    public List<Projection> getProjections() {
        return (new GestionDonnees()).getProjections();
    }

    public List<CoherenceTopologique> getCoherencesTopologique() {
        return (new GestionDonnees()).getCoherencesTopologique();
    }

    public List<RessourceConforme> getRessourcesConforme() {
        return (new GestionDonnees()).getRessourcesConforme();
    }

    public List<Communes> getCommunes(String debcommmune) {
        /*        List<Communes> c = (new GestionDonnees()).getCommunes(debcommmune);
        List<String> liste = new ArrayList<>();
        for (Iterator<Communes> iterator = c.iterator(); iterator.hasNext();) {
            Communes next = iterator.next();
            liste.add(next.getNom());
        }

        return liste;
         */
        return (new GestionDonnees()).getCommunes(debcommmune);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDescriptionaction() {
        return descriptionaction;
    }

    public void setDescriptionaction(String descriptionaction) {
        this.descriptionaction = descriptionaction;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getNomtable() {
        return nomtable;
    }

    public void setNomtable(String nomtable) {
        this.nomtable = nomtable;
    }

    public String getServeur() {
        return serveur;
    }

    public void setServeur(String serveur) {
        this.serveur = serveur;
    }

    public String getRessourceconforme() {
        return ressourceconforme;
    }

    public void setRessourceconforme(String ressourceconforme) {
        this.ressourceconforme = ressourceconforme;
    }

    public Integer getIdtable() {
        return idtable;
    }

    public void setIdtable(Integer idtable) {
        this.idtable = idtable;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getIdunique() {
        return idunique;
    }

    public void setIdunique(String idunique) {
        this.idunique = idunique;
    }

    public String getCattheme1() {
        return cattheme1;
    }

    public void setCattheme1(String cattheme1) {
        this.cattheme1 = cattheme1;
    }

    public String getCattheme2() {
        return cattheme2;
    }

    public void setCattheme2(String cattheme2) {
        this.cattheme2 = cattheme2;
    }

    public String getCattheme3() {
        return cattheme3;
    }

    public void setCattheme3(String cattheme3) {
        this.cattheme3 = cattheme3;
    }

    public float getLatn() {
        return latn;
    }

    public void setLatn(float latn) {
        this.latn = latn;
    }

    public float getLats() {
        return lats;
    }

    public void setLats(float lats) {
        this.lats = lats;
    }

    public float getLate() {
        return late;
    }

    public void setLate(float late) {
        this.late = late;
    }

    public float getLato() {
        return lato;
    }

    public void setLato(float lato) {
        this.lato = lato;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public Date getDatepublication() {
        return datepublication;
    }

    public void setDatepublication(Date datepublication) {
        this.datepublication = datepublication;
    }

    public Date getDatederniererevision() {
        return datederniererevision;
    }

    public void setDatederniererevision(Date datederniererevision) {
        this.datederniererevision = datederniererevision;
    }

    public Date getEtenduemin() {
        return etenduemin;
    }

    public void setEtenduemin(Date etenduemin) {
        this.etenduemin = etenduemin;
    }

    public Date getEtenduemax() {
        return etenduemax;
    }

    public void setEtenduemax(Date etenduemax) {
        this.etenduemax = etenduemax;
    }

    public String getGenealogieressource() {
        return genealogieressource;
    }

    public void setGenealogieressource(String genealogieressource) {
        this.genealogieressource = genealogieressource;
    }

    public String getMotscle() {
        return motscle;
    }

    public void setMotscle(String motscle) {
        this.motscle = motscle;
    }

    public String getAdresseinternet() {
        return adresseinternet;
    }

    public void setAdresseinternet(String adresseinternet) {
        this.adresseinternet = adresseinternet;
    }

    public String getNominternet() {
        return nominternet;
    }

    public void setNominternet(String nominternet) {
        this.nominternet = nominternet;
    }

    public String getAdressevisualisation() {
        return adressevisualisation;
    }

    public void setAdressevisualisation(String adressevisualisation) {
        this.adressevisualisation = adressevisualisation;
    }

    public String getNomvisualisation() {
        return nomvisualisation;
    }

    public void setNomvisualisation(String nomvisualisation) {
        this.nomvisualisation = nomvisualisation;
    }

    public String getAdressetelechargement() {
        return adressetelechargement;
    }

    public void setAdressetelechargement(String adressetelechargement) {
        this.adressetelechargement = adressetelechargement;
    }

    public String getNomtelechargement() {
        return nomtelechargement;
    }

    public void setNomtelechargement(String nomtelechargement) {
        this.nomtelechargement = nomtelechargement;
    }

    public String getLimiteutilisation() {
        return limiteutilisation;
    }

    public void setLimiteutilisation(String limiteutilisation) {
        this.limiteutilisation = limiteutilisation;
    }

    public String getReferencetemporelle() {
        return referencetemporelle;
    }

    public void setReferencetemporelle(String referencetemporelle) {
        this.referencetemporelle = referencetemporelle;
    }

    public String getEchelle() {
        return echelle;
    }

    public void setEchelle(String echelle) {
        this.echelle = echelle;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getTitrespec() {
        return titrespec;
    }

    public void setTitrespec(String titrespec) {
        this.titrespec = titrespec;
    }

    public String getContraintelegale() {
        return contraintelegale;
    }

    public void setContraintelegale(String contraintelegale) {
        this.contraintelegale = contraintelegale;
    }

    public String getCoherencetopologique() {
        return coherencetopologique;
    }

    public void setCoherencetopologique(String coherencetopologique) {
        this.coherencetopologique = coherencetopologique;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getConditionacces() {
        return conditionacces;
    }

    public void setConditionacces(String conditionacces) {
        this.conditionacces = conditionacces;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAutrecontact() {
        return autrecontact;
    }

    public void setAutrecontact(String autrecontact) {
        this.autrecontact = autrecontact;
    }

    public String getLanguemetadonnee() {
        return languemetadonnee;
    }

    public void setLanguemetadonnee(String languemetadonnee) {
        this.languemetadonnee = languemetadonnee;
    }

    public String getRepresentationspatiale() {
        return representationspatiale;
    }

    public void setRepresentationspatiale(String representationspatiale) {
        this.representationspatiale = representationspatiale;
    }

    public String getContactmetadonnee() {
        return contactmetadonnee;
    }

    public void setContactmetadonnee(String contactmetadonnee) {
        this.contactmetadonnee = contactmetadonnee;
    }

    public String getResponsableressource() {
        return responsableressource;
    }

    public void setResponsableressource(String responsableressource) {
        this.responsableressource = responsableressource;
    }

    public String getContraintesecurite() {
        return contraintesecurite;
    }

    public void setContraintesecurite(String contraintesecurite) {
        this.contraintesecurite = contraintesecurite;
    }

    public String getThemeinspire() {
        return themeinspire;
    }

    public void setThemeinspire(String themeinspire) {
        this.themeinspire = themeinspire;
    }

    public String getRestrictionsinspire() {
        return restrictionsinspire;
    }

    public void setRestrictionsinspire(String restrictionsinspire) {
        this.restrictionsinspire = restrictionsinspire;
    }

    public String getTyperessource() {
        return typeressource;
    }

    public void setTyperessource(String typeressource) {
        this.typeressource = typeressource;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getJeucaractere() {
        return jeucaractere;
    }

    public void setJeucaractere(String jeucaractere) {
        this.jeucaractere = jeucaractere;
    }

    public String getLanguedescription() {
        return languedescription;
    }

    public void setLanguedescription(String languedescription) {
        this.languedescription = languedescription;
    }

    public String getRefcoordonnee() {
        return refcoordonnee;
    }

    public void setRefcoordonnee(String refcoordonnee) {
        this.refcoordonnee = refcoordonnee;
    }

    public Date getDatedebutpublication() {
        return datedebutpublication;
    }

    public void setDatedebutpublication(Date datedebutpublication) {
        this.datedebutpublication = datedebutpublication;
    }

    public List<Donnee> getValeursfiltres() {
        return valeursfiltres;
    }

    public void setValeursfiltres(List<Donnee> valeursfiltres) {
        this.valeursfiltres = valeursfiltres;
        System.err.println(this.valeursfiltres);
    }

}
