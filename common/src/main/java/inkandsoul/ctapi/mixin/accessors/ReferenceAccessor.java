package inkandsoul.ctapi.mixin.accessors;

import net.minecraft.core.Holder;
import net.minecraft.tags.TagKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Set;

@Mixin(Holder.Reference.class)
public interface ReferenceAccessor<T> {
    @Accessor("tags")
    Set<TagKey<T>> getTags();

    @Accessor
    void setTags(Set<TagKey<T>> tags);
}
