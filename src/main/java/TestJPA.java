import bll.FileManager;
import bll.OpenFoodFactService;
import bo.Categorie;
import bo.Ingredient;
import bo.Marque;
import bo.Produit;
import dal.CategorieDAO;
import dal.DALException;
import dal.IngredientDAO;
import dal.MarqueDAO;


import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class TestJPA {

    public static void main(String[] args) throws IOException, URISyntaxException, DALException {

        OpenFoodFactService service = new OpenFoodFactService();


        Path path = Paths.get("src/main/resources/open-food-facts.csv");


        List<String[]> produits = FileManager.readCsv(path);


        for (String[] s : produits) {

            Produit produit = service.read(s);

            System.out.println(produit);

        }

    }

}
