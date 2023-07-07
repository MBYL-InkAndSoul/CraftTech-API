package inkandsoul.ctapi.client.data.model;

import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gson.JsonElement;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;

/**
 * Allows you to load models using built-in Json.
 */
@Environment(EnvType.CLIENT)
public class ModelLoader {

    public static final Map<ModelResourceLocation, JsonElement> BUILTIN_JSON_V_MODEL = new LinkedHashMap<>();
    public static final Map<ResourceLocation, JsonElement> BUILTIN_JSON_R_MODEL = new LinkedHashMap<>();
    public static final Map<ResourceLocation, JsonElement> BLOCK_STATES = new LinkedHashMap<>();

    public static void add(ModelResourceLocation id, JsonElement model){
        BUILTIN_JSON_V_MODEL.put(id, model);
        // if(ModValues.MODEL_DEBUG){
        //     LOGGER.info("Registry model: {}", id);
        // }
    }

    public static void add(ResourceLocation id, JsonElement model){
        BUILTIN_JSON_R_MODEL.put(id, model);
        // if(ModValues.MODEL_DEBUG){
        //     LOGGER.info("Registry model: {}", id);
        // }
    }

    public static void addState(ResourceLocation id, JsonElement model){
        BLOCK_STATES.put(id, model);
        // if(ModValues.MODEL_DEBUG){
        //     LOGGER.info("Registry model: {}", id);
        // }
    }
}