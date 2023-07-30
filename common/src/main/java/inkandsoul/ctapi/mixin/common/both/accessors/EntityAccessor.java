package inkandsoul.ctapi.mixin.common.both.accessors;

import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Entity.class)
public interface EntityAccessor {
    @Accessor("wasEyeInWater")
    void setWasEyeInWater(boolean f);
}
