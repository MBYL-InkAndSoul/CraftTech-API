package inkandsoul.ctapi;

import inkandsoul.ctapi.expect.item.ModelItem;
import inkandsoul.ctapi.expect.registry.CommonRegistries;
import inkandsoul.ctapi.main.common.both.registry.ModMachines;
import inkandsoul.ctapi.main.common.both.util.ResourceUtil;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CT_API {
	public static final String MOD_ID = "ctapi";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final ResourceUtil.Location LOC = new ResourceUtil.Location(MOD_ID);

	public static void init() {
		ModMachines.init();
	}

	public static final Item MODEL_ITEM = CommonRegistries.ITEM.register(LOC.of("model"), ModelItem.of());

//	public static final RegistrySupplier<Item> MODEL = ModRegistries.ITEMS.register("model_item", () -> MODEL_ITEM);

	// public static final RegistrySupplier<Item> MODEL = ModRegistries.ITEMS.register("model_item", () -> MODEL_ITEM);
	// public static final CreativeModeTab ITEM_TAB = CreativeTabRegistry.create(builder -> {
	// 	builder.title(Component.literal("CT-API"));
	// 	builder.displayItems((idp, items) -> items.accept(MODEL_ITEM));
	// });
}