package inkandsoul.ctapi;

import dev.architectury.platform.Platform;
import dev.architectury.registry.ReloadListenerRegistry;
import dev.architectury.registry.fuel.FuelRegistry;
import inkandsoul.ctapi.expect.CT_API_ExpectConfig;
import inkandsoul.ctapi.expect.registry.Registration;
import inkandsoul.ctapi.main.common.both.registry.SRegistries;
import inkandsoul.ctapi.main.common.both.registry.SResourceKeys;
import inkandsoul.ctapi.main.common.both.util.LoggerUtil;
import net.minecraft.server.packs.PackType;

public class CT_API {
	public static final String MOD_ID = "ctapi";
	public static final LoggerUtil.PackagedLogger LOGGER = LoggerUtil.get("CT-API", MOD_ID);
	public static final Registration REG = Registration.of(MOD_ID);
	public static boolean sRegInit = false;

	public static void sRegInit() {
		if(sRegInit){
			return;
		}
		SResourceKeys.init();
		SRegistries.init();
		sRegInit = true;
	}

	public static void init() {
		CT_API_ExpectConfig.init();

		//TagsReloadEvent.EVENT.register(ra -> {
		//	Registry<Block> reg = ra.registryOrThrow(Registries.BLOCK);
		//	//TagUtil.rawAdd(reg, BlockTags.MINEABLE_WITH_AXE, ((NamedAccessor<Block>)reg.getOrCreateTag(BlockTags.LOGS)).getContents());
		//	//TagUtil.rawAdd(reg, BlockTags.NEEDS_STONE_TOOL, ((NamedAccessor<Block>)reg.getOrCreateTag(BlockTags.LOGS)).getContents());
		//	// Calcite
		//	TagUtil.add(reg, BaseBlockTags.HARD, new Block[]{Blocks.CALCITE});
		//	//TagUtil.rawAdd(reg, BaseBlockTags.DROP_SELF, ((NamedAccessor<Block>)reg.getOrCreateTag(BlockTags.LOGS)).getContents());
		//	//Blocks.BLOCK_STATE
		//});


	}

	//public static final Item MODEL_ITEM = CommonRegistries.ITEM.register(LOC.of("model"), ModelItem.of());

//	public static final RegistrySupplier<Item> MODEL = ModRegistries.ITEMS.register("model_item", () -> MODEL_ITEM);

	// public static final RegistrySupplier<Item> MODEL = ModRegistries.ITEMS.register("model_item", () -> MODEL_ITEM);
	// public static final CreativeModeTab ITEM_TAB = CreativeTabRegistry.create(builder -> {
	// 	builder.title(Component.literal("CT-API"));
	// 	builder.displayItems((idp, items) -> items.accept(MODEL_ITEM));
	// });
}