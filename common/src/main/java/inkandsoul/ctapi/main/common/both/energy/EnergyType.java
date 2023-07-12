package inkandsoul.ctapi.main.common.both.energy;

public interface EnergyType {
//    public final String name;

    boolean canOut(EnergyStorage self,
                   EnergyStorage target,
                   int value,
                   boolean closure);

    boolean canIn(EnergyStorage self,
                  EnergyStorage target,
                  int value,
                  boolean closure);
}
