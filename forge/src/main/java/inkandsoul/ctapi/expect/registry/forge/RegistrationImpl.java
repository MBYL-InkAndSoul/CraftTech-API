package inkandsoul.ctapi.expect.registry.forge;

import inkandsoul.ctapi.expect.registry.Registration;
import org.jetbrains.annotations.NotNull;

public class RegistrationImpl extends Registration {

    protected RegistrationImpl(String modid) {
        super(modid);
    }

    @NotNull
    public static Registration of(String modid) {
        RegistrationImpl registration = new RegistrationImpl(modid);
        registration.registerEventListeners(registration.getModEventBus());
        return registration;
    }
}
