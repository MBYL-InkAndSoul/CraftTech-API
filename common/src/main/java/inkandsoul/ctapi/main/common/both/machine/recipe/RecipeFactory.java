package inkandsoul.ctapi.main.common.both.machine.recipe;

import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

public class RecipeFactory {
    // private final List<Recipe>
    public record Recipe(List<Ingredient> input, List<Ingredient> output) {

    }
}
