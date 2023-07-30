package inkandsoul.ctapi.main.common.both.registry;

import inkandsoul.ctapi.CT_API;
import inkandsoul.ctapi.main.common.both.energy.EnergyType;
import inkandsoul.ctapi.main.common.both.machine.MachineType;
import inkandsoul.ctapi.main.common.both.recipe.fluid.FluidTagValue;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;

public class SResourceKeys {
    public static final ResourceKey<Registry<ISRegistry<?, ?>>> REGISTRY_KEY =
        ResourceKey.createRegistryKey(CT_API.REG.ofId("registry"));

    public static final ResourceKey<Registry<MachineType<?>>> MACHINE_KEY =
        ResourceKey.createRegistryKey(CT_API.REG.ofId("machine"));
    public static final ResourceKey<Registry<FluidTagValue>> FLUID_TAG_VALUE_KEY =
        ResourceKey.createRegistryKey(CT_API.REG.ofId("fluid_tag_value"));

    public static final ResourceKey<Registry<EnergyType<?>>> ENERGY_TYPE =
        ResourceKey.createRegistryKey(CT_API.REG.ofId("energy_type"));

    public static void init() {

    }
}
