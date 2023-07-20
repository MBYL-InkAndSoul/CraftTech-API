package inkandsoul.ctapi.main.common.both.machine;

import inkandsoul.ctapi.main.common.both.block.BaseBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.InvocationTargetException;

public class MachineBlock extends BaseBlock implements EntityBlock {

    final MachineProperties machineProperties;

    public MachineBlock(Properties properties, MachineProperties machineProperties) {
        super(properties);
        this.machineProperties = machineProperties;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return machineProperties.entity.get(pos, state);
    }

}
