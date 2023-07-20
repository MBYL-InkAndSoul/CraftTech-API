package inkandsoul.ctapi.main.forge.both.item;

import inkandsoul.ctapi.expect.item.forge.ToolItemImpl;
import inkandsoul.ctapi.main.common.both.item.BaseItem;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ItemStack;

public class ForgeBaseToolItem extends BaseItem implements ToolItemImpl {
    public ForgeBaseToolItem(MutableComponent name, Properties properties) {
        super(name, properties);
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return stack.getDamageValue() + damageStep() < stack.getMaxDamage();
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack stack) {
        stack.setDamageValue(stack.getDamageValue()+damageStep());
        return stack;
    }
}
