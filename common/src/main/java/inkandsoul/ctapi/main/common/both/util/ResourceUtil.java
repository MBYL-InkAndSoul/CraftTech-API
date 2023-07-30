package inkandsoul.ctapi.main.common.both.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import inkandsoul.ctapi.CT_API;
import inkandsoul.ctapi.main.common.both.json.JsonObjectBuilder;
import inkandsoul.ctapi.main.common.client.data.model.BlockModels;
import inkandsoul.ctapi.main.common.client.data.model.ItemModels;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;

public class ResourceUtil {

    @Deprecated
    public static ResourceLocation of(String id){
        return new ResourceLocation(CT_API.MOD_ID, id);
    }

    @Deprecated
    public static ResourceLocation ofTag(String id){
        return new ResourceLocation(CT_API.MOD_ID, id);
    }

    @Deprecated
    public static ModelResourceLocation ofModel(String id, String variant){
        return new ModelResourceLocation(CT_API.REG.ofId(id), variant);
    }

    public static BlockModel loadJsonModelFromString(ResourceLocation id, String model){
        BlockModel blockModel = BlockModel.fromString(model);
        blockModel.name = id.toString();
        return blockModel;
    }

    public static JsonElement generateModel(ResourceLocation parent){
        JsonObjectBuilder builder = new JsonObjectBuilder();
        builder.add("parent", parent.toString());

        return builder.get().getAsJsonObject();
    }

    public static JsonElement generateModel(ResourceLocation parent, JsonObject textures){
        JsonObjectBuilder builder = new JsonObjectBuilder();
        builder.add("parent", parent.toString());
        builder.add("textures", textures);

        return builder.get().getAsJsonObject();
    }

    public static JsonElement generateModel(ResourceLocation parent, JsonObject textures, JsonArray elements){
        JsonObjectBuilder builder = new JsonObjectBuilder();
        builder.add("parent", parent.toString());
        builder.add("textures", textures);
        builder.add("elements", elements);

        return builder.get().getAsJsonObject();
    }

    public static JsonElement generateItemModelNew(String[] layers){
        JsonObjectBuilder textures = new JsonObjectBuilder();
        for (int i = 0; i < layers.length; i++) {
            textures.add("layer" + i, layers[i]);
        }

        return generateModel(ItemModels.GENERATE, textures.get().getAsJsonObject());
    }

    public static JsonElement generateSimpleCubeModel(String all){
        return generateModel(BlockModels.CUBE_ALL,
                new JsonObjectBuilder().add("all", all).get().getAsJsonObject());
    }

    //public static JsonElement generateSimpleRecipe
}
