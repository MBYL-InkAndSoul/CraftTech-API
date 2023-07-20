package inkandsoul.ctapi.main.fabric.both.tool;

import inkandsoul.ctapi.main.common.both.item.BaseItem;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ItemStack;

public class FabricBaseToolItem extends BaseItem {

    public FabricBaseToolItem(MutableComponent name, Properties properties) {
        super(name, properties);
    }

    @Override
    public ItemStack getRecipeRemainder(ItemStack stack) {
        if(stack.getDamageValue() < stack.getMaxDamage()){
            stack.setDamageValue(stack.getDamageValue()+1);
            return stack;
        }else{
            return ItemStack.EMPTY;
        }
    }
    
}
