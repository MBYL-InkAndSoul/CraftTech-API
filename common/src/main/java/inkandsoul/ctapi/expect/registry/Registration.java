package inkandsoul.ctapi.expect.registry;

import com.google.gson.JsonElement;
import com.tterrag.registrate.Registrate;
import dev.architectury.injectables.annotations.ExpectPlatform;
import inkandsoul.ctapi.main.common.client.data.model.ModelLoader;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;

@MethodsReturnNonnullByDefault
public class Registration extends Registrate {

    @ExpectPlatform
    public static Registration of(String modid) {
        throw new AssertionError();
    }

    protected Registration(String modid) {
        super(modid);
    }

    public ResourceLocation ofId(String id) {
        return new ResourceLocation(this.getModid(), id);
    }

    public ModelResourceLocation ofModelId(String id, String v) {
        return new ModelResourceLocation(this.getModid(), id, v);
    }

    public void model(String id, String v, JsonElement model) {
        ModelLoader.add(ofModelId(id, v), model);
    }

    /** FIXME: fix this. */
    @ApiStatus.Internal
    public void state(String id, String v, JsonElement state) {
        ModelLoader.addState(ofModelId(id, v), state);
    }
}
