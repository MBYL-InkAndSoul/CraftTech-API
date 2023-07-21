package inkandsoul.ctapi.expect.item;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;

public class ToolItem {
    @ExpectPlatform
    static IToolItem of(MutableComponent name, Item.Properties properties) {
        throw new AssertionError();
    }
}
