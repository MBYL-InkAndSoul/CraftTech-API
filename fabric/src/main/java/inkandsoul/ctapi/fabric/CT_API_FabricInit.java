package inkandsoul.ctapi.fabric;

import inkandsoul.ctapi.CT_API;
import net.fabricmc.api.ModInitializer;

public class CT_API_FabricInit implements ModInitializer {
    @Override
    public void onInitialize() {
        CT_API.init();
    }
}