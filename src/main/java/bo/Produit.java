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
    @Column(name= "donnees_nutritionnelles")
    private String donneesNutritionnelles;


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

    public Produit(String gradeNutritionnel, String donneesNutritionnelles, Marque marque, Set<Ingredient> ingredients, Set<Allergene> allergenes, Set<Additif> additifs, Categorie categorie) {
        this.gradeNutritionnel = gradeNutritionnel;
        this.donneesNutritionnelles = donneesNutritionnelles;
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

    public String getDonneesNutritionnelles() {
        return donneesNutritionnelles;
    }

    public void setDonneesNutritionnelles(String donneesNutritionnelles) {
        this.donneesNutritionnelles = donneesNutritionnelles;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Produit{");
        sb.append(", nom='").append(nom).append('\'');
        sb.append("categorie=").append(categorie);
        sb.append(", marque=").append(marque);
        sb.append(", ingredients=").append(ingredients);
        sb.append(", gradeNutritionnel='").append(gradeNutritionnel).append('\'');
        sb.append(", donneesNutritionnelles='").append(donneesNutritionnelles).append('\'');
        sb.append(", allergenes=").append(allergenes);
        sb.append(", additifs=").append(additifs);
        sb.append('}');
        return sb.toString();
    }
}
