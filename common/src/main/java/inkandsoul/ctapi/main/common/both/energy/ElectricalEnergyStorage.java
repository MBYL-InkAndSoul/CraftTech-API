package inkandsoul.ctapi.main.common.both.energy;

public class ElectricalEnergyStorage extends ExtremeEnergyStorage {

    private final byte voltage;

    public ElectricalEnergyStorage(long maxValue, byte voltage) {
        super(EnergyTypes.EE, maxValue);
        this.voltage = voltage;
    }

    public byte getVoltage() {
        return voltage;
    }
}
