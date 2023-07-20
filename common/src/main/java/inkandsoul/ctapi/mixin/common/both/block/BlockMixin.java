package inkandsoul.ctapi.mixin.common.both.block;

import inkandsoul.ctapi.main.common.both.block.BaseBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Block.class)
public class BlockMixin {
    @Inject(method = "playerDestroy",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/level/block/Block;dropResources(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/entity/BlockEntity;Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/item/ItemStack;)V"),
        cancellable = true)
    public void playerDestroy(Level level,
                              Player player,
                              BlockPos blockPos,
                              BlockState blockState,
                              BlockEntity blockEntity,
                              ItemStack itemStack, CallbackInfo ci) {
        if(blockState.is(BaseBlockTags.DROP_SELF)) {
            Block.popResource(level, blockPos, new ItemStack(((Block)(Object)this).asItem()));
            ci.cancel();
        }
    }
}
