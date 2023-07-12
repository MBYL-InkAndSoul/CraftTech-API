package inkandsoul.ctapi;

import inkandsoul.ctapi.expect.item.ModelItem;
import inkandsoul.ctapi.expect.registry.CommonRegistries;
import inkandsoul.ctapi.main.common.both.block.BaseBlockTags;
import inkandsoul.ctapi.main.common.both.block.EasilyBreak;
import inkandsoul.ctapi.main.common.both.util.LocationDefine;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.AbstractGlassBlock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CT_API {
	public static final String MOD_ID = "ctapi";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final LocationDefine LOC = new LocationDefine(MOD_ID);

	public static void init() {
		// 原木
		EasilyBreak.EVENT.register(
			block->!block.defaultBlockState().is(BlockTags.LOGS)
		);
		// 玻璃
		EasilyBreak.EVENT.register(
			AbstractGlassBlock.class::isInstance
		);
		// 易碎
		EasilyBreak.EVENT.register(
			block->block.defaultBlockState().is(BaseBlockTags.FRAGILE)
		);
	}

	public static final Item MODEL_ITEM = CommonRegistries.ITEM.register(LOC.of("model"), ModelItem.of());

//	public static final RegistrySupplier<Item> MODEL = ModRegistries.ITEMS.register("model_item", () -> MODEL_ITEM);

	// public static final RegistrySupplier<Item> MODEL = ModRegistries.ITEMS.register("model_item", () -> MODEL_ITEM);
	// public static final CreativeModeTab ITEM_TAB = CreativeTabRegistry.create(builder -> {
	// 	builder.title(Component.literal("CT-API"));
	// 	builder.displayItems((idp, items) -> items.accept(MODEL_ITEM));
	// });
}