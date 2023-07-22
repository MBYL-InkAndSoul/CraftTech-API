package inkandsoul.ctapi.main.fabric.both.tool;

import inkandsoul.ctapi.expect.item.IToolItem;
import inkandsoul.ctapi.expect.item.fabric.ToolItemImpl;
import inkandsoul.ctapi.main.common.both.item.BaseItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ItemStack;

public class FabricBaseToolItem extends BaseItem implements IToolItem {

    public FabricBaseToolItem(MutableComponent name, Properties properties) {
        super(name, properties);
    }

    @Override
    public boolean hasCraftingRemainingItem() {
        return true;
    }

    @Override
    public ItemStack getRecipeRemainder(ItemStack stack) {
        if(stack.getDamageValue() < stack.getMaxDamage() - damageStep()) {
            ItemStack t = stack.copy();
            t.setDamageValue(stack.getDamageValue() + damageStep());
            return t;
        }

        return ItemStack.EMPTY;

    }


}
