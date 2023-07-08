package inkandsoul.ctapi.mixin.forge;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.GameData;
import net.minecraftforge.registries.RegistryBuilder;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import static net.minecraftforge.registries.ForgeRegistries.Keys.*;
import static net.minecraftforge.registries.ForgeRegistries.Keys.BIOMES;

@Mixin(GameData.class)
public abstract class ForgeYourSelf {

    // @Shadow @Final private static boolean DISABLE_VANILLA_REGISTRIES;
    // @Shadow @Final private static Logger LOGGER;
    // @Shadow
    // private static boolean hasInit;

    // @Shadow
    // private static <T> RegistryBuilder<T> makeRegistry(ResourceKey<? extends Registry<T>> key, String _default) {
    //
    // }
    //
    // @Shadow protected static <T> RegistryBuilder<T> makeRegistry(ResourceKey<? extends Registry<T>> key){
    //
    // }

    @Overwrite
    public static void init() {
        // if (DISABLE_VANILLA_REGISTRIES) {
        //     LOGGER.warn(REGISTRIES, "DISABLING VANILLA REGISTRY CREATION AS PER SYSTEM VARIABLE SETTING! forge.disableVanillaGameData");
        //     return;
        // }
        // if (hasInit)
        //     return;
        // hasInit = true;

        // Game objects
        // makeRegistry(BLOCKS, "air").addCallback(GameData.BlockCallbacks.INSTANCE).legacyName("blocks").intrusiveHolderCallback(Block::builtInRegistryHolder).create();
        // makeRegistry(FLUIDS, "empty").intrusiveHolderCallback(Fluid::builtInRegistryHolder).create();
        // makeRegistry(ITEMS, "air").addCallback(GameData.ItemCallbacks.INSTANCE).legacyName("items").intrusiveHolderCallback(Item::builtInRegistryHolder).create();
        // makeRegistry(MOB_EFFECTS).legacyName("potions").create();
        // makeRegistry(SOUND_EVENTS).legacyName("soundevents").create();
        // makeRegistry(POTIONS, "empty").legacyName("potiontypes").create();
        // makeRegistry(ENCHANTMENTS).legacyName("enchantments").create();
        // makeRegistry(ENTITY_TYPES, "pig").legacyName("entities").intrusiveHolderCallback(EntityType::builtInRegistryHolder).create();
        // makeRegistry(BLOCK_ENTITY_TYPES).disableSaving().legacyName("blockentities").create();
        // makeRegistry(PARTICLE_TYPES).disableSaving().create();
        // makeRegistry(MENU_TYPES).disableSaving().create();
        // makeRegistry(PAINTING_VARIANTS, "kebab").create();
        // makeRegistry(RECIPE_TYPES).disableSaving().disableSync().create();
        // makeRegistry(RECIPE_SERIALIZERS).disableSaving().create();
        // makeRegistry(ATTRIBUTES).onValidate(GameData.AttributeCallbacks.INSTANCE).disableSaving().disableSync().create();
        // makeRegistry(STAT_TYPES).create();
        // makeRegistry(COMMAND_ARGUMENT_TYPES).disableSaving().create();
        //
        // // Villagers
        // makeRegistry(VILLAGER_PROFESSIONS, "none").create();
        // makeRegistry(POI_TYPES).addCallback(GameData.PointOfInterestTypeCallbacks.INSTANCE).disableSync().create();
        // makeRegistry(MEMORY_MODULE_TYPES, "dummy").disableSync().create();
        // makeRegistry(SENSOR_TYPES, "dummy").disableSaving().disableSync().create();
        // makeRegistry(SCHEDULES).disableSaving().disableSync().create();
        // makeRegistry(ACTIVITIES).disableSaving().disableSync().create();
        //
        // // Worldgen
        // makeRegistry(WORLD_CARVERS).disableSaving().disableSync().create();
        // makeRegistry(FEATURES).disableSaving().disableSync().create();
        // makeRegistry(CHUNK_STATUS, "empty").disableSaving().disableSync().create();
        // makeRegistry(BLOCK_STATE_PROVIDER_TYPES).disableSaving().disableSync().create();
        // makeRegistry(FOLIAGE_PLACER_TYPES).disableSaving().disableSync().create();
        // makeRegistry(TREE_DECORATOR_TYPES).disableSaving().disableSync().create();
        //
        // // Dynamic Worldgen
        // makeRegistry(BIOMES).disableSync().create();
    }
}
