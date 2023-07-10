package inkandsoul.ctapi.expect.registry;

import dev.architectury.injectables.annotations.ExpectPlatform;
import inkandsoul.ctapi.main.common.both.util.ResourceUtil;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public class CommonRegistry {

    private final ResourceUtil.Location loc;

    public CommonRegistry(ResourceUtil.Location location) {
        this.loc = location;
    }

    @ExpectPlatform
    public static <T> T registerImpl(ResourceKey<Registry<T>> key, ResourceLocation id, T obj) {
        throw new AssertionError();
    }

    public <T> T register(ResourceKey<Registry<T>> key, String id, T obj) {
        return register(key, loc.of(id), obj);
    }

    public <T> T register(ResourceKey<Registry<T>> key, ResourceLocation id, T obj) {
        return CommonRegistry.registerImpl(key, id, obj);
    }

}
