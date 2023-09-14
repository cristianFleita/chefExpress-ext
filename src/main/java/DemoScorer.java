import entities.Recipe;
import interfaces.RecipeScorer;

public class DemoScorer implements RecipeScorer {
    @Override
    public int recipeScorer(Recipe recipe) {
        return 0;
    }
}
