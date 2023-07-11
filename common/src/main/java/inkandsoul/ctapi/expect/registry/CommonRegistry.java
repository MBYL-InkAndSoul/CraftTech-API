package inkandsoul.ctapi.expect.registry;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonRegistry<T> {

    public static final Logger LOG = LoggerFactory.getLogger(CommonRegistry.class);

    private final ResourceKey<Registry<T>> rk;

    public CommonRegistry(ResourceKey<Registry<T>> location) {
        this.rk = location;
    }

    @ExpectPlatform
    public static <T> T registerStatic(ResourceKey<Registry<T>> key, ResourceLocation id, T obj) {
        throw new AssertionError();
    }

    public T register(ResourceLocation id, T obj) {
        return CommonRegistry.registerStatic(rk, id, obj);
    }

}
