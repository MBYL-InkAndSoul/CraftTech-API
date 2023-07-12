package inkandsoul.ctapi.main.common.both.energy;

/**
 * Request-energy network.
 */
public class EnergyStorage {
    private final EnergyType type;
    private final int maxValue;
    private int value;

    public EnergyStorage(EnergyType type, int value, int maxValue) {
        this.type = type;
        this.value = value;
        this.maxValue = maxValue;
    }

    public EnergyType getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
