package inkandsoul.ctapi.main.common.both.energy;

import net.minecraft.nbt.CompoundTag;

/**
 * Request-energy network.
 */
@SuppressWarnings("unused")
public class SimpleEnergyStorage implements EnergyStorage<Integer> {
    private final EnergyType<Integer> type;
    private final int maxValue;
    private int value;

    public SimpleEnergyStorage(EnergyType<Integer> type, int value, int maxValue) {
        this.type = type;
        this.value = value;
        this.maxValue = maxValue;
    }

    public EnergyType<Integer> getType() {
        return type;
    }

    public Integer get() {
        return value;
    }

    public Integer getMax() {
        return maxValue;
    }

    public void set(Integer value) {
        this.value = value;
    }

    public void shrink(Integer value) {
        this.value -= value;
    }

    public void grow(Integer value) {
        this.value += value;
    }

    public CompoundTag write(String suffix, CompoundTag nbt) {
        nbt.putInt("storage_" + suffix, value);
        return nbt;
    }

    public CompoundTag read(String suffix, CompoundTag nbt) {
        value = nbt.getInt("storage_" + suffix);
        return nbt;
    }
}
