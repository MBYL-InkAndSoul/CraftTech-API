package inkandsoul.ctapi.main.common.both.machine;

import inkandsoul.ctapi.main.common.both.block.BaseBlock;
import inkandsoul.ctapi.main.common.both.block.BaseBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class MachineBlock<T extends BaseBlockEntity> extends BaseBlock implements EntityBlock {

    final MachineType<T> machineType;

    public MachineBlock(Properties properties, BaseProperties baseProperties, MachineType<T> machineType) {
        super(properties, baseProperties);
        this.machineType = machineType;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return machineType.entity.get(pos, state);
    }

}
