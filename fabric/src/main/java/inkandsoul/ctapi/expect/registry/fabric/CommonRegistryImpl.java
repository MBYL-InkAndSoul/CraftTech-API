package inkandsoul.ctapi.expect.registry.fabric;

import inkandsoul.ctapi.expect.registry.CommonRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

import java.util.Objects;

@SuppressWarnings("unchecked")
public class CommonRegistryImpl<T> extends CommonRegistry<T> {

    public CommonRegistryImpl(ResourceKey<Registry<T>> location) {
        super(location);
    }

    public static <T> T registerImpl(ResourceKey<Registry<T>> key, ResourceLocation id, T obj) {
        Registry.register((Registry<T>)Objects.requireNonNull(BuiltInRegistries.REGISTRY.get(key.registry())), id, obj);
        return obj;
    }

    public static <T> CommonRegistry<T> of(ResourceKey<Registry<T>> location) {
        return new CommonRegistryImpl<>(location);
    }
}
