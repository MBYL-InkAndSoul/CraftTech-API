package inkandsoul.ctapi.main.common.both.registry;

import inkandsoul.ctapi.CT_API;
import inkandsoul.ctapi.main.common.both.machine.MachineProperties;
import inkandsoul.ctapi.main.common.both.recipe.fluid.FluidTagValue;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;

public class SResourceKeys {
    public static final ResourceKey<Registry<MachineProperties>> MACHINE_KEY =
        ResourceKey.createRegistryKey(CT_API.LOC.ofId("machine"));
    public static final ResourceKey<Registry<FluidTagValue>> FLUID_TAG_VALUE_KEY =
        ResourceKey.createRegistryKey(CT_API.LOC.ofId("fluid_tag_value"));

    public static void init() {

    }
}
