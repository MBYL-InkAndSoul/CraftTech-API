package inkandsoul.ctapi;

import dev.architectury.event.events.client.ClientTooltipEvent;
import inkandsoul.ctapi.main.fabric.client.data.ModelLoaderFabric;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;

import java.util.LinkedHashSet;

public class CT_API_ClientFabricInit implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModelLoadingRegistry.INSTANCE.registerResourceProvider(rl->new ModelLoaderFabric());
        ModelLoadingRegistry.INSTANCE.registerVariantProvider(rl->new ModelLoaderFabric());

        CT_API_Client.init();
        //BuiltinItemRendererRegistry.INSTANCE.register(CT_API_FabricInit.MODEL, new ModelItemRenderer());
    }
}
