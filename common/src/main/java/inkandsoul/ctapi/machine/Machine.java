package inkandsoul.ctapi.machine;

import inkandsoul.ctapi.block.BaseBlockEntity;
import net.minecraft.world.Container;
import net.minecraft.world.level.block.entity.BlockEntityTicker;

public class Machine {

    public final Class<? extends Container> container;
    public final Class<? extends BaseBlockEntity> entity;
    public final BlockEntityTicker<? extends BaseBlockEntity> entityTick;

    public Machine(Class<? extends Container> container,
                   BlockEntityTicker<? extends BaseBlockEntity> entityTick,
                   Class<? extends BaseBlockEntity> entity) {
        this.container = container;
        this.entityTick = entityTick;
        this.entity = entity;
    }

    public static class Properties{

    }
}
