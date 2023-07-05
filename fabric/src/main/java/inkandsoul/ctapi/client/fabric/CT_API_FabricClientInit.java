package inkandsoul.ctapi.client.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;

public class CT_API_FabricClientInit implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModelLoadingRegistry.INSTANCE.registerResourceProvider(rl->new ModelLoaderFabric());
        ModelLoadingRegistry.INSTANCE.registerVariantProvider(rl->new ModelLoaderFabric());
    }
}
