package inkandsoul.ctapi;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import inkandsoul.ctapi.client.model.ModelLoader;
import inkandsoul.ctapi.item.BaseItem;
import inkandsoul.ctapi.item.ModelItem;
import inkandsoul.ctapi.registries.ModMachines;
import inkandsoul.ctapi.registries.ModRegistries;
import inkandsoul.ctapi.util.ResourceUtil;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CT_API {
	public static final String MOD_ID = "ctapi";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final ResourceUtil.Location LOCATION = new ResourceUtil.Location(MOD_ID);

	public static void init() {
		ModMachines.init();
		ModRegistries.init();
		var model = ResourceUtil.generateItemModelNew(new String[]{"ctapi:item/test"});
		ModelLoader.registerJson(CT_API.LOCATION.ofModel("test", "inventory"), model);
	}

	public static final Item MODEL_ITEM = new ModelItem();
	public static final RegistrySupplier<Item> MODEL = ModRegistries.ITEMS.register("model_item", () -> MODEL_ITEM);
	// public static final CreativeModeTab ITEM_TAB = CreativeTabRegistry.create(builder -> {
	// 	builder.title(Component.literal("CT-API"));
	// 	builder.displayItems((idp, items) -> items.accept(MODEL_ITEM));
	// });
}