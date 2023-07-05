package inkandsoul.ctapi.client.fabric;

import org.jetbrains.annotations.Nullable;

import inkandsoul.ctapi.client.model.ModelLoader;
import inkandsoul.ctapi.util.ResourceUtil;
import net.fabricmc.fabric.api.client.model.ModelProviderContext;
import net.fabricmc.fabric.api.client.model.ModelResourceProvider;
import net.fabricmc.fabric.api.client.model.ModelVariantProvider;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.resources.ResourceLocation;

public class ModelLoaderFabric implements ModelVariantProvider, ModelResourceProvider {

    /**
     * 用於處理方塊狀態
     */
    @Override
    public @Nullable UnbakedModel loadModelVariant(ModelResourceLocation modelId, ModelProviderContext context) {
        //     // 需求格式："crafttech:material.<item/block>.<texture_set>.<part>"
        //     // id[1] 指定模型屬於物品還是方塊
        //     // id[2] 指定紋理集
        //     // id[3] 指定部件

        // if(modelId.getNamespace().equals(CT_API.MOD_ID)) {
            // if (ModValues.MODEL_DEBUG) {
            //     ModLogger.LOGGER.info("Loading model: {}", modelId);
            // }
        if (ModelLoader.BUILTIN_JSON_V_MODEL.get(modelId) != null) {
            return ResourceUtil.loadJsonModelFromString(modelId, ModelLoader.BUILTIN_JSON_V_MODEL.get(modelId));
        }
        // }
        return null;
        
    }

    // 说实话这个方法我也没搞明白有什么用，但就先这样吧（）
    @Override
    public @Nullable UnbakedModel loadModelResource(ResourceLocation resourceId, ModelProviderContext context) {
        // if(CTModelLoader.BUILTIN_JSON_MODEL.containsKey(resourceId)){
        // if(ModValues.MODEL_DEBUG && resourceId.getNamespace().equals(CT_API.MOD_ID)){
        //     ModLogger.LOGGER.info("Loading model resource: {}", resourceId);
        // }
        if(ModelLoader.BUILTIN_JSON_R_MODEL.get(resourceId) != null){
            return ResourceUtil.loadJsonModelFromString(resourceId, ModelLoader.BUILTIN_JSON_R_MODEL.get(resourceId));
        }
        return null;
    }
    
}
