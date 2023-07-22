package inkandsoul.ctapi.expect.item;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public interface IToolItem {
    @Nullable
    default SoundEvent getDamageSound() {
        return SoundEvents.ANVIL_HIT;
    }

    @Nullable
    default SoundEvent getBrokenSound() {
        return SoundEvents.ITEM_BREAK;
    }

    default int damageStep() {
        return 1;
    }

    default void onDamage(Level world, Player player, final ItemStack stack) {
        if (!world.isClientSide && this.getDamageSound() != null) {
            world.playSound(player, player.getOnPos(), getDamageSound(), SoundSource.PLAYERS, 1, 1);
        }
    }

    default void onBroken(Level world, Player player, final ItemStack stack) {
        if (!world.isClientSide && this.getBrokenSound() != null) {
            world.playSound(player, player.getOnPos(), getBrokenSound(), SoundSource.PLAYERS, 1, 1);
        }
    }
}
