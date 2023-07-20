package inkandsoul.ctapi.main.common.both.registry;

import inkandsoul.ctapi.main.common.both.machine.MachineProperties;
import inkandsoul.ctapi.main.common.both.recipe.fluid.FluidTagValue;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;

public final class SRegistries {
    public static final ISRegistry<ResourceLocation, MachineProperties> MACHINE =
        new SRegistry<>(SResourceKeys.MACHINE_KEY);

    public static final ISRegistry<TagKey<Fluid>, FluidTagValue> FLUID_TAG_VALUE =
        new SRegistry<>(SResourceKeys.FLUID_TAG_VALUE_KEY);

    public static void init() {

    }
}
