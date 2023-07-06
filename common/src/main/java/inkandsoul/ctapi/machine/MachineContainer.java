package inkandsoul.ctapi.machine;

import dev.architectury.fluid.FluidStack;
import net.minecraft.world.Container;

public interface MachineContainer extends Container {

    int getTankSize();

    /**
     * @deprecated
     */
    @Deprecated
    @Override
    default boolean isEmpty() {
        return isContainerEmpty();
    }

    boolean isContainerEmpty();

    FluidStack getFluid(int i);

    FluidStack removeFluid(int i, int a);

    FluidStack removeFluidNoUpdata(int i);

    void setFluid(int i, FluidStack stack);

}
