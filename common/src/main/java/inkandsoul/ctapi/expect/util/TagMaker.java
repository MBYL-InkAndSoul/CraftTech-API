package inkandsoul.ctapi.expect.util;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public class TagMaker {
    /**
     * @deprecated Replace by {@link inkandsoul.ctapi.main.common.both.util.TagUtil}
     */
    @Deprecated
    public static <T> TagKey<T> makeTag(ResourceKey<Registry<T>> key, String form, String material) {
        return TagKey.create(key, makeTagId(form, material));
    }

    @ExpectPlatform
    public static ResourceLocation makeTagId(String form, String material) {
        throw new AssertionError();
    }
}
