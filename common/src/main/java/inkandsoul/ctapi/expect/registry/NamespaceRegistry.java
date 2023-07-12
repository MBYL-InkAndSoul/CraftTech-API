package inkandsoul.ctapi.expect.registry;

import inkandsoul.ctapi.main.common.both.util.LocationDefine;
import net.minecraft.resources.ResourceLocation;

/**
 * More clearly register method.
 * @param <T> Type
 */
public class NamespaceRegistry<T> {
    private final CommonRegistry<T> registry;
    private final LocationDefine loc;

    public NamespaceRegistry(CommonRegistry<T> registry, LocationDefine loc) {
        this.registry = registry;
        this.loc = loc;
    }

    public T register(String id, T obj) {
        return registry.register(loc.of(id), obj);
    }

    public T register(ResourceLocation id, T obj) {
        return registry.register(id, obj);
    }
}
