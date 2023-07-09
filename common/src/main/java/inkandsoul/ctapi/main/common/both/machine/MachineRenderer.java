package inkandsoul.ctapi.main.common.both.machine;

import com.mojang.blaze3d.vertex.PoseStack;
import inkandsoul.ctapi.main.common.both.block.BaseBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

@Environment(EnvType.CLIENT)
public class MachineRenderer<T extends BaseBlockEntity> implements BlockEntityRenderer<T> {

    @Override
    public void render(T entity, float f, PoseStack poseStack, MultiBufferSource mbs, int i, int j) {
        var renderer = Minecraft.getInstance().getBlockRenderer().getModelRenderer();
        var models = Minecraft.getInstance().getModelManager();
        var id = new ModelResourceLocation(
            BuiltInRegistries.BLOCK.getKey(entity.getBlockState().getBlock()), "overlay");
        var model = models.getModel(id);

        renderer.renderModel(poseStack.last(), mbs.getBuffer(RenderType.LINES), entity.getBlockState(),
            model, f, 0.0F, 0.0f, i, j);
    }

}
