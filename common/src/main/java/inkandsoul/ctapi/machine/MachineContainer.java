package inkandsoul.ctapi.machine;

import dev.architectury.fluid.FluidStack;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

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
