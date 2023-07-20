package inkandsoul.ctapi.main.common.both.registry;

import inkandsoul.ctapi.CT_API;
import inkandsoul.ctapi.main.common.both.machine.MachineProperties;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;

public class SResourceKeys {
    public static final ResourceKey<Registry<MachineProperties>> MACHINE_KEY = ResourceKey.createRegistryKey(CT_API.LOC.of("machine"));

    public static void init() {

    }
}
