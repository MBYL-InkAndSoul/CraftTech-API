package inkandsoul.ctapi;

import inkandsoul.ctapi.main.fabric.client.data.ModelLoaderFabric;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.screen.v1.ScreenKeyboardEvents;

public class CT_API_ClientFabricInit implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModelLoadingRegistry.INSTANCE.registerResourceProvider(rl->new ModelLoaderFabric());
        ModelLoadingRegistry.INSTANCE.registerVariantProvider(rl->new ModelLoaderFabric());

        CT_API_Client.init();
        //BuiltinItemRendererRegistry.INSTANCE.register(CT_API_FabricInit.MODEL, new ModelItemRenderer());
    }
}
