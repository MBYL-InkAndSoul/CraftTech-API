package inkandsoul.ctapi.main.common.both.storage;

import inkandsoul.ctapi.main.common.both.storage.fluid.Tank;
import net.minecraft.world.Container;

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
