package inkandsoul.ctapi.expect.registry;

import inkandsoul.ctapi.main.common.both.util.ResourceUtil;
import net.minecraft.resources.ResourceLocation;

public class ModRegistry<T> {
    private final CommonRegistry<T> registry;
    private final ResourceUtil.Location loc;

    public ModRegistry(CommonRegistry<T> registry, ResourceUtil.Location loc) {
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
