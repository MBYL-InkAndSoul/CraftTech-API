package inkandsoul.ctapi.event;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.architectury.event.Event;
import dev.architectury.event.EventFactory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public final class ItemStackEvents {

    @Environment(EnvType.CLIENT)
    @FunctionalInterface
    public interface RenderStart {

        Event<RenderStart> EVENT = EventFactory.createEventResult(new RenderStart[0]);

        /**
         * The hooks of renderer.
         * @return Cancel vanilla render?
         */
        boolean render(ItemStack stack,
                    ItemDisplayContext dc,
                    boolean bl,
                    PoseStack pose,
                    MultiBufferSource mbs, int i, int j, BakedModel model);
    }

    @Environment(EnvType.CLIENT)
    @FunctionalInterface
    public interface RenderEnd {

        Event<RenderEnd> EVENT = EventFactory.createEventResult(new RenderEnd[0]);

        /**
         * Other hooks of renderer.
         */
        void render(ItemStack stack,
                    ItemDisplayContext dc,
                    boolean bl,
                    PoseStack pose,
                    MultiBufferSource mbs, int i, int j, BakedModel model);
    }
}
