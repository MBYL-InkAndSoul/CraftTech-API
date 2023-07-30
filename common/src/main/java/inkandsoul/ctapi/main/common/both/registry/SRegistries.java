package inkandsoul.ctapi.main.common.both.registry;

import inkandsoul.ctapi.main.common.both.energy.EnergyType;
import inkandsoul.ctapi.main.common.both.machine.MachineType;
import inkandsoul.ctapi.main.common.both.recipe.fluid.FluidTagValue;
import inkandsoul.ctapi.main.common.both.registry.event.SRegisterEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;

public final class SRegistries {

    public static final ISRegistry<ResourceLocation, ISRegistry<?, ?>> REGISTRIES =
        new SRegistry<>(SResourceKeys.REGISTRY_KEY);

    public static final ISRegistry<ResourceLocation, MachineType<?>> MACHINE =
        new SRegistry<>(SResourceKeys.MACHINE_KEY);

    public static final ISRegistry<TagKey<Fluid>, FluidTagValue> FLUID_TAG_VALUE =
        new SRegistry<>(SResourceKeys.FLUID_TAG_VALUE_KEY);

    public static final ISRegistry<String, EnergyType<?>> ENERGY_TYPE =
        new SRegistry<>(SResourceKeys.ENERGY_TYPE);

    public static void init() {
        REGISTRIES.register(SResourceKeys.MACHINE_KEY.registry(), MACHINE);
        REGISTRIES.register(SResourceKeys.FLUID_TAG_VALUE_KEY.registry(), FLUID_TAG_VALUE);
        REGISTRIES.register(SResourceKeys.ENERGY_TYPE.registry(), ENERGY_TYPE);
        SRegisterEvent.EVENT.invoker().onRegister();
        freeze();
    }

    public static void freeze() {
        REGISTRIES.getRegistry().forEach((k,v)->{
            v.freeze();
        });
    }
}
