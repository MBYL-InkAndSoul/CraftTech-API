package inkandsoul.ctapi.mixin.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import inkandsoul.ctapi.event.ItemStackEvents;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {
    // @Inject(method = "render(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemDisplayContext;ZLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;IILnet/minecraft/client/resources/model/BakedModel;)V",
    //         at = @At(
    //                 value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;isEmpty()Z", shift = At.Shift.AFTER),
    //         cancellable = true)
    // public void renderStartHooks(ItemStack stack,
    //                         ItemDisplayContext dc,
    //                         boolean bl,
    //                         PoseStack pose,
    //                         MultiBufferSource mbs,
    //                         int i, int j,
    //                         BakedModel bm,
    //                         CallbackInfo ci)
    // {
    //     if(ItemStackEvents.RenderStart.EVENT.invoker().render(stack, dc, bl, pose, mbs, i, j, bm)){
    //         ci.cancel();
    //     }
    // }

    @Inject(method = "render(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemDisplayContext;ZLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;IILnet/minecraft/client/resources/model/BakedModel;)V",
            at = @At("TAIL"))
    public void renderEndHooks(ItemStack stack,
                            ItemDisplayContext dc,
                            boolean bl,
                            PoseStack pose,
                            MultiBufferSource mbs,
                            int i, int j,
                            BakedModel bm,
                            CallbackInfo ci)
    {
        ItemStackEvents.RenderEnd.EVENT.invoker().render(stack, dc, bl, pose, mbs, i, j, bm);
    }
}
