package inkandsoul.ctapi.main.common.both.energy;

import net.minecraft.network.chat.Component;

public final class EnergyTypes {
    public static final EnergyType<Long> EE =
        new ElectricalEnergyType(Component.literal("Electrical Energy"), "ee", "J");

    public static final EnergyType<Integer> LE =
        new SimpleEnergyType(Component.literal("Luminous Energy"), "le", "J");

    public static final EnergyType<Integer> IE =
        new SimpleEnergyType(Component.literal("Internal Energy"), "ie", "J");

    public static final EnergyType<Integer> CE =
        new SimpleEnergyType(Component.literal("Chemical Energy"), "ce", "J");

    public static final EnergyType<Integer> MER =
        new SimpleEnergyType(Component.literal("(Rotational) Mechanical Energy"), "mer", "J");

    public static final EnergyType<Integer> MEK =
        new SimpleEnergyType(Component.literal("(Kinetic) Mechanical Energy"), "mek", "J");

    public static void init() {
        MER.register();
        MEK.register();

        EE.register();
        LE.register();
        IE.register();
        CE.register();
    }
}
