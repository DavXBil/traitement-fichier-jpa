import bo.Categorie;
import bo.Marque;
import bo.Produit;
import dal.CategorieDAO;
import dal.DALException;
import dal.MarqueDAO;


import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TestJPA {

    public static void main(String[] args) throws IOException, URISyntaxException, DALException {

        CategorieDAO catDao = new CategorieDAO();
        MarqueDAO marqueDao = new MarqueDAO();

        Path path = Paths.get("src/main/resources/open-food-facts.csv");

        List<String[]> products = readCsv(path);

        for (String[] s : products) {

            if (s.length == 30) {

                String[] ingredients = s[4].split(",");

                Produit newProduit = new Produit();
                Categorie categorie = catDao.selectByLibelle(s[0]);
                Marque marque = marqueDao.selectByLibelle(s[1]);

                newProduit.setNom(s[2]);
                newProduit.setGradeNutritionnel(s[3]);

                if (categorie == null) {

                    Categorie cat = new Categorie();
                    cat.setLibelle(s[0]);

                    catDao.create(cat);
                }

                if (marque == null) {
                    Marque marq = new Marque();
                    marq.setLibelle(s[1]);

                    marqueDao.create(marq);
                }

                newProduit.setCategorie(categorie);
                newProduit.setMarque(marque);

                System.out.println(newProduit);


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

        //Retrait de la ligne
        arrayLines.remove(0);


        return arrayLines;

    }

}
