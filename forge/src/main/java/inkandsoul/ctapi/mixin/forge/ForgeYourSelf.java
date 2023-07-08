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
public class ForgeYourSelf {

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

    @Shadow(remap = false)
    private static final boolean DISABLE_VANILLA_REGISTRIES = true;
}
