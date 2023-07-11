package inkandsoul.ctapi.expect.registry.forge;

import inkandsoul.ctapi.expect.registry.CommonRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.RegistryManager;

@SuppressWarnings("UnstableApiUsage")
public class CommonRegistryImpl {

    public static <T> T registerImpl(ResourceKey<Registry<T>> key, ResourceLocation id, T obj) {
        var reg = RegistryManager.ACTIVE.getRegistry(key);
        boolean locked = reg.isLocked();

        if (locked) {
            CommonRegistry.LOG.warn("Register in error time! Unfreeze to force register!");
            reg.unfreeze();
        }

        reg.register(id, obj);

        if (locked) {
            reg.freeze();
        }

        return obj;
    }

}