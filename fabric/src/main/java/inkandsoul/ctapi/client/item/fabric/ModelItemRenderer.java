package inkandsoul.ctapi.client.item.fabric;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class ModelItemRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer {
    @Override
    public void render(ItemStack stack, ItemDisplayContext mode, PoseStack matrices,
                       MultiBufferSource mbs, int light, int overlay) {
        var mc = Minecraft.getInstance();
        var nbt = stack.getOrCreateTag();

        ItemStack stack2 = null;
        try {
            stack2 = new ItemStack(
                BuiltInRegistries.ITEM.get(
                        ResourceLocation.tryParse(nbt.getString("Display")
                    )
                )
            );
            var renderer = mc.getItemRenderer();
            var model = renderer.getModel(stack2, mc.level, mc.player, overlay);

            renderer.render(stack, mode, false, matrices, mbs, light, overlay, model);
        } catch (Exception e) {
            if (mc.player != null) {
                mc.player.sendSystemMessage(Component.literal("ERROR ITEM ID!")
                    .withStyle(ChatFormatting.RED));
            }
            stack.setCount(0);
        }
    }
}
