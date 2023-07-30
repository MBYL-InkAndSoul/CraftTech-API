package inkandsoul.ctapi.main.common.both.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/**
 * DON'T FORGET SET TYPE!
 */
public class BaseBlockEntity extends BlockEntity {

    BlockEntityType<?> type;

    @SuppressWarnings("DataFlowIssue")
    public BaseBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(null, blockPos, blockState);
    }

    public BaseBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
        this.type = blockEntityType;
    }

    public BaseBlockEntity setType(BlockEntityType<?> type){
        this.type = type;
        return this;
    }

    @Override
    public @NotNull BlockEntityType<?> getType() {
        return this.type;
    }
}
