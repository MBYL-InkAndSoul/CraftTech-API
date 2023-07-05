package inkandsoul.ctapi.item;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class BaseBlockItem extends BlockItem implements IBaseItem {
    protected final MutableComponent name;

    public BaseBlockItem(Block block, MutableComponent name, Properties properties) {
        super(block, properties);
        this.name = name;
    }

    @Override
    public @NotNull Component getDescription() {
        return name;
    }

    @Override
    public @NotNull Component getName(ItemStack stack) {
        return name;
    }
}
