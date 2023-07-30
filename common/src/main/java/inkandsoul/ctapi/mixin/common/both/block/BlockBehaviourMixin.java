package inkandsoul.ctapi.mixin.common.both.block;

import inkandsoul.ctapi.main.common.both.block.BaseBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBehaviour.class)
public class BlockBehaviourMixin {

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

        if (blockState.is(BaseBlockTags.HARD) || !blockState.is(BaseBlockTags.FRAGILE) &&
            (
                (
                    !player.hasCorrectToolForDrops(blockState)
                )
                ||
                (
                    // You can destroy grass by hand
                    blockState.getBlock().defaultDestroyTime() > 0f &&
                    player.getMainHandItem().getItem() != Items.FLINT
                )
            )
        ) {
            ci.setReturnValue(0f);
        } else {
            ci.setReturnValue(f);
        }
    }


}
