package inkandsoul.ctapi.expect.registry.forge;

import inkandsoul.ctapi.expect.registry.Registration;

public class RegistrationImpl extends Registration {

    protected RegistrationImpl(String modid) {
        super(modid);
    }

    public static Registration of(String modid) {
        return new RegistrationImpl(modid);
    }
}
