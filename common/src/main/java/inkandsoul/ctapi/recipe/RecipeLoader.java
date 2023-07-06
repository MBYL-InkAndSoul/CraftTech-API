package inkandsoul.ctapi.recipe;

import java.util.LinkedHashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

import com.google.gson.JsonElement;
import inkandsoul.ctapi.mixin.data.RecipeAddHooks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;

public class RecipeLoader {
    private static final Map<ResourceLocation, JsonElement> RECIPES = new LinkedHashMap<>();

    public static void add(ResourceLocation id, JsonElement recipe){
        RECIPES.put(id, recipe);
    }

    /**
     * 將配方扔入事件總線。
     * <p>應該僅於{@link RecipeAddHooks}</p>
     * @param globalRecipeMapBuilder map
     */
    public static void onRecipeReload(Map<ResourceLocation, JsonElement> map){
        map.putAll(RECIPES);
    }
}
