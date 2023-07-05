package inkandsoul.ctapi.block;

import org.jetbrains.annotations.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BaseBlock extends Block {

    public BaseBlock(Properties properties) {
        super(properties);
    }
    
    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, 
            @Nullable BlockEntity blockEntity, ItemStack stack) {
        player.awardStat(Stats.BLOCK_MINED.get(this));
        player.causeFoodExhaustion(0.005F);
        popResource(level, pos, new ItemStack(this.asItem()));
    }

}
