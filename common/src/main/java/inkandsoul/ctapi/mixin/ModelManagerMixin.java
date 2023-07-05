package inkandsoul.ctapi.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.client.resources.model.UnbakedModel;

@Mixin(ModelBakery.class)
public abstract class ModelManagerMixin {

    // @Final
    // @Accessor("BUILTIN_MODELS")
    // public static Map<String, String> getModels();

    @Inject(method = "loadTopLevel", at = @At("TAIL"), locals = LocalCapture.CAPTURE_FAILHARD)
    public void debug(ModelResourceLocation modelResourceLocation, CallbackInfo ci, UnbakedModel arg1){
        // if(ModValues.MODEL_DEBUG){
        //     ModLogger.LOGGER.info("Model Identifier: \""+modelResourceLocation.toString()+"\""+" "+arg1.toString());
        // }
    }
    // @Inject(method = "loadModels", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/resources/model/ModelBakery;bakeModels(Ljava/util/function/BiFunction;)V"))
    // public void loadModelsHooks(ProfilerFiller profilerFiller, Map<ResourceLocation, StitchResult> map,
    //         ModelBakery modelBakery, CallbackInfoReturnable<net.minecraft.client.resources.model.ModelManager.ReloadState> ci) {
    //     // var self = (ModelManager) (Object) this;
    //     if(CTModelLoader.MODEL_DEBUG){
    //         map.forEach((k,v)->{
    //             ModInit.LOGGER.info("Identifier: " + k.toString());
    //             ModInit.LOGGER.info(v.toString());
    //         });
    //     }
    // }
}
