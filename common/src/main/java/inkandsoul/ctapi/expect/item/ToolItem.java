package inkandsoul.ctapi.expect.item;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;

public interface ToolItem {
    @ExpectPlatform
    static ToolItem of(MutableComponent name, Item.Properties properties) {
        throw new AssertionError();
    }

    default int damageStep(){
        return 1;
    }
}
