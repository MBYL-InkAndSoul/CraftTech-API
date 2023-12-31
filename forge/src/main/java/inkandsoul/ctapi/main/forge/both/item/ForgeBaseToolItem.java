package inkandsoul.ctapi.main.forge.both.item;

import inkandsoul.ctapi.main.common.both.item.IToolItem;
import inkandsoul.ctapi.main.common.both.item.BaseItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.function.Consumer;

public class ForgeBaseToolItem extends BaseItem implements IToolItem {
    public ForgeBaseToolItem(BaseProperties properties) {
        super(properties);
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack stack) {
        if(stack.getDamageValue() < stack.getMaxDamage() - damageStep()) {
            ItemStack t = stack.copy();
            t.setDamageValue(stack.getDamageValue() + damageStep());
            return t;
        }

        return ItemStack.EMPTY;

    }

    @Override
    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, T entity, Consumer<T> onBroken) {
        if (entity instanceof Player o) {
            if (stack.getDamageValue() + amount < stack.getMaxDamage()){
                onDamage(entity.level(), o, stack);
            } else {
                onBroken(entity.level(), o, stack);
            }
        }

        return super.damageItem(stack, amount, entity, onBroken);
    }

}
