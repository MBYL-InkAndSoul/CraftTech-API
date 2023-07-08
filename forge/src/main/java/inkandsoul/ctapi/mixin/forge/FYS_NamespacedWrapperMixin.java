package inkandsoul.ctapi.mixin.forge;

import net.minecraft.core.Registry;
import net.minecraftforge.registries.NamespacedWrapper;
import org.jetbrains.annotations.ApiStatus;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@ApiStatus.Experimental
@Mixin(NamespacedWrapper.class)
public class FYS_NamespacedWrapperMixin<T> {
    // @Shadow private boolean locked;
    //
    @Inject(method = "Lnet/minecraftforge/registries/NamespacedWrapper;freeze()Lnet/minecraft/core/Registry;",
        at = @At("HEAD"),
        cancellable = true)
    public void freeze(CallbackInfoReturnable<Registry<T>> ci){
        ci.setReturnValue((NamespacedWrapper<T>)(Object)this);
    }

    @Inject(method = "lock", at = @At("HEAD"), cancellable = true, remap = false)
    public void lock(CallbackInfo ci) {
        ci.cancel();
        // this.locked = true;
    }
}
