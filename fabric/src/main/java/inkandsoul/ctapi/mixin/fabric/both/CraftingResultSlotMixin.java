package inkandsoul.ctapi.mixin.fabric.both;

import inkandsoul.ctapi.main.common.both.item.IToolItem;
import net.minecraft.core.NonNullList;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.inventory.ResultSlot;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(ResultSlot.class)
public class CraftingResultSlotMixin {

    @Shadow
    @Final private CraftingContainer craftSlots;

    @Inject(method = "onTake", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/NonNullList;get(I)Ljava/lang/Object;"), locals = LocalCapture.CAPTURE_FAILEXCEPTION)
    public void onTakeHooks(Player player,
                            ItemStack itemStack,
                            CallbackInfo ci,
                            NonNullList<ItemStack> nonNullList,
                            int i, ItemStack stack)
    {
        if (stack.getItem() instanceof IToolItem o) {
            if (stack.getDamageValue() + o.damageStep() < stack.getMaxDamage()) {
                o.onDamage(player.level(), player, stack);
            } else {
                o.onBroken(player.level(), player, stack);
            }
        }
    }
}
