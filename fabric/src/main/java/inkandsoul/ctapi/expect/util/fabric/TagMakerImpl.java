package inkandsoul.ctapi.expect.util.fabric;

import net.minecraft.resources.ResourceLocation;

public class TagMakerImpl {

    public static ResourceLocation makeTagId(String form, String material) {
        return new ResourceLocation("c", material + '_' + form + 's');
    }
}
