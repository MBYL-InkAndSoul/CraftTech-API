package inkandsoul.ctapi.main.common.both.energy;

import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/**
 * <p>Because limit of NBT.</p>
 * <p>Long is biggest.</p>
 */
public class ExtremeEnergyType implements EnergyType<Long> {

    private final Component name;
    private final String id;
    private final String unit;

    public ExtremeEnergyType(Component name, String id, String unit) {
        this.name = name;
        this.id = id;
        this.unit = unit;
    }

    @Override
    public boolean canOut(EnergyStorage<Long> self, EnergyStorage<Long> target, Long value, boolean closure) {
        return false;
    }

    @Override
    public boolean canIn(EnergyStorage<Long> self, EnergyStorage<Long> target, Long value, boolean closure) {
        return false;
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
