package inkandsoul.ctapi.expect.registry;

import com.tterrag.registrate.Registrate;
import dev.architectury.injectables.annotations.ExpectPlatform;
import inkandsoul.ctapi.main.common.both.collection.Vec2;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * A pack for Registry.
 * @param <T> Type
 */
public class CommonRegistry<T> {
    public static final List<CommonRegistry<?>> REGISTRIES = new ArrayList<>();
    private final Stream.Builder<Vec2<ResourceLocation, T>> regs = Stream.builder();

    public static final Logger LOG = LoggerFactory.getLogger(CommonRegistry.class);

    protected final ResourceKey<Registry<T>> rk;

    public ResourceKey<Registry<T>> getKey() {
        return rk;
    }

    public CommonRegistry(ResourceKey<Registry<T>> location) {
        this.rk = location;
        REGISTRIES.add(this);
    }

    @ExpectPlatform
    public static <T> CommonRegistry<T> of(ResourceKey<Registry<T>> location) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <T> CommonRegistry<T> build(ResourceKey<Registry<T>> location) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <T> T registerStatic(ResourceKey<Registry<T>> key, ResourceLocation id, T obj) {
        throw new AssertionError();
    }

    public T register(ResourceLocation id, T obj) {
        regs.add(new Vec2<>(id, obj));
        return obj;
    }

    public Stream<Vec2<ResourceLocation, T>> getHolders() {
        return regs.build();
    }
}
