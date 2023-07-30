package inkandsoul.ctapi.main.common.both.machine;

import inkandsoul.ctapi.main.common.both.block.BaseBlockEntity;
import inkandsoul.ctapi.main.common.both.block.BlockEntityProvider;
import inkandsoul.ctapi.main.common.both.storage.SimpleUniContainer;
import inkandsoul.ctapi.main.common.both.storage.UniContainer;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public class MachineType<T extends BaseBlockEntity> {

    public static final MachineType<?> EMPTY =
        new MachineType<>(type -> SimpleUniContainer.of(type.containerSize, type.tankSize),
            MachineBlockEntity.defaultTick,
            (pos, state) -> new MachineBlockEntity(pos, state, null),
            null, new Properties());

    @Nullable
    public final AbstractContainerMenu menu;
    public final Function<MachineType<T>, UniContainer> defaultContainer;
    public final BlockEntityProvider entity;
    public final BlockEntityTicker<? extends BaseBlockEntity> entityTicker;

    public final int containerSize;
    public final int tankSize;

    public MachineType(Function<MachineType<T>, UniContainer> container,
                       BlockEntityTicker<T> entityTicker,
                       BlockEntityProvider entity,
                       @Nullable AbstractContainerMenu menu,
                       @NotNull Properties properties
    ) {
        this.defaultContainer = container;
        this.entityTicker = entityTicker;
        this.entity = entity;
        this.menu = menu;
        this.containerSize = properties.containerSize;
        this.tankSize = properties.tankSize;
    }

    public static class Properties {
        private int containerSize = 0;
        private int tankSize = 0;

        public void tankSize(int tankSize) {
            this.tankSize = tankSize;
        }

        public void containerSize(int containerSize) {
            this.containerSize = containerSize;
        }
    }

}
