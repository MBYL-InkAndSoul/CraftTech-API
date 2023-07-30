package inkandsoul.ctapi.main.common.both.energy;

import inkandsoul.ctapi.main.common.both.registry.SRegistries;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

public interface EnergyType<T extends Number> {
//    public final String name;

    boolean canOut(EnergyStorage<T> self,
                   EnergyStorage<T> target,
                   T value,
                   boolean closure);

   boolean canIn(EnergyStorage<T> self,
                 EnergyStorage<T> target,
                 T value,
                 boolean closure);

    @NotNull
    String getId();

    @NotNull
    String getUnit();

    @NotNull
    Component getName();

    default void register() {
        SRegistries.ENERGY_TYPE.register(getId(), this);
    }
}
