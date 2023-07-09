package inkandsoul.ctapi.mixin.common.both;

import inkandsoul.ctapi.mixin.common.both.accessors.AbstractCauldronBlockAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import inkandsoul.ctapi.main.common.both.event.item.Washable;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.block.AbstractCauldronBlock;

@Mixin(ItemEntity.class)
public class WashableHooks {
    @SuppressWarnings("DataFlowIssue")
	@Inject(method = "tick", at = @At("HEAD"))
	public void washItemHooks(CallbackInfo ci) {
		var self = (ItemEntity) (Object) this;
		var world = self.getCommandSenderWorld();
		if(!world.isClientSide()){
			var state = self.getBlockStateOn();
			if (state.getBlock() instanceof AbstractCauldronBlock a
					&& (((AbstractCauldronBlockAccessor) a).isEntityTouchingFluid(state, self.getOnPos() , self))) {
				var result = Washable.EVENT.invoker().wasWashed(world, state, self.getOnPos(), self.getItem());
				if(result == null){
					result = self.getItem();
				}
				self.setItem(result);
			}
		}
	}
}
