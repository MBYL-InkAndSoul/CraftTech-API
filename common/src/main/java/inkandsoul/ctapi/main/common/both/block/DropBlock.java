package inkandsoul.ctapi.main.common.both.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Map;

@ParametersAreNonnullByDefault
public class DropBlock extends BaseBlock {

    private final Map<ItemStack, Integer> drops;

    public DropBlock(Properties properties, BaseProperties baseProperties) {
        super(properties, baseProperties);
        drops = baseProperties.getDrops();
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state,
                              @Nullable BlockEntity blockEntity, ItemStack stack) {
        playerPreDestroy(this, player);
        drops.forEach((i, c)-> {
            if (level.getRandom().nextInt(100) >= c) {
                popResource(level, pos, i);
            }
        });
    }
}
