package inkandsoul.ctapi.expect.util.forge;

import net.minecraft.resources.ResourceLocation;

public class TagMakerImpl {

    public static ResourceLocation makeTagId(String form, String material) {
        return new ResourceLocation("forge", form + "s/" + material);
    }
}
