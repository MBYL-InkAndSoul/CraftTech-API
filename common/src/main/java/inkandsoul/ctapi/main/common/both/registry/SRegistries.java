package inkandsoul.ctapi.main.common.both.registry;

import inkandsoul.ctapi.main.common.both.machine.MachineProperties;
import net.minecraft.resources.ResourceLocation;

public final class SRegistries {
    public static final ISRegistry<ResourceLocation, MachineProperties> MACHINE =
        new SRegistry<>(SResourceKeys.MACHINE_KEY);



    public static void init() {

    }
}
