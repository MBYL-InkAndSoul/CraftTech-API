package inkandsoul.ctapi;

import net.fabricmc.api.ModInitializer;

public class CT_API_FabricInit implements ModInitializer {

    @Override
    public void onInitialize() {
        CT_API.sRegInit();
        CT_API.init();
        CT_API.REG.get().register();
    }
}