package inkandsoul.ctapi.mixin.common.both.accessors;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

@Mixin(BlockItem.class)
public interface BlockItemAccessor {
    @Invoker("updateBlockStateFromTag")
    BlockState getBlockStateFromTag(BlockPos blockPos, Level level, ItemStack itemStack, BlockState blockState);
}
