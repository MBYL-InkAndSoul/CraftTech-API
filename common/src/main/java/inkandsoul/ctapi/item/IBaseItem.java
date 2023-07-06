package inkandsoul.ctapi.item;

import inkandsoul.ctapi.annotation.MustOverride;
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
