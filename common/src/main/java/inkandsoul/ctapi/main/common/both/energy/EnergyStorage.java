package inkandsoul.ctapi.main.common.both.energy;

public interface EnergyStorage<T extends Number> {

    EnergyType<T> getType();
    T get();
    T getMax();
    void set(T i);
    void shrink(T i);
    void grow(T i);
}
