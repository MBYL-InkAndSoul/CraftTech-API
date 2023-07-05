package inkandsoul.ctapi.recipe;

import java.util.LinkedHashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

import inkandsoul.ctapi.mixin.data.RecipeAddHooks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;

public class RecipeLoader {
    private static final Map<ResourceLocation, Recipe<?>> RECIPES = new LinkedHashMap<>();

    public static void add(ResourceLocation id, Recipe<?> recipe){
        RECIPES.put(id, recipe);
    }

    /**
     * 將配方扔入事件總線。
     * <p>應該僅於{@link RecipeAddHooks}</p>
     * @param globalRecipeMapBuilder map
     */
    public static void onRecipeReload(ImmutableMap.Builder<ResourceLocation, Recipe<?>> globalRecipeMapBuilder){
        globalRecipeMapBuilder.putAll(RECIPES);
    }
}
