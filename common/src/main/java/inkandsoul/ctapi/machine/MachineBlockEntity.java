package inkandsoul.ctapi.machine;

import inkandsoul.ctapi.block.BaseBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class MachineBlockEntity extends BaseBlockEntity {

    public MachineBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(blockPos, blockState);
    }

    public void tick(Level level, BlockPos pos, BlockState state, MachineBlockEntity self){

    }
}
