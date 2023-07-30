package inkandsoul.ctapi.expect.item.forge;

import inkandsoul.ctapi.main.common.both.item.IToolItem;
import inkandsoul.ctapi.main.common.both.item.BaseItem;
import inkandsoul.ctapi.main.forge.both.item.ForgeBaseToolItem;

public class ToolItemImpl {
    public static IToolItem of(BaseItem.BaseProperties properties) {
        return new ForgeBaseToolItem(properties);
    }
}
