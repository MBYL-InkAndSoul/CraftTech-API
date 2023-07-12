package inkandsoul.ctapi.expect.registry.forge;

import inkandsoul.ctapi.expect.registry.CommonRegistries;
import inkandsoul.ctapi.main.common.both.machine.Machine;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.NewRegistryEvent;
import net.minecraftforge.registries.RegistryBuilder;

public class CommonRegistriesImpl {
    public static void newRegistry(final NewRegistryEvent event) {
        event.create(new RegistryBuilder<>()
            .setDefaultKey(CommonRegistries.ExtraKeys.MACHINE.registry())
            .setName(CommonRegistries.ExtraKeys.MACHINE.location())
            .add(
                (IForgeRegistry.CreateCallback<Object>) (ifr, regs) -> {
//                    ifr.register("null", new Machine());
                }
            )
        );
    }
}
