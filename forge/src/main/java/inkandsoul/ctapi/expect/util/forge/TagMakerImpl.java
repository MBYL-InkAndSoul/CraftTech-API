package inkandsoul.ctapi.expect.util.forge;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;

public class TagMakerImpl {
    public static <T> TagKey<T> makeTag(ResourceKey<Registry<T>> key, String form, String material) {
        return  TagKey.create(key,
            new ResourceLocation("forge", form + "s/" + material));
    }
}
