package inkandsoul.ctapi.expect.item.fabric;

import inkandsoul.ctapi.expect.item.ToolItem;
import inkandsoul.ctapi.main.fabric.both.tool.FabricBaseToolItem;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;

public interface ToolItemImpl extends ToolItem {

    static ToolItem of(MutableComponent name, Item.Properties properties) {
        return new FabricBaseToolItem(name, properties);
    }
}
