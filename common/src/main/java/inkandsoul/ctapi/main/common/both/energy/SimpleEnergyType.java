package inkandsoul.ctapi.main.common.both.energy;

import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

public class SimpleEnergyType implements EnergyType<Integer> {

    private final Component name;
    private final String id;
    private final String unit;

    public SimpleEnergyType(Component name, String id, String unit) {
        this.name = name;
        this.id = id;
        this.unit = unit;
    }

    @Override
    public boolean canOut(
        EnergyStorage<Integer> self,
        EnergyStorage<Integer> target,
        Integer value,
        boolean closure)
    {
        return (target.getType() == this) && (self.get() >= value) && (target.get() + value < target.getMax());
    }

    @Override
    public boolean canIn(
        EnergyStorage<Integer> self,
        EnergyStorage<Integer> target,
        Integer value,
        boolean closure)
    {
        return (target.getType() == this) && (target.get() >= value) && (self.get() + value < self.getMax());
    }

    @Override
    public @NotNull String getId() {
        return id;
    }

    @Override
    public @NotNull String getUnit() {
        return unit;
    }

    @Override
    public @NotNull Component getName() {
        return name;
    }


}
