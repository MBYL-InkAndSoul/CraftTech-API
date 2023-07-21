package inkandsoul.ctapi.main.common.both.item;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * <p>僅BlockItem, NullItem與該類無關。</p>
 * <br>
 * <p>Only the BlockItem, NullItem not extends this.</p>
 */
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
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

    public static class BaseProperties extends Item.Properties {

    }
}
