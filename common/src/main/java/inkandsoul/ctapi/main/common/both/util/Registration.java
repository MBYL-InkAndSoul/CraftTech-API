package inkandsoul.ctapi.main.common.both.util;

import com.tterrag.registrate.Registrate;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;

public class Registration extends Registrate {
    public Registration(String modid) {
        super(modid);
    }

    public ResourceLocation ofId(String id) {
        return new ResourceLocation(this.getModid(), id);
    }

    public ModelResourceLocation ofModelId(String id, String v) {
        return new ModelResourceLocation(this.getModid(), id, v);
    }
}
