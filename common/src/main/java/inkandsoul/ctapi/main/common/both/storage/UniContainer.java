package inkandsoul.ctapi.main.common.both.storage;

import dev.architectury.fluid.FluidStack;
import inkandsoul.ctapi.main.common.both.storage.fluid.Tank;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public interface UniContainer extends Container, Tank {

    /**
     * @deprecated
     */
    @Deprecated
    @Override
    default boolean isEmpty() {
        return isContainerEmpty();
    }

    boolean isContainerEmpty();

}
