package inkandsoul.ctapi.client.forge;

import com.mojang.blaze3d.vertex.PoseStack;
import inkandsoul.ctapi.CT_API;
import inkandsoul.ctapi.client.renderer.ItemRenderEvent;
import inkandsoul.ctapi.item.ModelItem;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.GameData;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = CT_API.MOD_ID, value = {Dist.CLIENT})
public class CT_API_ForgeClientInit {
    @SubscribeEvent
    public void init(final FMLClientSetupEvent event){
        ItemRenderEvent.EVENT.register((stack, mode, pose, mbs, light, overlay) -> {
            if(stack.getItem() instanceof ModelItem){
                var mc = Minecraft.getInstance();
                var nbt = stack.getOrCreateTag();

                ItemStack stack2 = null;
                try {
                    stack2 = new ItemStack(
                        Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(
                            ResourceLocation.tryParse(nbt.getString("Display")
                            )
                        ))
                    );
                    var renderer = mc.getItemRenderer();
                    var model = renderer.getModel(stack2, mc.level, mc.player, overlay);

                    renderer.render(stack2, mode, false, pose, mbs, light, overlay, model);
                } catch (Exception e) {
                    if (mc.player != null) {
                        mc.player.sendSystemMessage(Component.literal("ERROR ITEM ID!")
                            .withStyle(ChatFormatting.RED));
                    }
                    stack.setCount(0);
                }
            }
        });
    }

    @SubscribeEvent
    public void addModel(final ModelEvent.RegisterAdditional event) {

    }

}
