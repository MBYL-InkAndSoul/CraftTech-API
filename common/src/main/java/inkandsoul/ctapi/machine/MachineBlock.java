package inkandsoul.ctapi.machine;

import inkandsoul.ctapi.block.BaseBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.InvocationTargetException;

public class MachineBlock extends BaseBlock implements EntityBlock {

    Machine machine;

    public MachineBlock(Properties properties, Machine machine) {
        super(properties);
        this.machine = machine;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        try {
            return machine.entity.getConstructor(BlockPos.class, BlockState.class).newInstance(pos, state);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

}
