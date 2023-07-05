package inkandsoul.ctapi.block;

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

    public BaseBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(null, blockPos, blockState);
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
