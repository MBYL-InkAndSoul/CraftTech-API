package inkandsoul.ctapi;

import inkandsoul.ctapi.client.fabric.ModelLoaderFabric;
import inkandsoul.ctapi.client.item.fabric.ModelItemRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;

public class CT_API_ClientFabricInit implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModelLoadingRegistry.INSTANCE.registerResourceProvider(rl->new ModelLoaderFabric());
        ModelLoadingRegistry.INSTANCE.registerVariantProvider(rl->new ModelLoaderFabric());

        BuiltinItemRendererRegistry.INSTANCE.register(CT_API.MODEL_ITEM, new ModelItemRenderer());
    }
}
