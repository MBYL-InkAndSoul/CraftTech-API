package inkandsoul.ctapi.main.common.both.storage;

import dev.architectury.fluid.FluidStack;
import net.minecraft.world.Container;

public interface UniContainer extends Container {

//    static UniContainer of(int[] size) {
//
//    }

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

    FluidStack removeFluidNoUpdate(int i);

    void setFluid(int i, FluidStack stack);
}
