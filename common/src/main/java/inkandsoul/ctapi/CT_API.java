package inkandsoul.ctapi;

import dev.architectury.registry.registries.RegistrySupplier;
import inkandsoul.ctapi.data.recipe.RecipeLoader;
import inkandsoul.ctapi.item.ModelItem;
import inkandsoul.ctapi.registries.ModMachines;
import inkandsoul.ctapi.registries.ModRegistries;
import inkandsoul.ctapi.util.ResourceUtil;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CT_API {
	public static final String MOD_ID = "ctapi";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final ResourceUtil.Location LOCATION = new ResourceUtil.Location(MOD_ID);

	public static void init() {
		ModMachines.init();
	}

	public static final Item MODEL_ITEM = ModelItem.of();
	public static final RegistrySupplier<Item> MODEL = ModRegistries.ITEMS.register("model_item", () -> MODEL_ITEM);

	// public static final RegistrySupplier<Item> MODEL = ModRegistries.ITEMS.register("model_item", () -> MODEL_ITEM);
	// public static final CreativeModeTab ITEM_TAB = CreativeTabRegistry.create(builder -> {
	// 	builder.title(Component.literal("CT-API"));
	// 	builder.displayItems((idp, items) -> items.accept(MODEL_ITEM));
	// });
}