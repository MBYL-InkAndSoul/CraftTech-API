package inkandsoul.ctapi.machine;

import inkandsoul.ctapi.block.BaseBlockEntity;
import net.minecraft.world.Container;
import net.minecraft.world.level.block.entity.BlockEntityTicker;

import java.util.function.Supplier;

public class Machine {

    public final Supplier<Container> defalutContainer;
    public final Class<? extends BaseBlockEntity> entity;
    public final BlockEntityTicker<? extends BaseBlockEntity> entityTick;

    public Machine(Supplier<Container> container,
                   BlockEntityTicker<? extends BaseBlockEntity> entityTick,
                   Class<? extends BaseBlockEntity> entity) {
        this.defalutContainer = container;
        this.entityTick = entityTick;
        this.entity = entity;
    }

    public static class Properties{

    }
}
