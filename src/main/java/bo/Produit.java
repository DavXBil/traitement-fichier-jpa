package bo;


import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Produit {

    // categorie
    // marque
    // nom
    // nutritionGradeFr
    // ingredients
    // energie100g
    // graisse100g
    // sucres100g
    // fibres100g
    // proteines100g
    // sel100g
    // vitA100g|vitD100g|vitE100g|vitK100g|vitC100g|vitB1100g|vitB2100g|vitPP100g|vitB6100g|vitB9100g|vitB12100g|calcium100g|magnesium100g|iron100g|fer100g|betaCarotene100g|presenceHuilePalme
    // allergenes
    // additifs

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="nom")
    private String nom;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;
    @ManyToOne
    @JoinColumn(name = "marque_id")
    private Marque marque;


    @ManyToMany
    @JoinTable(name = "Produit_ingredients",
            joinColumns = @JoinColumn(name = "produit_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredients_id"))
    private Set<Ingredient> ingredients = new LinkedHashSet<>();
    @Column(name= "grade_nutritionnel")
    private String gradeNutritionnel;

    @Column(name= "energie")
    private String energie;

    @Column(name= "graisses")
    private String graisses;

    @Column(name= "sucres")
    private String sucres;

    @Column(name= "fibres")
    private String fibres;

    @Column(name= "proteines")
    private String proteines;

    @Column(name= "sel")
    private String sel;


    @Column(name= "vitA100g")
    private String vitA100g;

    @Column(name= "vitD100g")
    private String vitD100g;

    @Column(name= "vitE100g")
    private String vitE100g;

    @Column(name= "vitK100g")
    private String vitK100g;

    @Column(name= "vitC100g")
    private String vitC100g;

    @Column(name= "vitB1100g")
    private String vitB1100g;

    @Column(name= "vitB2100g")
    private String vitB2100g;

    @Column(name= "vitPP100g")
    private String vitPP100g;

    @Column(name= "vitB6100g")
    private String vitB6100g;

    @Column(name= "vitB9100g")
    private String vitB9100g;

    @Column(name= "vitB12100g")
    private String vitB12100g;

    @Column(name= "calcium100g")
    private String calcium100g;

    @Column(name= "magnesium100g")
    private String magnesium100g;

    @Column(name= "iron100g")
    private String iron100g;

    @Column(name= "fer100g")
    private String fer100g;

    @Column(name= "betaCarotene100g")
    private String betaCarotene100g;

    @Column(name= "presenceHuilePalme")
    private String presenceHuilePalme;

    @ManyToMany
    @JoinTable(name = "Produit_allergenes",
            joinColumns = @JoinColumn(name = "produit_id"),
            inverseJoinColumns = @JoinColumn(name = "allergenes_id"))
    private Set<Allergene> allergenes = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "Produit_additifs",
            joinColumns = @JoinColumn(name = "produit_id"),
            inverseJoinColumns = @JoinColumn(name = "additifs_id"))
    private Set<Additif> additifs = new LinkedHashSet<>();


    public Produit() {
    }

    public Produit(String gradeNutritionnel, Marque marque, Set<Ingredient> ingredients, Set<Allergene> allergenes, Set<Additif> additifs, Categorie categorie) {
        this.gradeNutritionnel = gradeNutritionnel;
        this.marque = marque;
        this.ingredients = ingredients;
        this.allergenes = allergenes;
        this.additifs = additifs;
        this.categorie = categorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getGradeNutritionnel() {
        return gradeNutritionnel;
    }

    public void setGradeNutritionnel(String gradeNutritionnel) {
        this.gradeNutritionnel = gradeNutritionnel;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String getEnergie() {
        return energie;
    }

    public void setEnergie(String energie) {
        this.energie = energie;
    }

    public String getGraisses() {
        return graisses;
    }

    public void setGraisses(String graisses) {
        this.graisses = graisses;
    }

    public String getSucres() {
        return sucres;
    }

    public void setSucres(String sucres) {
        this.sucres = sucres;
    }

    public String getFibres() {
        return fibres;
    }

    public void setFibres(String fibres) {
        this.fibres = fibres;
    }

    public String getProteines() {
        return proteines;
    }

    public void setProteines(String proteines) {
        this.proteines = proteines;
    }

    public String getSel() {
        return sel;
    }

    public void setSel(String sel) {
        this.sel = sel;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public Set<Additif> getAdditifs() {
        return additifs;
    }

    public void setAdditifs(Set<Additif> additifs) {
        this.additifs = additifs;
    }

    public Set<Allergene> getAllergenes() {
        return allergenes;
    }

    public void setAllergenes(Set<Allergene> allergenes) {
        this.allergenes = allergenes;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVitA100g() {
        return vitA100g;
    }

    public void setVitA100g(String vitA100g) {
        this.vitA100g = vitA100g;
    }

    public String getVitD100g() {
        return vitD100g;
    }

    public void setVitD100g(String vitD100g) {
        this.vitD100g = vitD100g;
    }

    public String getVitE100g() {
        return vitE100g;
    }

    public void setVitE100g(String vitE100g) {
        this.vitE100g = vitE100g;
    }

    public String getVitK100g() {
        return vitK100g;
    }

    public void setVitK100g(String vitK100g) {
        this.vitK100g = vitK100g;
    }

    public String getVitC100g() {
        return vitC100g;
    }

    public void setVitC100g(String vitC100g) {
        this.vitC100g = vitC100g;
    }

    public String getVitB1100g() {
        return vitB1100g;
    }

    public void setVitB1100g(String vitB1100g) {
        this.vitB1100g = vitB1100g;
    }

    public String getVitB2100g() {
        return vitB2100g;
    }

    public void setVitB2100g(String vitB2100g) {
        this.vitB2100g = vitB2100g;
    }

    public String getVitPP100g() {
        return vitPP100g;
    }

    public void setVitPP100g(String vitPP100g) {
        this.vitPP100g = vitPP100g;
    }

    public String getVitB6100g() {
        return vitB6100g;
    }

    public void setVitB6100g(String vitB6100g) {
        this.vitB6100g = vitB6100g;
    }

    public String getVitB9100g() {
        return vitB9100g;
    }

    public void setVitB9100g(String vitB9100g) {
        this.vitB9100g = vitB9100g;
    }

    public String getVitB12100g() {
        return vitB12100g;
    }

    public void setVitB12100g(String vitB12100g) {
        this.vitB12100g = vitB12100g;
    }

    public String getCalcium100g() {
        return calcium100g;
    }

    public void setCalcium100g(String calcium100g) {
        this.calcium100g = calcium100g;
    }

    public String getMagnesium100g() {
        return magnesium100g;
    }

    public void setMagnesium100g(String magnesium100g) {
        this.magnesium100g = magnesium100g;
    }

    public String getIron100g() {
        return iron100g;
    }

    public void setIron100g(String iron100g) {
        this.iron100g = iron100g;
    }

    public String getFer100g() {
        return fer100g;
    }

    public void setFer100g(String fer100g) {
        this.fer100g = fer100g;
    }

    public String getBetaCarotene100g() {
        return betaCarotene100g;
    }

    public void setBetaCarotene100g(String betaCarotene100g) {
        this.betaCarotene100g = betaCarotene100g;
    }

    public String getPresenceHuilePalme() {
        return presenceHuilePalme;
    }

    public void setPresenceHuilePalme(String presenceHuilePalme) {
        this.presenceHuilePalme = presenceHuilePalme;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Produit{");
        sb.append("nom='").append(nom).append('\'');
        sb.append(", categorie=").append(categorie);
        sb.append(", marque=").append(marque);
        sb.append(", ingredients=").append(ingredients);
        sb.append(", gradeNutritionnel='").append(gradeNutritionnel).append('\'');
        sb.append(", energie='").append(energie).append('\'');
        sb.append(", graisses='").append(graisses).append('\'');
        sb.append(", sucres='").append(sucres).append('\'');
        sb.append(", fibres='").append(fibres).append('\'');
        sb.append(", proteines='").append(proteines).append('\'');
        sb.append(", sel='").append(sel).append('\'');
        sb.append(", vitA100g='").append(vitA100g).append('\'');
        sb.append(", vitD100g='").append(vitD100g).append('\'');
        sb.append(", vitE100g='").append(vitE100g).append('\'');
        sb.append(", vitK100g='").append(vitK100g).append('\'');
        sb.append(", vitC100g='").append(vitC100g).append('\'');
        sb.append(", vitB1100g='").append(vitB1100g).append('\'');
        sb.append(", vitB2100g='").append(vitB2100g).append('\'');
        sb.append(", vitPP100g='").append(vitPP100g).append('\'');
        sb.append(", vitB6100g='").append(vitB6100g).append('\'');
        sb.append(", vitB9100g='").append(vitB9100g).append('\'');
        sb.append(", vitB12100g='").append(vitB12100g).append('\'');
        sb.append(", calcium100g='").append(calcium100g).append('\'');
        sb.append(", magnesium100g='").append(magnesium100g).append('\'');
        sb.append(", iron100g='").append(iron100g).append('\'');
        sb.append(", fer100g='").append(fer100g).append('\'');
        sb.append(", betaCarotene100g='").append(betaCarotene100g).append('\'');
        sb.append(", presenceHuilePalme='").append(presenceHuilePalme).append('\'');
        sb.append(", allergenes=").append(allergenes);
        sb.append(", additifs=").append(additifs);
        sb.append('}');
        return sb.toString();
    }
}
