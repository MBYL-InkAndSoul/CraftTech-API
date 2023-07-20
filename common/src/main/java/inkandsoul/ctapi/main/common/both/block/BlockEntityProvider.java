package inkandsoul.ctapi.main.common.both.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

@FunctionalInterface
public interface BlockEntityProvider {
    BlockEntity get(BlockPos blockPos, BlockState blockState);
}
