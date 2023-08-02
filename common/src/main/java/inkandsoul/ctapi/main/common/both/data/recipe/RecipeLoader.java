package inkandsoul.ctapi.main.common.both.data.recipe;

import java.util.*;

import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonElement;
import inkandsoul.ctapi.mixin.common.both.data.RecipeHooks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

/**
 *
 */
public class RecipeLoader {
    private static final Set<ResourceLocation> DELETE_RECIPES = new LinkedHashSet<>();

    private static final Map<ResourceLocation, JsonElement> JSON_RECIPES = new LinkedHashMap<>();
    private static final Map<ResourceLocation, Recipe<?>> RECIPES = new LinkedHashMap<>();

    public static void remove(ResourceLocation id){
        DELETE_RECIPES.add(id);
    }

    /**
     * Add your recipe using JsonElement. This will be added in Minecraft.
     * @param id The id of recipe
     * @param recipe Recipe context
     */
    public static void add(ResourceLocation id, JsonElement recipe){
        JSON_RECIPES.put(id, recipe);
    }

    /**
     * Add your recipe using JsonElement. This will be added in Minecraft.
     * @param id The id of recipe
     * @param recipe Recipe context
     */
    public static void addBuiltIn(ResourceLocation id, Recipe<?> recipe){
        RECIPES.put(id, recipe);
    }

    /**
     * Add recipes in Minecraft.
     * <p>User shouldn't call this method.</p>
     * <p>Must be used in {@link RecipeHooks} only!</p>
     * @param map map
     */
    public static void onRecipesReload(Map<ResourceLocation, JsonElement> map){
        DELETE_RECIPES.forEach(map::remove);
        map.putAll(JSON_RECIPES);
    }

    /**
     * <p>User shouldn't call this method.</p>
     * <p>Must be used in {@link RecipeHooks} only!</p>
     * @param map map
     */
    public static void onBuiltInRecipesPreReload(ImmutableMap.Builder<ResourceLocation, Recipe<?>> map){
        map.putAll(RECIPES);
    }

    /**
     * <p>User shouldn't call this method.</p>
     * <p>Must be used in {@link RecipeHooks} only!</p>
     * @param map2 map
     */
    public static void onBuiltInRecipesReload(Map<RecipeType<?>, ImmutableMap.Builder<ResourceLocation, Recipe<?>>> map2){
        RECIPES.forEach((resourceLocation,recipe)->{
            map2.computeIfAbsent(recipe.getType(), recipeType -> ImmutableMap.builder()).put(resourceLocation, recipe);
        });
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
