package inkandsoul.ctapi.main.common.both.data.recipe;

import java.util.*;

import com.google.gson.JsonElement;
import inkandsoul.ctapi.mixin.common.both.data.RecipeHooks;
import net.minecraft.resources.ResourceLocation;

/**
 *
 */
public class RecipeLoader {
    private static final Set<ResourceLocation> DELETE_RECPIES = new LinkedHashSet<>();

    private static final Map<ResourceLocation, JsonElement> RECIPES = new LinkedHashMap<>();

    public static void remove(ResourceLocation id){
        DELETE_RECPIES.add(id);
    }

    /**
     * Add your recipe using JsonElement. This will be added in Minecraft.
     * @param id The id of recipe
     * @param recipe Recipe context
     */
    public static void add(ResourceLocation id, JsonElement recipe){
        RECIPES.put(id, recipe);
    }

    /**
     * Add recipes in Minecraft.
     * <p>User shouldn't call this method.</p>
     * <p>Must be used in {@link RecipeHooks} only!</p>
     * @param map map
     */
    public static void onRecipesReload(Map<ResourceLocation, JsonElement> map){
        DELETE_RECPIES.forEach(map::remove);
        map.putAll(RECIPES);
    }

    // new ShapedRecipeBuilder(RecipeCategory.MISC, Items.AIR, 64)
    // 		.define('X', Items.DIRT)
    // 		.pattern(" X")
    // 		.pattern("  ")
    // 			.save(i->{
    // 					RecipeLoader.add(i.getId(), i.serializeRecipe());
    // 				},
    // 				LOCATION.of("test")
    // 			);
}
