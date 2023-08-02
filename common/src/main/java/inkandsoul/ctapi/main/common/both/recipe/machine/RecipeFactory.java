package inkandsoul.ctapi.main.common.both.recipe.machine;

import dev.architectury.fluid.FluidStack;
import inkandsoul.ctapi.main.common.both.recipe.fluid.FluidIngredient;
import inkandsoul.ctapi.main.common.both.storage.UniContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;
import java.util.Map;

public class RecipeFactory {
    private List<Recipe> recipes = List.of();

    public boolean matches(UniContainer c) {
        for (var r : recipes) {
            if (!r.match(c)) {
                return false;
            }
        }
        return true;
    }

    public void bind(List<Recipe> recipes) {
        this.recipes = List.copyOf(recipes);
    }

    public record Recipe(Map<Ingredient, Integer> itemInput,
                         Map<Ingredient, Integer> itemOutput,
                         Map<FluidIngredient, Integer> fluidInput,
                         Map<FluidIngredient, Integer> fluidOutput) {
        public boolean match(UniContainer c) {
            for (var s : itemInput.entrySet()) {
                Ingredient k = s.getKey();
                int v = s.getValue();

                for (ItemStack item : k.getItems()) {
                    if (c.countItem(item.getItem()) < v) {
                        return false;
                    }
                }
            }

            for (var s : fluidInput.entrySet()) {
                FluidIngredient k = s.getKey();
                int v = s.getValue();

                for (FluidStack fluid : k.getFluids()) {
                    if (c.countFluid(fluid.getFluid()) < v) {
                        return false;
                    }
                }
            }

            return true;
        }
    }
}
