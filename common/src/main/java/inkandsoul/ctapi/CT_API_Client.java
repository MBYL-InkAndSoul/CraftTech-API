package inkandsoul.ctapi;

import com.mojang.blaze3d.platform.InputConstants;
import dev.architectury.event.events.client.ClientTooltipEvent;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;

import java.util.LinkedHashSet;

public class CT_API_Client {
    public static void init() {
        ClientTooltipEvent.ITEM.register((stack, lines, flag) -> {
            //var mc = Minecraft.getInstance();
            if (flag.isAdvanced()) {
                if (stack.getTags().toArray().length > 0) {
                    if (Screen.hasShiftDown()) {
                        lines.add(Component.literal("Tag(s):"));
                        var texts = new LinkedHashSet<>(
                            stack.getTags().map(tag ->
                                Component.literal("-" + tag.location()).withStyle(ChatFormatting.GRAY)
                            ).toList()
                        );
                        if (stack.getItem() instanceof BlockItem o){
                            texts.addAll(
                                o.getBlock().defaultBlockState().getTags().map(tag ->
                                    Component.literal("-" + tag.location()).withStyle(ChatFormatting.GRAY)
                                ).toList()
                            );
                        }
                        lines.addAll(texts);
                    } else {
                        lines.add(Component.literal("Press §e[Shift]§r to show tag(s)"));
                    }
                }
                if (stack.getTag() != null) {
                    if (Screen.hasControlDown()) {
                        lines.add(Component.literal("NBT:"));
                        var nbt = stack.getTag();
                        nbt.getAllKeys().forEach(i->{
                            lines.add(
                                Component.literal("-" + i + ":" + nbt.get(i)).withStyle(ChatFormatting.GRAY)
                            );
                        });
                    } else {
                        lines.add(Component.literal("Press §e[Ctrl]§r to show NBT"));
                    }
                }
            }
        });
    }
}
