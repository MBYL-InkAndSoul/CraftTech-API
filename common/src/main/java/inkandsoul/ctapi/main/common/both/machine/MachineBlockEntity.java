package inkandsoul.ctapi.main.common.both.machine;

import inkandsoul.ctapi.main.common.both.block.BaseBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;

public class MachineBlockEntity extends BaseBlockEntity {

    public static final BlockEntityTicker<? extends MachineBlockEntity> defaultTick = (level, pos, state, entity) -> {

    };

    public MachineBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(blockPos, blockState);
    }

}
