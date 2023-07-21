package inkandsoul.ctapi.expect.util;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public class TagMaker {
    @ExpectPlatform
    public static <T> TagKey<T> makeTag(ResourceKey<Registry<T>> key, String form, String material) {
        throw new AssertionError();
    }
}
