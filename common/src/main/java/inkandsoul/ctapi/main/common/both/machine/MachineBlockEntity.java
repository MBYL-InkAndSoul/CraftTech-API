package inkandsoul.ctapi.main.common.both.machine;

import inkandsoul.ctapi.main.common.both.block.BaseBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;

public class MachineBlockEntity extends BaseBlockEntity {

    protected final MachineType<? extends MachineBlockEntity> machineType;

    int progress;

    public static final BlockEntityTicker<? extends MachineBlockEntity> defaultTick = (level, pos, state, entity) -> {
        if (entity.stillWork(level, pos, state, entity)) {
            if (entity.progress > 0) {
                entity.progress--;
            }
        } else {
            entity.progress = 0;
        }
    };

    public MachineBlockEntity(BlockPos blockPos, BlockState blockState,
                              MachineType<? extends MachineBlockEntity> machineType) {
        super(blockPos, blockState);
        this.machineType = machineType;
    }

    @SuppressWarnings("unused")
    public boolean stillWork(Level level, BlockPos pos, BlockState state, BlockEntity entity) {
        return false;
    }

}
