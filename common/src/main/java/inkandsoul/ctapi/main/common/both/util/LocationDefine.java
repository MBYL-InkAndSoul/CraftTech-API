package inkandsoul.ctapi.main.common.both.util;

import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;

@Deprecated
public class LocationDefine {

    public final String MOD_ID;

    public LocationDefine(String MOD_ID) {
        this.MOD_ID = MOD_ID;
    }

    public ResourceLocation of(String id) {
        return new ResourceLocation(MOD_ID, id);
    }

    public ModelResourceLocation ofModel(String id, String v) {
        return new ModelResourceLocation(MOD_ID, id, v);
    }

    /**
     * TODO: Forge Platform!
     */
    public ResourceLocation ofTag(String id) {
        return new ResourceLocation(MOD_ID, id);
    }


}
