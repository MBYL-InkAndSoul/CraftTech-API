package inkandsoul.ctapi.main.common.both.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import org.jetbrains.annotations.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Map;

/**
 * Extends {@link Block} class.
 * <p>Contains some more features.</p>
 */
@ParametersAreNonnullByDefault
public class BaseBlock extends Block {

    public BaseBlock(Properties properties, BaseProperties baseProperties) {
        super(properties);
    }

    /**
     * Always drop.
     */
    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, 
            @Nullable BlockEntity blockEntity, ItemStack stack) {
        playerPreDestroy(this, player);
        popResource(level, pos, new ItemStack(this.asItem()));
    }

    public static void playerPreDestroy(Block block, Player player) {
        player.awardStat(Stats.BLOCK_MINED.get(block));
        player.causeFoodExhaustion(0.005F);
    }

    public static class BaseProperties {
        /**
         * @see DropBlock
         */
        private Map<ItemStack, Integer> drops = Map.of();

        public Map<ItemStack, Integer> getDrops() {
            return drops;
        }

        public void drops(Map<ItemStack, Integer> drops) {
            this.drops = drops;
        }
    }


}
