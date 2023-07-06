package inkandsoul.ctapi.mixin.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

import inkandsoul.ctapi.block.EasilyBreak;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBehaviour.class)
public class BlockMixin {

    // 困難模式
    @SuppressWarnings("DataFlowIssue")
    @Inject(method = "getDestroyProgress", at = @At("RETURN"), cancellable = true)
    public void overrideDestroyProgress(BlockState blockState,
                                        Player player,
                                        BlockGetter blockGetter,
                                        BlockPos blockPos,
                                        CallbackInfoReturnable<Float> ci){
        var self = (Block)(Object)this;
        float f = ci.getReturnValueF();
        if(!EasilyBreak.EVENT.invoker().applyHardcoreBreak(self)){
            ci.setReturnValue(f == 30f ? 0 : f);
        }else{
            ci.setReturnValue(f);
        }
    }

}
