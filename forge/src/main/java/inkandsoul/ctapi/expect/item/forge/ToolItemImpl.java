package inkandsoul.ctapi.expect.item.forge;

import inkandsoul.ctapi.expect.item.IToolItem;
import inkandsoul.ctapi.main.forge.both.item.ForgeBaseToolItem;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;

public interface ToolItemImpl extends IToolItem {
    static IToolItem of(MutableComponent name, Item.Properties properties) {
        return new ForgeBaseToolItem(name, properties);
    }
}
