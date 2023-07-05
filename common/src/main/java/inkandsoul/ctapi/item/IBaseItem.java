package inkandsoul.ctapi.item;

import inkandsoul.ctapi.annotation.MustOverride;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

/**
 * <p>務必覆蓋該接口的所有方法</p>
 * <br>
 * <p>Must override methods.</p>
 */
@MustOverride
public interface IBaseItem {
    Component getDescription();
    Component getName(ItemStack stack);
}
