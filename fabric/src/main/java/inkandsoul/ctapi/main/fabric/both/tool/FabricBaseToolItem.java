package inkandsoul.ctapi.main.fabric.both.tool;

import inkandsoul.ctapi.expect.item.fabric.ToolItemImpl;
import inkandsoul.ctapi.main.common.both.item.BaseItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ItemStack;

public class FabricBaseToolItem extends BaseItem implements ToolItemImpl {

    public FabricBaseToolItem(MutableComponent name, Properties properties) {
        super(name, properties);
    }

    @Override
    public ItemStack getRecipeRemainder(ItemStack stack) {
        if(stack.getDamageValue() + damageStep() < stack.getMaxDamage()){
            stack.setDamageValue(stack.getDamageValue()+damageStep());
            onDamage(stack);
            return stack;
        }else{
            onBroken(stack);
            return ItemStack.EMPTY;
        }
    }

}
