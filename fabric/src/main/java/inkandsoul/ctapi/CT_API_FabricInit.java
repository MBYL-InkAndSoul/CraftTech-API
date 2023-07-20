package inkandsoul.ctapi;

import dev.architectury.event.events.client.ClientTooltipEvent;
import io.github.fabricators_of_create.porting_lib.data.PortingLibTagsProvider;
import me.alphamode.forgetags.Tags;
import net.fabricmc.api.ModInitializer;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;

import java.util.LinkedHashSet;

public class CT_API_FabricInit implements ModInitializer {

    @Override
    public void onInitialize() {
        CT_API.sRegInit();
        CT_API.init();

        //PortingLibTagsProvider.
        //Tags
        //TagsReloadEvent.EVENT.register(ra -> {
        //    Registry<Item> reg = ra.registryOrThrow(Registries.ITEM);
        //
        //    TagUtil.bind(reg, ItemTags.PLANKS, new Item[]{Items.ACACIA_BOAT});
        //});

    }
}