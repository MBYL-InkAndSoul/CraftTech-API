package inkandsoul.ctapi.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import inkandsoul.crafttech.ModInfo;
import inkandsoul.crafttech.ModLogger;
import inkandsoul.crafttech.ModValues;
import inkandsoul.ctapi.util.json.JsonObjectBuilder;
import inkandsoul.ctapi.util.model.BlockModels;
import inkandsoul.ctapi.util.model.ItemModels;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;

public class ResourceUtil {
    public static ResourceLocation of(String id){
        return new ResourceLocation(ModInfo.MOD_ID, id);
    }

    /**
     * TODO: Forge Platform!
     */
    public static ResourceLocation ofTag(String id){
        return new ResourceLocation(ModInfo.MOD_ID, id);
    }

    public static ModelResourceLocation ofModel(String id, String varint){
        return new ModelResourceLocation(of(id), varint);
    }

    public static BlockModel loadJsonModelFromString(ResourceLocation id, String model){
        BlockModel blockModel = BlockModel.fromString(model);
        blockModel.name = id.toString();
        return blockModel;
    }

    /**
     * @deprecated
     * Too stupid! Don't let me see again!
     */
    @Deprecated
    public static String generateItemModel(String[] layers){
        StringBuilder builder = new StringBuilder("{\"parent\": \"minecraft:item/generated\",\"textures\":{");
        for(int i = 0;i < layers.length;i++){
            builder.append("\"layer").append(i).append("\":\"item/").append(layers[i]).append('"');
        }

        String result = builder.append("}}").toString();
        result = result.replace(" ","");
        
        // if(ModValues.MODEL_DEBUG){
        //     ModLogger.LOGGER.info("[CT+DEBUG]Generate Model:"+result);
        // }

        return result;
    }

    public static String generateModel(ResourceLocation parent, JsonObject textures){
        JsonObjectBuilder builder = new JsonObjectBuilder();
        builder.add("parent", parent.toString());
        builder.add("textures", textures);

        return builder.get().getAsJsonObject().toString();
    }

    public static String generateModel(ResourceLocation parent, JsonObject textures, JsonArray elements){
        JsonObjectBuilder builder = new JsonObjectBuilder();
        builder.add("parent", parent.toString());
        builder.add("textures", textures);
        builder.add("elements", elements);

        return builder.get().getAsJsonObject().toString();
    }

    public static String generateItemModelNew(String[] layers){
        JsonObjectBuilder textures = new JsonObjectBuilder();
        for (int i = 0; i < layers.length; i++) {
            textures.add("layer" + i, layers[i]);
        }

        return generateModel(ItemModels.GENERATE, textures.get().getAsJsonObject());
    }

    public static String generateSimpleCubeModel(String all){
        return generateModel(BlockModels.CUBE_ALL,
                new JsonObjectBuilder().add("all", all).get().getAsJsonObject());
    }

}
