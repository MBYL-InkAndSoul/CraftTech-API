package inkandsoul.ctapi.mixin.common.both.entity;

import inkandsoul.ctapi.main.common.both.fluid.BaseFluidTags;
import inkandsoul.ctapi.mixin.common.both.accessors.EntityAccessor;
import net.minecraft.world.entity.Entity;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityMixin {

    @Shadow protected boolean wasTouchingWater;

    @Shadow protected abstract void doWaterSplashEffect();

    @Shadow protected boolean firstTick;

    @Inject(method = "updateInWaterStateAndDoWaterCurrentPushing()V", at = @At("TAIL"))
    void ct_updateInWaterState(CallbackInfo ci) {
        var self = (Entity)(Object)this;
        if (self.updateFluidHeightAndDoFluidPushing(BaseFluidTags.WATER_LIKE, 0.014)) {
            if (!this.wasTouchingWater && !this.firstTick) {
                this.doWaterSplashEffect();
            }
            self.resetFallDistance();
            this.wasTouchingWater = true;
            self.clearFire();
        }
    }

    @Inject(method = "updateSwimming()V", at = @At("TAIL"))
    public void ct_updateSwimming(CallbackInfo ci) {
        var self = (Entity)(Object)this;
        if (!self.isSwimming()) {
            self.setSwimming(self.level().getFluidState(self.blockPosition()).is(BaseFluidTags.WATER_LIKE));
        }
    }


    @Redirect(method = "updateFluidOnEyes()V",
        at = @At(
            value = "FIELD",
            target = "Lnet/minecraft/world/entity/Entity;wasEyeInWater:Z",
            opcode = Opcodes.PUTFIELD
        )
    )
    private void ct_updateFluidOnEyes(Entity instance, boolean value) {
        ((EntityAccessor)instance).setWasEyeInWater(value && instance.isEyeInFluid(BaseFluidTags.WATER_LIKE));
    }
}
