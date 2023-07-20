package inkandsoul.ctapi.main.common.both.storage.fluid;

import dev.architectury.fluid.FluidStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;

public interface Tank {

    boolean isTankEmpty();

    int getTankSize();

    FluidStack getFluid(int i);

    FluidStack removeFluid(int i, int a);

    FluidStack removeFluidNoUpdate(int i);

    void setFluid(int i, FluidStack stack);

    default int countFluid(Fluid fluid) {
        int i = 0;
        for (int j = 0; j < this.getTankSize(); ++j) {
            FluidStack itemStack = this.getFluid(j);
            if (!itemStack.getFluid().equals(fluid)) continue;
            i += itemStack.getAmount();
        }
        return i;
    }
}
