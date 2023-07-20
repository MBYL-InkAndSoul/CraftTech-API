package inkandsoul.ctapi;

import inkandsoul.ctapi.main.common.both.registry.SRegistries;
import inkandsoul.ctapi.main.common.both.registry.SResourceKeys;
import inkandsoul.ctapi.main.common.both.util.LocationDefine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CT_API {
	public static final String MOD_ID = "ctapi";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final LocationDefine LOC = new LocationDefine(MOD_ID);
	//public static final CommonRegistrate REG = CommonRegistrate.of(MOD_ID);
	public static boolean sRegInit = false;

	public static void sRegInit() {
		if(sRegInit){
			return;
		}
		//REG.item(Item::new);
		SResourceKeys.init();
		SRegistries.init();
		sRegInit = true;
	}

	//@SuppressWarnings("unchecked")
	public static void init() {
		//ShapedRecipeBuilder.shaped(Rec)

		//RecipeLoader.add(new ResourceLocation("crafting_table"), GsonHelper.parse("""
		//
		//	"""));

		//RecipeLoader.remove(new ResourceLocation("minecraft","crafting_table"));
		//
		//RecipeLoader.add(LOC.of("crafting_table"), GsonHelper.parse("""
		//	{
		//	  "type": "minecraft:crafting_shaped",
		//	  "category": "misc",
		//	  "key": {
		//	    "S": {
		//	      "item": "minecraft:cobblestone"
		//	    },
		//	    "#": {
		//	      "tag": "minecraft:logs"
		//	    }
		//	  },
		//	  "pattern": [
		//	    "SS",
		//	    "##"
		//	  ],
		//	  "result": {
		//	    "item": "minecraft:crafting_table"
		//	  },
		//	  "show_notification": false
		//	}
		//	"""));
		//RecipeReloadEvent.EVENT.register((recipes) -> {
		//	recipes.put();
		//	//byName.put(LOC.of("test"), new ShapedRecipe(LOC.of("test"), "test", CraftingBookCategory.MISC, 3, 3, NonNullList.of(Ingr)))
		//});




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