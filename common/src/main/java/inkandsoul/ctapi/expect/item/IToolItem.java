package inkandsoul.ctapi.expect.item;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public interface IToolItem {
    @Nullable
    default SoundEvent getDamageSound() {
        return SoundEvents.FLINTANDSTEEL_USE;
    }

    @Nullable
    default SoundEvent getBrokenSound() {
        return SoundEvents.ITEM_BREAK;
    }

    default int damageStep() {
        return 1;
    }

    default void onDamage(ItemStack stack) {

    }

    default void onBroken(ItemStack stack) {

    }
}
