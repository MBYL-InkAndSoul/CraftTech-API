package inkandsoul.ctapi.main.common.both.machine;

import inkandsoul.ctapi.main.common.both.block.BaseBlockEntity;
import inkandsoul.ctapi.main.common.both.block.BlockEntityProvider;
import inkandsoul.ctapi.main.common.both.storage.UniContainer;
import net.minecraft.world.level.block.entity.BlockEntityTicker;

import java.util.function.Supplier;

public class MachineProperties {

    public final Supplier<UniContainer> defaultContainer;
    public final BlockEntityProvider entity;
    public final BlockEntityTicker<? extends BaseBlockEntity> entityTick;

    public MachineProperties(Supplier<UniContainer> container,
                             BlockEntityTicker<? extends BaseBlockEntity> entityTick,
                             BlockEntityProvider entity) {
        this.defaultContainer = container;
        this.entityTick = entityTick;
        this.entity = entity;
    }

}
