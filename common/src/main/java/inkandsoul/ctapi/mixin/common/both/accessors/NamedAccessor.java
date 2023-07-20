package inkandsoul.ctapi.mixin.common.both.accessors;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(HolderSet.Named.class)
public interface NamedAccessor<T> {
    @Accessor("contents")
    void bindTags(List<Holder<T>> list);

    @Accessor("contents")
    List<Holder<T>> getContents();
}
