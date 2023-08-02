package inkandsoul.ctapi.main.common.both.transfer;

import inkandsoul.ctapi.main.common.both.block.BaseBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class PipeBlock extends BaseBlock {
    public PipeBlock(Properties properties, BaseProperties p2) {
        super(properties, p2);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void neighborChanged(BlockState state,
                                Level level,
                                BlockPos pos,
                                Block block,
                                BlockPos pos2,
                                boolean bl) {

        super.neighborChanged(state, level, pos, block, pos2, bl);
    }
}
