package inkandsoul.ctapi;

import dev.architectury.event.events.client.ClientTooltipEvent;
import inkandsoul.ctapi.main.fabric.client.data.ModelLoaderFabric;
import inkandsoul.ctapi.main.fabric.client.item.ModelItemRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;

import java.util.LinkedHashSet;

public class CT_API_ClientFabricInit implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModelLoadingRegistry.INSTANCE.registerResourceProvider(rl->new ModelLoaderFabric());
        ModelLoadingRegistry.INSTANCE.registerVariantProvider(rl->new ModelLoaderFabric());

        //BuiltinItemRendererRegistry.INSTANCE.register(CT_API_FabricInit.MODEL, new ModelItemRenderer());
        ClientTooltipEvent.ITEM.register((stack, lines, flag) -> {
            if(flag.isAdvanced()) {
                lines.add(Component.literal("Tag(s):"));
                var texts = new LinkedHashSet<>(stack.getTags().map(
                    tag -> Component.literal("-" + tag.location()).withStyle(ChatFormatting.GRAY)).toList());
                if(stack.getItem() instanceof BlockItem o){
                    texts.addAll(o.getBlock().defaultBlockState().getTags().map(
                        tag -> Component.literal("-" + tag.location()).withStyle(ChatFormatting.GRAY)).toList());
                }
                lines.addAll(texts);
            }
        });
    }
}
