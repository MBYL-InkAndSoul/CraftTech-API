package inkandsoul.ctapi.mixin.forge;

import inkandsoul.ctapi.main.common.client.data.model.ModelLoader;
import inkandsoul.ctapi.main.common.both.util.ResourceUtil;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Map;

@Mixin(ModelBakery.class)
public class ModelLoaderHooks {

    @Shadow
    @Final
    private Map<ResourceLocation, UnbakedModel> unbakedCache;
    @Inject(method = "getModel", at = @At("HEAD"), cancellable = true)
    public void getModelHooks(ResourceLocation arg, CallbackInfoReturnable<UnbakedModel> ci){
        if (ModelLoader.BUILTIN_JSON_R_MODEL.containsKey(arg)) {
            ci.setReturnValue(ResourceUtil.loadJsonModelFromString(arg, ModelLoader.BUILTIN_JSON_R_MODEL.get(arg).toString()));
        }
    }

    @Inject(method = "loadModel",
        at = @At(value = "INVOKE", target = "Ljava/util/Objects;equals(Ljava/lang/Object;Ljava/lang/Object;)Z"),
        cancellable = true, locals = LocalCapture.CAPTURE_FAILEXCEPTION)
    public void loadModelHooks(ResourceLocation arg,
                               CallbackInfo ci,
                               ModelResourceLocation marg){
        if (ModelLoader.BUILTIN_JSON_V_MODEL.containsKey(marg)) {
            unbakedCache.put(arg,
                ResourceUtil.loadJsonModelFromString(marg, ModelLoader.BUILTIN_JSON_V_MODEL.get(marg).toString()));
            ci.cancel();
        }
    }
}
