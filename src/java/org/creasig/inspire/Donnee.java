/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.creasig.inspire;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author eric
 */
@Entity
@Table(name = "donnee", catalog = "catalogue", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Donnee.findAll", query = "SELECT d FROM Donnee d order by d.intitule")
    , @NamedQuery(name = "Donnee.findById", query = "SELECT d FROM Donnee d WHERE d.id = :id")
    , @NamedQuery(name = "Donnee.findByIdserveurAndidTable", query = "SELECT d FROM Donnee d WHERE d.serveur.id = :id and  d.idtable = :idtable")
    , @NamedQuery(name = "Donnee.findByIntitule", query = "SELECT d FROM Donnee d WHERE d.intitule = :intitule")
    , @NamedQuery(name = "Donnee.findByIdtable", query = "SELECT d FROM Donnee d WHERE d.idtable = :idtable")
    , @NamedQuery(name = "Donnee.findByNomtable", query = "SELECT d FROM Donnee d WHERE d.nomtable = :nomtable")
    , @NamedQuery(name = "Donnee.findByResume", query = "SELECT d FROM Donnee d WHERE d.resume = :resume")
    , @NamedQuery(name = "Donnee.findByIdunique", query = "SELECT d FROM Donnee d WHERE d.idunique = :idunique")
    , @NamedQuery(name = "Donnee.findByCattheme1", query = "SELECT d FROM Donnee d WHERE d.cattheme1 = :cattheme1")
    , @NamedQuery(name = "Donnee.findByCattheme2", query = "SELECT d FROM Donnee d WHERE d.cattheme2 = :cattheme2")
    , @NamedQuery(name = "Donnee.findByCattheme3", query = "SELECT d FROM Donnee d WHERE d.cattheme3 = :cattheme3")
    , @NamedQuery(name = "Donnee.findByLatn", query = "SELECT d FROM Donnee d WHERE d.latn = :latn")
    , @NamedQuery(name = "Donnee.findByLats", query = "SELECT d FROM Donnee d WHERE d.lats = :lats")
    , @NamedQuery(name = "Donnee.findByLate", query = "SELECT d FROM Donnee d WHERE d.late = :late")
    , @NamedQuery(name = "Donnee.findByLato", query = "SELECT d FROM Donnee d WHERE d.lato = :lato")
    , @NamedQuery(name = "Donnee.findByDatecreation", query = "SELECT d FROM Donnee d WHERE d.datecreation = :datecreation")
    , @NamedQuery(name = "Donnee.findByDatepublication", query = "SELECT d FROM Donnee d WHERE d.datepublication = :datepublication")
    , @NamedQuery(name = "Donnee.findByDatederniererevision", query = "SELECT d FROM Donnee d WHERE d.datederniererevision = :datederniererevision")
    , @NamedQuery(name = "Donnee.findByEtenduemin", query = "SELECT d FROM Donnee d WHERE d.etenduemin = :etenduemin")
    , @NamedQuery(name = "Donnee.findByEtenduemax", query = "SELECT d FROM Donnee d WHERE d.etenduemax = :etenduemax")
    , @NamedQuery(name = "Donnee.findByGenealogieressource", query = "SELECT d FROM Donnee d WHERE d.genealogieressource = :genealogieressource")
    , @NamedQuery(name = "Donnee.findByMotscle", query = "SELECT d FROM Donnee d WHERE d.motscle = :motscle")
    , @NamedQuery(name = "Donnee.findByAdresseinternet", query = "SELECT d FROM Donnee d WHERE d.adresseinternet = :adresseinternet")
    , @NamedQuery(name = "Donnee.findByNominternet", query = "SELECT d FROM Donnee d WHERE d.nominternet = :nominternet")
    , @NamedQuery(name = "Donnee.findByAdressevisualisation", query = "SELECT d FROM Donnee d WHERE d.adressevisualisation = :adressevisualisation")
    , @NamedQuery(name = "Donnee.findByNomvisualisation", query = "SELECT d FROM Donnee d WHERE d.nomvisualisation = :nomvisualisation")
    , @NamedQuery(name = "Donnee.findByAdressetelechargement", query = "SELECT d FROM Donnee d WHERE d.adressetelechargement = :adressetelechargement")
    , @NamedQuery(name = "Donnee.findByNomtelechargement", query = "SELECT d FROM Donnee d WHERE d.nomtelechargement = :nomtelechargement")
    , @NamedQuery(name = "Donnee.findByLimiteutilisation", query = "SELECT d FROM Donnee d WHERE d.limiteutilisation = :limiteutilisation")
    , @NamedQuery(name = "Donnee.findByReferencetemporelle", query = "SELECT d FROM Donnee d WHERE d.referencetemporelle = :referencetemporelle")
    , @NamedQuery(name = "Donnee.findByEchelle", query = "SELECT d FROM Donnee d WHERE d.echelle = :echelle")
    , @NamedQuery(name = "Donnee.findByResolution", query = "SELECT d FROM Donnee d WHERE d.resolution = :resolution")
    , @NamedQuery(name = "Donnee.findByTitrespec", query = "SELECT d FROM Donnee d WHERE d.titrespec = :titrespec")})
public class Donnee implements Serializable {

    @Column(name = "idtable")
    private Integer idtable;
    @Column(name = "latn")
    private float latn;
    @Column(name = "lats")
    private float lats;
    @Column(name = "late")
    private float late;
    @Column(name = "lato")
    private float lato;

    @OneToMany(mappedBy = "iddonnee",cascade = {CascadeType.ALL},fetch = FetchType.EAGER,targetEntity = Colonnes.class)
    private Collection<Colonnes> colonnes;

    private static final long serialVersionUID = 2L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "intitule", length = 2147483647)
    private String intitule;
    @Size(max = 2147483647)
    @Column(name = "nomtable", length = 2147483647)
    private String nomtable;
    @Size(max = 2147483647)
    @Column(name = "resume", length = 2147483647)
    private String resume;
    @Size(max = 2147483647)
    @Column(name = "idunique", length = 2147483647)
    private String idunique;
    @JoinColumn(name = "cattheme1", referencedColumnName = "id",nullable = true)
    @ManyToOne(targetEntity = CategorieISO.class)
    private CategorieISO cattheme1;
    @JoinColumn(name = "cattheme2", referencedColumnName = "id",nullable = true)
    @ManyToOne(targetEntity = CategorieISO.class)
    private CategorieISO cattheme2;
    @JoinColumn(name = "cattheme3", referencedColumnName = "id",nullable = true)
    @ManyToOne(targetEntity = CategorieISO.class)
    private CategorieISO cattheme3;
    @Column(name = "datecreation")
    @Temporal(TemporalType.DATE)
    private Date datecreation;
    @Column(name = "datepublication")
    @Temporal(TemporalType.DATE)
    private Date datepublication;
    @Column(name = "datederniererevision")
    @Temporal(TemporalType.DATE)
    private Date datederniererevision;
    @Column(name = "etenduemin")
    @Temporal(TemporalType.DATE)
    private Date etenduemin;
    @Column(name = "etenduemax")
    @Temporal(TemporalType.DATE)
    private Date etenduemax;
    @Size(max = 2147483647)
    @Column(name = "genealogieressource", length = 2147483647)
    private String genealogieressource;
    @Size(max = 2147483647)
    @Column(name = "motscle", length = 2147483647)
    private String motscle;
    @Size(max = 2147483647)
    @Column(name = "adresseinternet", length = 2147483647)
    private String adresseinternet;
    @Size(max = 2147483647)
    @Column(name = "nominternet", length = 2147483647)
    private String nominternet;
    @Size(max = 2147483647)
    @Column(name = "adressevisualisation", length = 2147483647)
    private String adressevisualisation;
    @Size(max = 2147483647)
    @Column(name = "nomvisualisation", length = 2147483647)
    private String nomvisualisation;
    @Size(max = 2147483647)
    @Column(name = "adressetelechargement", length = 2147483647)
    private String adressetelechargement;
    @Size(max = 2147483647)
    @Column(name = "nomtelechargement", length = 2147483647)
    private String nomtelechargement;
    @Size(max = 2147483647)
    @Column(name = "limiteutilisation", length = 2147483647)
    private String limiteutilisation;
    @Size(max = 2147483647)
    @Column(name = "referencetemporelle", length = 2147483647)
    private String referencetemporelle;
    @Size(max = 2147483647)
    @Column(name = "echelle", length = 2147483647)
    private String echelle;
    @Size(max = 2147483647)
    @Column(name = "resolution", length = 2147483647)
    private String resolution;
    @Size(max = 2147483647)
    @Column(name = "titrespec", length = 2147483647)
    private String titrespec;
    @JoinColumn(name = "contraintelegale", referencedColumnName = "id")
    @ManyToOne
    private ContrainteLegale contraintelegale;
    @JoinColumn(name = "coherencetopologique", referencedColumnName = "id")
    @ManyToOne
    private CoherenceTopologique coherencetopologique;
    @JoinColumn(name = "commune", referencedColumnName = "id")
    @ManyToOne
    private Communes commune;
    @JoinColumn(name = "conditionacces", referencedColumnName = "id")
    @ManyToOne
    private ConditionUtilisation conditionacces;
    @JoinColumn(name = "region", referencedColumnName = "id")
    @ManyToOne
    private Regions region;
    @JoinColumn(name = "autrecontact", referencedColumnName = "id")
    @ManyToOne
    private Contacts autrecontact;
    @JoinColumn(name = "languemetadonnee", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(targetEntity = Langues.class)
    private Langues languemetadonnee;
    @JoinColumn(name = "representationspatiale", referencedColumnName = "id")
    @ManyToOne
    private RepresentationSpatiale representationspatiale;
    @JoinColumn(name = "contactmetadonnee", referencedColumnName = "id")
    @ManyToOne
    private Contacts contactmetadonnee;
    @JoinColumn(name = "responsableressource", referencedColumnName = "id")
    @ManyToOne
    private Contacts responsableressource;
    @JoinColumn(name = "contraintesecurite", referencedColumnName = "id")
    @ManyToOne
    private ContraintesSecurite contraintesecurite;
    @JoinColumn(name = "themeinspire", referencedColumnName = "id")
    @ManyToOne
    private ThemeInspire themeinspire;
    @JoinColumn(name = "restrictionsinspire", referencedColumnName = "id")
    @ManyToOne
    private RestrictionInspire restrictionsinspire;
    @JoinColumn(name = "typeressource", referencedColumnName = "id")
    @ManyToOne
    private TypeRessource typeressource;
    @JoinColumn(name = "departement", referencedColumnName = "id")
    @ManyToOne
    private Departements departement;
    @JoinColumn(name = "jeucaractere", referencedColumnName = "id")
    @ManyToOne
    private Encodage jeucaractere;
    @JoinColumn( name = "languedescription", referencedColumnName = "id")
    @ManyToOne(targetEntity = Langues.class)
    private Langues languedescription;
    @JoinColumn(name = "ressourceconforme", referencedColumnName = "id")
    @ManyToOne
    private RessourceConforme ressourceconforme;
    @JoinColumn(name = "serveur", referencedColumnName = "id")
    @ManyToOne
    private Serveur serveur;
    @JoinColumn(name = "refcoordonnees", referencedColumnName = "id")
    @ManyToOne
    private Projection refcoordonnees;
    @Column(name = "datedebutpublication")
    @Temporal(TemporalType.DATE)
    private Date datedebutpublication;

    public Donnee() {
    }

    public Donnee(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public CategorieISO getCattheme1() {
        return cattheme1;
    }

    public void setCattheme1(CategorieISO cattheme1) {
        this.cattheme1 = cattheme1;
    }

    public CategorieISO getCattheme2() {
        return cattheme2;
    }

    public void setCattheme2(CategorieISO cattheme2) {
        this.cattheme2 = cattheme2;
    }

    public CategorieISO getCattheme3() {
        return cattheme3;
    }

    public void setCattheme3(CategorieISO cattheme3) {
        this.cattheme3 = cattheme3;
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

    public ContrainteLegale getContraintelegale() {
        return contraintelegale;
    }

    public void setContraintelegale(ContrainteLegale contraintelegale) {
        this.contraintelegale = contraintelegale;
    }

    public CoherenceTopologique getCoherencetopologique() {
        return coherencetopologique;
    }

    public void setCoherencetopologique(CoherenceTopologique coherencetopologique) {
        this.coherencetopologique = coherencetopologique;
    }

    public Communes getCommune() {
        return commune;
    }

    public void setCommune(Communes commune) {
        this.commune = commune;
    }

    public ConditionUtilisation getConditionacces() {
        return conditionacces;
    }

    public void setConditionacces(ConditionUtilisation conditionacces) {
        this.conditionacces = conditionacces;
    }

    public Regions getRegion() {
        return region;
    }

    public void setRegion(Regions region) {
        this.region = region;
    }

    public Contacts getAutrecontact() {
        return autrecontact;
    }

    public void setAutrecontact(Contacts autrecontact) {
        this.autrecontact = autrecontact;
    }

    public Langues getLanguemetadonnee() {
        return languemetadonnee;
    }

    public void setLanguemetadonnee(Langues languemetadonnee) {
        this.languemetadonnee = languemetadonnee;
    }

    public RepresentationSpatiale getRepresentationspatiale() {
        return representationspatiale;
    }

    public void setRepresentationspatiale(RepresentationSpatiale representationspatiale) {
        this.representationspatiale = representationspatiale;
    }

    public Contacts getContactmetadonnee() {
        return contactmetadonnee;
    }

    public void setContactmetadonnee(Contacts contactmetadonnee) {
        this.contactmetadonnee = contactmetadonnee;
    }

    public Contacts getResponsableressource() {
        return responsableressource;
    }

    public void setResponsableressource(Contacts responsableressource) {
        this.responsableressource = responsableressource;
    }

    public ContraintesSecurite getContraintesecurite() {
        return contraintesecurite;
    }

    public void setContraintesecurite(ContraintesSecurite contraintesecurite) {
        this.contraintesecurite = contraintesecurite;
    }

    public ThemeInspire getThemeinspire() {
        return themeinspire;
    }

    public void setThemeinspire(ThemeInspire themeinspire) {
        this.themeinspire = themeinspire;
    }

    public RestrictionInspire getRestrictionsinspire() {
        return restrictionsinspire;
    }

    public void setRestrictionsinspire(RestrictionInspire restrictionsinspire) {
        this.restrictionsinspire = restrictionsinspire;
    }

    public TypeRessource getTyperessource() {
        return typeressource;
    }

    public void setTyperessource(TypeRessource typeressource) {
        this.typeressource = typeressource;
    }

    public Departements getDepartement() {
        return departement;
    }

    public void setDepartement(Departements departement) {
        this.departement = departement;
    }

    public Encodage getJeucaractere() {
        return jeucaractere;
    }

    public void setJeucaractere(Encodage jeucaractere) {
        this.jeucaractere = jeucaractere;
    }

    public Langues getLanguedescription() {
        return languedescription;
    }

    public void setLanguedescription(Langues languedescription) {
        this.languedescription = languedescription;
    }

    public RessourceConforme getRessourceconforme() {
        return ressourceconforme;
    }

    public void setRessourceconforme(RessourceConforme ressourceconforme) {
        this.ressourceconforme = ressourceconforme;
    }

    public Serveur getServeur() {
        return serveur;
    }

    public void setServeur(Serveur serveur) {
        this.serveur = serveur;
    }

    public Projection getRefcoordonnees() {
        return refcoordonnees;
    }

    public void setRefcoordonnees(Projection refcoordonnees) {
        this.refcoordonnees = refcoordonnees;
    }

    public Date getDatedebutpublication() {
        return datedebutpublication;
    }

    public void setDatedebutpublication(Date datedebutpublication) {
        this.datedebutpublication = datedebutpublication;
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
        if (!(object instanceof Donnee)) {
            return false;
        }
        Donnee other = (Donnee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.creasig.inspire.Donnee[ id=" + id + " ]";
    }

    public Integer getIdtable() {
        return idtable;
    }

    public void setIdtable(Integer idtable) {
        this.idtable = idtable;
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


    public Collection<Colonnes> getColonnes() {
        return colonnes;
    }

    public void setColonnes(Collection<Colonnes> colonnes) {
        this.colonnes = colonnes;
    }

}
