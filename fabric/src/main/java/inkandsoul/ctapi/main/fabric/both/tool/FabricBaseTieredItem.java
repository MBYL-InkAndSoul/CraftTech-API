package inkandsoul.ctapi.main.fabric.both.tool;

import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

public class FabricBaseTieredItem extends FabricBaseToolItem {

    protected final Tier tier;

    public FabricBaseTieredItem(MutableComponent name, Tier tier, Properties properties) {
        super(name, properties);
        this.tier = tier;
    }

    public Tier getTier() {
        return this.tier;
    }

    @Override
    public int getEnchantmentValue() {
        return this.tier.getEnchantmentValue();
    }

    @ParametersAreNonnullByDefault
    public boolean isValidRepairItem(ItemStack arg, ItemStack arg2) {
        return this.tier.getRepairIngredient().test(arg2) || super.isValidRepairItem(arg, arg2);
    }
}
