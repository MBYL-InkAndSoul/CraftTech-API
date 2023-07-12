package inkandsoul.ctapi.main.common.both.energy;

public class SimpleEnergyType implements EnergyType {
    @Override
    public boolean canOut(EnergyStorage self,
                          EnergyStorage target,
                          int value,
                          boolean closure) {
        return self.getValue() >= value && target.getValue() + value < target.getMaxValue();
    }

    @Override
    public boolean canIn(EnergyStorage self,
                         EnergyStorage target,
                         int value,
                         boolean closure) {
        return target.getValue() >= value && self.getValue() + value < self.getMaxValue();
    }
}
