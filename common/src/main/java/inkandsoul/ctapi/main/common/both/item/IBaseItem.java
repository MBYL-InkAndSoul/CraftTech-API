package inkandsoul.ctapi.main.common.both.item;

import inkandsoul.ctapi.main.common.both.annotation.MustOverride;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

/**
 * <p>Must override methods.</p>
 */
@MustOverride
public interface IBaseItem {
    Component getDescription();
    Component getName(ItemStack stack);
}
