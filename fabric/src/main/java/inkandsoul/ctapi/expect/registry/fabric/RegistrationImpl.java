package inkandsoul.ctapi.expect.registry.fabric;

import inkandsoul.ctapi.expect.registry.Registration;
import org.jetbrains.annotations.NotNull;

public class RegistrationImpl extends Registration {
    protected RegistrationImpl(String modid) {
        super(modid);
    }

    @NotNull
    public static Registration of(String modid) {
        return new RegistrationImpl(modid);
    }
}
