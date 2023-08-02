package inkandsoul.ctapi.main.common.both.energy;

public class ExtremeEnergyStorage implements EnergyStorage<Long> {

    private final EnergyType<Long> type;
    private final long maxValue;
    private long value;

    public ExtremeEnergyStorage(EnergyType<Long> type, long maxValue) {
        this.type = type;
        this.maxValue = maxValue;
    }

    @Override
    public EnergyType<Long> getType() {
        return type;
    }

    @Override
    public Long get() {
        return value;
    }

    @Override
    public Long getMax() {
        return maxValue;
    }

    @Override
    public void set(Long i) {
        value = i;
    }

    @Override
    public void shrink(Long i) {
        value -= i;
    }

    @Override
    public void grow(Long i) {
        value += i;
    }
}
