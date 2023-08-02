package inkandsoul.ctapi.main.common.both.item;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * <p>僅BlockItem, NullItem與該類無關。</p>
 * <br>
 * <p>Only the BlockItem, NullItem not extends this.</p>
 */
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class BaseItem extends Item implements IBaseItem {

    public BaseItem(BaseProperties properties) {
        super(properties);
    }

    public static class BaseProperties extends Properties {
        private MutableComponent name = Component.empty();

        public MutableComponent getName() {
            return name;
        }

        public void name(MutableComponent name) {
            this.name = name;
        }
    }
}
