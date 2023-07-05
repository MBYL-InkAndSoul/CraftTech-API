package inkandsoul.ctapi.item;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/**
 * <p>僅BlockItem, NullItem與該類無關。</p>
 * <br>
 * <p>Only the BlockItem, NullItem not extends this.</p>
 */
public class BaseItem extends Item implements IBaseItem {

    protected final MutableComponent name;

    public BaseItem(MutableComponent name, Properties properties) {
        super(properties);
        this.name = name;
    }

    @Override
    public Component getDescription() {
        return name;
    }

    @Override
    public Component getName(ItemStack stack) {
        return name;
    }
    
}
