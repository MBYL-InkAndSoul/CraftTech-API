package inkandsoul.ctapi;

import dev.architectury.registry.CreativeTabRegistry;
import inkandsoul.ctapi.item.ModelItem;
import inkandsoul.ctapi.registries.ModMachines;
import inkandsoul.ctapi.registries.ModRegistries;
import inkandsoul.ctapi.util.ResourceUtil;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CT_API {
	public static final String MOD_ID = "ctapi";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final ResourceUtil.Location LOCATION = new ResourceUtil.Location(MOD_ID);
	public static void init() {
		ModRegistries.ITEMS.register("model_item", () -> MODEL_ITEM);
		ModMachines.init();
		ModRegistries.init();
	}
	public static final Item MODEL_ITEM = new ModelItem();
	// public static final CreativeModeTab ITEM_TAB = CreativeTabRegistry.create(builder -> {
	// 	builder.title(Component.literal("CT-API"));
	// 	builder.displayItems((idp, items) -> items.accept(MODEL_ITEM));
	// });
}