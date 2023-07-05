package inkandsoul.ctapi.mixin.block;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import inkandsoul.crafttech.ModValues;
import inkandsoul.ctapi.block.EasilyBreak;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

@Mixin(BlockBehaviour.class)
public class BlockMixin {
    // @Inject(method = "getDestroyProgress", 
    //         at = @At(value = "INVOKE", 
    //             target = "Lnet/minecraft/world/entity/player/Player;hasCorrectToolForDrops(Lnet/minecraft/world/level/block/state/BlockState;)Z", 
    //             shift = At.Shift.AFTER
    //         ),
    //         locals = LocalCapture.CAPTURE_FAILHARD,
    //         cancellable = true)

    // 困難模式
    @ModifyVariable(method = "getDestroyProgress", at = @At("STORE"), ordinal = 1)
    public int overrideDestroyProgress(int i) {
        var self = (Block)(Object)this;
        
        if(!EasilyBreak.EVENT.invoker().applyHardcoreBreak(self)){
            return (ModValues.HARDCORE_BREAK && i == 30 ? 0 : i);
        }else{
            return i;
        }
    }

}
