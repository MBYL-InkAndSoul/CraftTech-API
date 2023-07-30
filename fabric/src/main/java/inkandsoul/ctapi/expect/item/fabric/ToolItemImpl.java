package inkandsoul.ctapi.expect.item.fabric;

import inkandsoul.ctapi.main.common.both.item.IToolItem;
import inkandsoul.ctapi.main.common.both.item.BaseItem;
import inkandsoul.ctapi.main.fabric.both.tool.FabricBaseToolItem;

public class ToolItemImpl {

    public static IToolItem of(BaseItem.BaseProperties properties) {
        return new FabricBaseToolItem(properties);
    }
}
