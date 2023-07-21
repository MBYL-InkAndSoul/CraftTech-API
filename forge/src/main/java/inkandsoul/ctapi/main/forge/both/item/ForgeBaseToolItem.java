package inkandsoul.ctapi.main.forge.both.item;

import inkandsoul.ctapi.expect.item.forge.ToolItemImpl;
import inkandsoul.ctapi.main.common.both.item.BaseItem;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import java.util.function.Consumer;

public class ForgeBaseToolItem extends BaseItem implements ToolItemImpl {
    public ForgeBaseToolItem(MutableComponent name, Properties properties) {
        super(name, properties);
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack stack) {
        stack.setDamageValue(stack.getDamageValue()+damageStep());
        return stack;
    }

    @Override
    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, T entity, Consumer<T> onBroken) {
        var level = entity.level();
        if(!level.isClientSide) {
            if (stack.getDamageValue() + amount < stack.getMaxDamage()){
                if (this.getDamageSound() != null) {
                    level.playSound(
                        entity, entity.blockPosition(), this.getDamageSound(), SoundSource.PLAYERS, 1f, 1f
                    );
                }
            } else {
                if (this.getBrokenSound() != null) {
                    level.playSound(
                        entity, entity.blockPosition(), this.getBrokenSound(), SoundSource.PLAYERS, 1f, 1f
                    );
                }
            }
        }

        return super.damageItem(stack, amount, entity, onBroken);
    }

}
