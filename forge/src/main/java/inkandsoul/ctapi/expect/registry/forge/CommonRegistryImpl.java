package inkandsoul.ctapi.expect.registry.forge;

import inkandsoul.ctapi.expect.registry.CommonRegistries;
import inkandsoul.ctapi.expect.registry.CommonRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.NewRegistryEvent;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryManager;

@SuppressWarnings({"UnstableApiUsage", "unchecked", "rawtypes"})
public class CommonRegistryImpl<T> extends CommonRegistry<T> {

    public CommonRegistryImpl(ResourceKey<Registry<T>> location) {
        super(location);
    }


    public static void onNewRegistry(final NewRegistryEvent event) {
        CommonRegistries.init();
        CommonRegistriesImpl.newRegistry(event);
    }

    public static void onRegister(final RegisterEvent event) {

        CommonRegistry.REGISTRIES.forEach(
            reg-> event.register(((ResourceKey)reg.getKey()),
                helper-> reg.getHolders().forEach(i->helper.register(i.key, i.value))
            )
        );
    }

    public static <T> CommonRegistry<T> of(ResourceKey<Registry<T>> location) {
        return new CommonRegistryImpl<>(location);
    }

    public static <T> CommonRegistry<T> build(ResourceKey<Registry<T>> location) {
        return new CommonRegistryImpl<>(location);
    }

    public static <T> T registerStatic(ResourceKey<Registry<T>> key, ResourceLocation id, T obj) {
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