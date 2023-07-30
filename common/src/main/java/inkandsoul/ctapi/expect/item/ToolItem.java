package inkandsoul.ctapi.expect.item;

import dev.architectury.injectables.annotations.ExpectPlatform;
import inkandsoul.ctapi.main.common.both.item.IToolItem;
import net.minecraft.world.item.Item;

public class ToolItem {
    @ExpectPlatform
    public static IToolItem of(Item.Properties properties) {
        throw new AssertionError();
    }
}
