package inkandsoul.ctapi.uniformat.material.part.meta.fabric;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.PoseStack.Pose;
import com.mojang.blaze3d.vertex.VertexConsumer;

import inkandsoul.crafttech.api.uniformat.renderer.RendererHelper;
import inkandsoul.crafttech.api.uniformat.material.MaterialHelper;
import inkandsoul.ctapi.util.ResourceUtil;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry.DynamicItemRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import static net.minecraft.client.renderer.entity.ItemRenderer.*;

@Environment(EnvType.CLIENT)
public class MaterialItemRenderer implements DynamicItemRenderer {

    @Override
    public void render(ItemStack stack, ItemDisplayContext mode, PoseStack matrices, MultiBufferSource vertexConsumers,
            int light, int overlay) {
        boolean bl = !stack.isEmpty();

        if (!bl) {
            var nbt = stack.getOrCreateTag();
            // var pId = ResourceUtil.of(nbt.getString("MaterialPart"));
            var set = MaterialHelper.getSet(ResourceUtil.of(nbt.getString("MaterialSet")));

            // Map<String, Either<Material, String>> textures = new LinkedHashMap<>();
            // var model = new MaterialItemUnbakeModel(pId, textures).bake(, null, null, TRIDENT_IN_HAND_MODEL);
            Pose pose = matrices.last();
            
            RenderType renderType = ItemBlockRenderTypes.getRenderType(stack, true);
            VertexConsumer vertexConsumer = ItemRenderer.getFoilBufferDirect(vertexConsumers, renderType, true, stack.hasFoil());

            // Minecraft.getInstance().getItemRenderer().render()
            RendererHelper.renderModel(matrices, pose, Minecraft.getInstance().getModelManager()
                .getMissingModel(), vertexConsumer, new int[] { set.color }, light,
                overlay);

        }

    }

}
