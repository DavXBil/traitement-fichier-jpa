import bo.Categorie;
import bo.Produit;
import dal.CategorieDAO;
import dal.DALException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestJPA {

    public static void main(String[] args) throws IOException, URISyntaxException, DALException {

        CategorieDAO catDao = new CategorieDAO();

        Path path = Paths.get("src/main/resources/open-food-facts.csv");

        List<String[]> products = readCsv(path);

        for (String[] s : products) {

            if (s.length == 30) {

                String[] ingredients = s[4].split(",");

                Produit newProduit = new Produit();

                Categorie categorie = catDao.selectByLibelle(s[0]);

                newProduit.setNom(s[2]);
                newProduit.setGradeNutritionnel(s[3]);



                if (categorie == null) {

                    Categorie cat = new Categorie();
                    cat.setLibelle(s[0]);

                    catDao.create(cat);
                }

                //System.out.println(catDao.selectByLibelle(s[0]).toString());
                newProduit.setCategorie(categorie);

                System.out.println(newProduit);

                /*if (s[0].equals(catDao.selectByLibelle(s[0]))) {

                } else {*/

                //}


                /*for (String ingredient: ingredients) {
                System.out.println(ingredient);

                }*/


            }
        }

    }

    public static List<String[]> readCsv(Path path) throws IOException {

        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        List<String[]> arrayLines = new ArrayList<>();



        for (String e: lines) {

            String[] line = e.split("\\|");

            arrayLines.add(line);

        }

        arrayLines.remove(0);


        return arrayLines;

    }

}
