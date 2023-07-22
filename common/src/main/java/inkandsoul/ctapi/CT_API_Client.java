package inkandsoul.ctapi;

import dev.architectury.event.events.client.ClientTooltipEvent;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;

import java.util.LinkedHashSet;

public class CT_API_Client {
    public static void init() {
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
