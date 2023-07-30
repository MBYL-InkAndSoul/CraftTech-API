package inkandsoul.ctapi.main.fabric.both.tool;

import inkandsoul.ctapi.main.common.both.item.IToolItem;
import inkandsoul.ctapi.main.common.both.item.BaseItem;
import net.minecraft.world.item.ItemStack;

public class FabricBaseToolItem extends BaseItem implements IToolItem {

    public FabricBaseToolItem(BaseProperties properties) {
        super(properties);
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
