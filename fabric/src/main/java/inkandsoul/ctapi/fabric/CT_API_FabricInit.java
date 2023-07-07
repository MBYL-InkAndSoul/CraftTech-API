package inkandsoul.ctapi.fabric;

import inkandsoul.ctapi.CT_API;
import inkandsoul.ctapi.registries.ModRegistries;
import net.fabricmc.api.ModInitializer;

public class CT_API_FabricInit implements ModInitializer {
    @Override
    public void onInitialize() {
        CT_API.init();
        ModRegistries.init();
    }
}