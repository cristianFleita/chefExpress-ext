import entities.Recipe;
import interfaces.RecipeScorer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecetasSaludables implements RecipeScorer
{

    List<String> prohibitedInIngredients;
    public RecetasSaludables() {
        this.prohibitedInIngredients = new ArrayList<>(List.of(
                "Fritas", "Frita", "Grasa", "Mayonesa", "Alcohol", "Cerveza", "Salchichas", "Mortadela", "Chorizo", "Salsa de soja", "Salchicha", "Empanadas"));
    }

    @Override
    public String getName() {
        return "Saludables";
    }

    @Override
    public int score(Recipe recipe) {
        Random rand = new Random();
        int numeroAleatorio = rand.nextInt(11 - 1 + 1) + 1;

        for(String ingredient : recipe.getIngredients().keySet()){
            if(this.containsWordInList(ingredient, prohibitedInIngredients)){
                numeroAleatorio = 0;
            }
        }
        return numeroAleatorio;
    }

    private static boolean containsWordInList(String word, List<String> words) {
        word = word.toLowerCase();

        for (String w : words) {
            if (word.contains(w.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}