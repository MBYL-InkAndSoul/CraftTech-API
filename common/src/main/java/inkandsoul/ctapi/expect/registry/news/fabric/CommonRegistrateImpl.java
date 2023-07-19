package inkandsoul.ctapi.expect.registry.news.fabric;

import inkandsoul.ctapi.expect.registry.news.CommonRegistrate;

public class CommonRegistrateImpl extends CommonRegistrate {
    protected CommonRegistrateImpl(String modid) {
        super(modid);
    }

    public static CommonRegistrate of(String modid) {
        return new CommonRegistrateImpl(modid);
    }
}
