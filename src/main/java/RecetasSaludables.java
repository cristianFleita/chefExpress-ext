import entities.Recipe;
import interfaces.RecipeScorer;

public class RecetasSaludables implements RecipeScorer
{
    @Override
    public String getName() {
        return "RecetasSaludables";
    }

    @Override
    public int score(Recipe recipe)
    {
        return recipe.getName().length() > 5? 1 : 0;
    }
}
