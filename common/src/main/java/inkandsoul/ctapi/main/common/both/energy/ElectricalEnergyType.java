package inkandsoul.ctapi.main.common.both.energy;

import net.minecraft.network.chat.Component;

public class ElectricalEnergyType extends ExtremeEnergyType {
    public ElectricalEnergyType(Component name, String id, String unit) {
        super(name, id, unit);
    }

    @Override
    public boolean canOut(EnergyStorage<Long> self, EnergyStorage<Long> target, Long value) {
        if (self instanceof ElectricalEnergyStorage o) {
            return super.canOut(self, target, value);
        }
        return false;
    }

    @Override
    public boolean canIn(EnergyStorage<Long> self, EnergyStorage<Long> target, Long value) {
        if (self instanceof ElectricalEnergyStorage o) {
            return super.canIn(self, target, value);
        }
        return false;
    }
}
