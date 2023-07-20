package inkandsoul.ctapi.expect.item.forge;

import inkandsoul.ctapi.expect.item.ToolItem;
import inkandsoul.ctapi.main.forge.both.item.ForgeBaseToolItem;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;

public interface ToolItemImpl extends ToolItem {
    static ToolItem of(MutableComponent name, Item.Properties properties) {
        return new ForgeBaseToolItem(name, properties);
    }
}
