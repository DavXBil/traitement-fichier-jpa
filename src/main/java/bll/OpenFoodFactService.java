package bll;

import bo.*;
import dal.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OpenFoodFactService {

    CategorieDAO catDao = new CategorieDAO();
    MarqueDAO marqueDao = new MarqueDAO();
    IngredientDAO ingredientDao = new IngredientDAO();
    AllergeneDAO allergeneDAO = new AllergeneDAO();
    AdditifDAO additifDAO = new AdditifDAO();

    ProduitDAO produitDAO = new ProduitDAO();


    public void read(String[] produit) throws DALException {

        Ingredient ingredient = null;
        Allergene allergene = null;
        Additif additif = null;

        if (produit.length == 30) {

            List<String> ingredients = List.of(produit[4].split(","));
            List<String> allergenes = List.of(produit[28].split(","));
            List<String> additifs = List.of(produit[29].split(","));
            Produit newProduit = new Produit();

            Categorie categorie = setCategorie(produit[0]);

            Marque marque = setMarque(produit[1]);

            System.out.println(produit[11].length());


            Set<Ingredient> produitIngredients = new HashSet<Ingredient>();

            for (String i : ingredients) {

                if (i.length() <= 255) {

                    ingredient = setIngredients(i);

                    produitIngredients.add(ingredient);

                }
            }

            Set<Allergene> produitAllergenes = new HashSet<Allergene>();
            for (String a : allergenes) {


                if (a.length() <= 255) {

                    allergene = setAllergene(a);

                    produitAllergenes.add(allergene);

                }
            }

            Set<Additif> produitAdditifs = new HashSet<Additif>();
            for (String a : additifs) {

                if (a.length() <= 255) {

                    additif = setAdditif(a);

                    produitAdditifs.add(additif);

                }
            }


            if (isSet(produit[11])) {
                newProduit.setVitA100g(produit[11]);
            }
            if (isSet(produit[12])) {
                newProduit.setVitD100g(produit[12]);
            }
            if (isSet(produit[13])) {
                newProduit.setVitE100g(produit[13]);
            }
            if (isSet(produit[14])) {
                newProduit.setVitK100g(produit[14]);
            }
            if (isSet(produit[15])) {
                newProduit.setVitC100g(produit[15]);
            }
            if (isSet(produit[16])) {
                newProduit.setVitB1100g(produit[16]);
            }
            if (isSet(produit[17])) {
                newProduit.setVitB2100g(produit[17]);
            }
            if (isSet(produit[18])) {
                newProduit.setVitPP100g(produit[18]);
            }
            if (isSet(produit[19])) {
                newProduit.setVitB6100g(produit[19]);
            }
            if (isSet(produit[20])) {
                newProduit.setVitB9100g(produit[20]);
            }
            if (isSet(produit[21])) {
                newProduit.setVitB12100g(produit[21]);
            }
            if (isSet(produit[22])) {
                newProduit.setCalcium100g(produit[22]);
            }
            if (isSet(produit[23])) {
                newProduit.setMagnesium100g(produit[23]);
            }
            if (isSet(produit[24])) {
                newProduit.setIron100g(produit[24]);
            }
            if (isSet(produit[25])) {
                newProduit.setFer100g(produit[25]);
            }
            if (isSet(produit[26])) {
                newProduit.setBetaCarotene100g(produit[26]);
            }
            if (isSet(produit[27])) {
                newProduit.setPresenceHuilePalme(produit[27]);
            }


            newProduit.setNom(produit[2]);
            newProduit.setGradeNutritionnel(produit[3]);
            newProduit.setCategorie(categorie);
            newProduit.setMarque(marque);
            newProduit.setIngredients(produitIngredients);
            newProduit.setEnergie(produit[5]);
            newProduit.setGraisses(produit[6]);
            newProduit.setSucres(produit[7]);
            newProduit.setFibres(produit[8]);
            newProduit.setProteines(produit[9]);
            newProduit.setSel(produit[10]);
            newProduit.setAllergenes(produitAllergenes);
            newProduit.setAdditifs(produitAdditifs);

            produitDAO.create(newProduit);

        }

    }

    public Categorie setCategorie(String string) throws DALException {
        Categorie categorie = catDao.selectByLibelle(string);

        if (categorie == null) {

            Categorie cat = new Categorie();
            cat.setLibelle(string);

            catDao.create(cat);
            categorie = catDao.selectByLibelle(string);
        }

        return categorie;
    }

    public Marque setMarque(String string) throws DALException {
        Marque marque = marqueDao.selectByLibelle(string);

        if (marque == null) {
            Marque marq = new Marque();
            marq.setLibelle(string);

            marqueDao.create(marq);
            marque = marqueDao.selectByLibelle(string);
        }

        return marque;
    }

    public Ingredient setIngredients(String string) throws DALException {
        Ingredient ingredient = ingredientDao.selectByLibelle(string);


        if (ingredient == null) {
            Ingredient ing = new Ingredient();
            ing.setLibelle(string);
            ingredientDao.create(ing);

            ingredient = ingredientDao.selectByLibelle(string);
        }

        return ingredient;
    }

    public Allergene setAllergene(String string) throws DALException {
        Allergene allergene = allergeneDAO.selectByLibelle(string);

        if (allergene == null) {
            Allergene all = new Allergene();
            all.setLibelle(string);

            allergeneDAO.create(all);
            allergene = allergeneDAO.selectByLibelle(string);
        }

        return allergene;
    }

    public Additif setAdditif(String string) throws DALException {
        Additif additif = additifDAO.selectByLibelle(string);

        if (additif == null) {

            Additif addi = new Additif();

            addi.setLibelle(string);

            additifDAO.create(addi);

            additif = additifDAO.selectByLibelle(string);

        }

        return additif;
    }

    public boolean isSet(String element) {

        return element.length() > 0;


    }

}
