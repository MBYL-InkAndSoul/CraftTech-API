package inkandsoul.ctapi.mixin.common.both.block;

import inkandsoul.ctapi.main.common.both.block.hooks.CT_BlockEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockEntity.class)
public abstract class BlockEntityMixin implements CT_BlockEntity {

    @Override
    public CompoundTag ct$saveMeta(CompoundTag nbt) {
        return CT_BlockEntity.super.ct$saveMeta(nbt);
    }

    @Override
    public CompoundTag ct$saveMetadataWithNoPos(CompoundTag nbt){
        return ct$saveMeta(nbt);
    }

    @Inject(method = "saveMetadata(Lnet/minecraft/nbt/CompoundTag;)V", at = @At("TAIL"))
    private void saveMetadata(CompoundTag compoundTag, CallbackInfo ci) {
        ct$saveMeta(compoundTag);
    }

    @Inject(method = "saveWithoutMetadata()Lnet/minecraft/nbt/CompoundTag;", at = @At("RETURN"), cancellable = true)
    public void saveMetadataWithNoPos(CallbackInfoReturnable<CompoundTag> cir) {
        cir.setReturnValue(ct$saveMetadataWithNoPos(cir.getReturnValue()));
    }
}
