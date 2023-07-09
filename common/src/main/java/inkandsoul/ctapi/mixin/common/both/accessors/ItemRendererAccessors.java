package inkandsoul.ctapi.mixin.common.both.accessors;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.renderer.entity.ItemRenderer;

@Mixin(ItemRenderer.class)
public interface ItemRendererAccessors {
    @Accessor("itemColors")
    ItemColors getItemColors();
}
