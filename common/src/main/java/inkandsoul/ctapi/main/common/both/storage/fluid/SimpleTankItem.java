package inkandsoul.ctapi.main.common.both.storage.fluid;

import dev.architectury.fluid.FluidStack;
import inkandsoul.ctapi.main.common.both.item.BaseItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SimpleTankItem extends BaseItem implements ItemTank {

    private final int tankSize;
    FluidStack tank = FluidStack.empty();

    public SimpleTankItem(MutableComponent name, Properties properties, int tankSize) {
        super(name, properties);
        this.tankSize = tankSize;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int i, boolean bl) {
        CompoundTag nbt = stack.getOrCreateTag();
        tank = FluidStack.read(nbt);
    }

    @Override
    public boolean isTankEmpty() {
        return tank.isEmpty();
    }

    @Override
    public int getTankSize() {
        return tankSize;
    }

    @Override
    public FluidStack getFluid(int i) {
        return tank;
    }

    @Override
    public FluidStack removeFluid(int i, int a) {
        tank.shrink(a);
        return tank;
    }

    @Override
    public FluidStack removeFluidNoUpdate(int i) {
        tank.setAmount(0);
        return tank;
    }

    /**
     * @deprecated Useless
     */
    @Deprecated
    @Override
    public void setFluid(int i, FluidStack stack) {
        tank = stack;
    }
}
