package inkandsoul.ctapi.mixin.accessors;

import java.util.Map;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.renderer.block.model.ItemModelGenerator;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.resources.ResourceLocation;

@Mixin(ModelBakery.class)
public interface ModelBakeryAccessor {
    @Final
    @Accessor("modelResources")
    public Map<ResourceLocation, BlockModel> getModelResources();

    @Final
    @Accessor("unbakedCache")
    public Map<ResourceLocation, UnbakedModel> getUnbakedCache();

    @Final
    @Accessor("topLevelModels")
    public Map<ResourceLocation, UnbakedModel> getTopLevelModels();

    @Final
    @Accessor("bakedTopLevelModels")
    public Map<ResourceLocation, BakedModel> getBakedTopLevelModels();

    @Accessor("ITEM_MODEL_GENERATOR")
    public ItemModelGenerator getItemModelGenerator();
}
