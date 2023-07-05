package inkandsoul.ctapi.client.model;

import java.util.LinkedHashMap;
import java.util.Map;

import inkandsoul.crafttech.ModValues;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Environment(EnvType.CLIENT)
public class ModelLoader {

    public static final Logger LOGGER = LoggerFactory.getLogger(ModelLoader.class);

    /**
     * Built in baked models
     */
    public static final Map<ModelResourceLocation, BakedModel> MODELS = new LinkedHashMap<>();

    public static final Map<ModelResourceLocation, String> BUILTIN_JSON_V_MODEL = new LinkedHashMap<>();
    public static final Map<ResourceLocation, String> BUILTIN_JSON_R_MODEL = new LinkedHashMap<>();

    public static void register(ModelResourceLocation id, BakedModel model){
        MODELS.put(id, model);
        if(ModValues.MODEL_DEBUG){
            LOGGER.info("Registry model: {}", id);
        }
    }

    public static void registerJson(ModelResourceLocation id, String model){
        BUILTIN_JSON_V_MODEL.put(id, model);
        if(ModValues.MODEL_DEBUG){
            LOGGER.info("Registry model: {}", id);
        }
    }

    public static void registerJson(ResourceLocation id, String model){
        BUILTIN_JSON_R_MODEL.put(id, model);
        if(ModValues.MODEL_DEBUG){
            LOGGER.info("Registry model: {}", id);
        }
    }
}