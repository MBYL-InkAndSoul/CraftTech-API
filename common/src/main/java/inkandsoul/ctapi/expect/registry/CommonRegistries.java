package inkandsoul.ctapi.expect.registry;

import com.mojang.serialization.Codec;
import inkandsoul.ctapi.CT_API;
import inkandsoul.ctapi.main.common.both.machine.Machine;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.schedule.Activity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicateType;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;

public class CommonRegistries {
    public static final CommonRegistry<Activity> ACTIVITY = CommonRegistry.of(Registries.ACTIVITY);
    public static final CommonRegistry<Attribute> ATTRIBUTE = CommonRegistry.of(Registries.ATTRIBUTE);
    public static final CommonRegistry<BannerPattern> BANNER_PATTERN = CommonRegistry.of(Registries.BANNER_PATTERN);
    public static final CommonRegistry<Codec<? extends BiomeSource>> BIOME_SOURCE = CommonRegistry.of(Registries.BIOME_SOURCE);
    public static final CommonRegistry<Block> BLOCK = CommonRegistry.of(Registries.BLOCK);
    public static final CommonRegistry<BlockEntityType<?>> BLOCK_ENTITY_TYPE =
        CommonRegistry.of(Registries.BLOCK_ENTITY_TYPE);
    public static final CommonRegistry<BlockPredicateType<?>> BLOCK_PREDICATE_TYPE =
        CommonRegistry.of(Registries.BLOCK_PREDICATE_TYPE);
    public static final CommonRegistry<BlockStateProviderType<?>> BLOCK_STATE_PROVIDER_TYPE =
        CommonRegistry.of(Registries.BLOCK_STATE_PROVIDER_TYPE);
    public static final CommonRegistry<WorldCarver<?>> CARVER = CommonRegistry.of(Registries.CARVER);
    public static final CommonRegistry<Item> ITEM = CommonRegistry.of(Registries.ITEM);

    public static void init() {
        ExtraKeys.init();
        Extra.init();
    }

    public static class ExtraKeys {
        public static final ResourceKey<Registry<Machine>> MACHINE =
            ResourceKey.createRegistryKey(CT_API.LOC.of("machine"));
        public static void init() {

        }
    }

    public static class Extra {
        public static CommonRegistry<Machine> MACHINE = CommonRegistry.build(ExtraKeys.MACHINE);
        public static void init() {

        }
    }
}
