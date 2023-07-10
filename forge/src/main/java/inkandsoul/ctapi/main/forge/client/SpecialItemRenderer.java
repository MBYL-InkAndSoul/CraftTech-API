package inkandsoul.ctapi.main.forge.client;

import com.mojang.blaze3d.vertex.PoseStack;
import inkandsoul.ctapi.main.common.client.renderer.ItemRenderEvent;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class SpecialItemRenderer extends BlockEntityWithoutLevelRenderer {

    public SpecialItemRenderer(BlockEntityRenderDispatcher arg, EntityModelSet arg2) {
        super(arg, arg2);
    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext arg2, PoseStack arg3, MultiBufferSource arg4, int i, int j) {
        ItemRenderEvent.EVENT.invoker().render(stack, arg2, arg3, arg4, i, j);
    }
}
