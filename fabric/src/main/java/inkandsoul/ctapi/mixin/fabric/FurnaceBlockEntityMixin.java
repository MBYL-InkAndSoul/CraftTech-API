package inkandsoul.ctapi.mixin.fabric;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;

/**
 * （Forge已修復）
 * <p>修復了Fabric/Quilt燃燒時間上限爲Short的問題，但可能會造成性能/存檔兼容問題。</p>
 */
@Mixin(AbstractFurnaceBlockEntity.class)
public abstract class FurnaceBlockEntityMixin {
	
	@Shadow
	int litTime;

	@Shadow
   	int cookingProgress;

	@Shadow
   	int cookingTotalTime;

	@Inject(method = "load", at = @At("RETURN"))
	public void changeShortTagLoad(CompoundTag nbt, CallbackInfo ci){
		this.litTime = nbt.getInt("BurnTime");
		this.cookingProgress = nbt.getInt("CookTime");
		this.cookingTotalTime = nbt.getInt("CookTimeTotal");
	}

	@Inject(method = "saveAdditional", at = @At("RETURN"))
	public void changeShortTagSave(CompoundTag nbt, CallbackInfo ci){
		nbt.putInt("BurnTime", this.litTime);
      	nbt.putInt("CookTime", this.cookingProgress);
      	nbt.putInt("CookTimeTotal", this.cookingTotalTime);
	}
}
