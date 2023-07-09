package inkandsoul.ctapi.main.common.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.architectury.event.Event;
import dev.architectury.event.EventFactory;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public interface ItemRenderEvent {
    Event<ItemRenderEvent> EVENT = EventFactory.createEventResult(ItemRenderEvent.class);

    void render(ItemStack stack, ItemDisplayContext mode, PoseStack pose, MultiBufferSource mbs, int light, int overlay);
}
