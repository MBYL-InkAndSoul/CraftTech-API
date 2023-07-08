package inkandsoul.ctapi.mixin.forge;

import net.minecraft.core.registries.BuiltInRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BuiltInRegistries.class)
public class FYS_Registries {
    @Inject(method = "freeze", at = @At("HEAD"), cancellable = true)
    private static void freeze(CallbackInfo ci) {
        ci.cancel();
    }

}
