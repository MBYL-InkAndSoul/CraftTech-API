package inkandsoul.ctapi;

import inkandsoul.ctapi.expect.item.ModelItem;
import inkandsoul.ctapi.main.common.client.renderer.ItemRenderEvent;
import inkandsoul.ctapi.main.forge.client.SpecialItemRenderer;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = CT_API.MOD_ID, value = {Dist.CLIENT}, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CT_API_ClientForgeInit {

    public static final BlockEntityWithoutLevelRenderer BEWLR_Instance = new SpecialItemRenderer(
        Minecraft.getInstance().getBlockEntityRenderDispatcher(),
        Minecraft.getInstance().getEntityModels()
    );

    @SubscribeEvent
    public static void init(final FMLClientSetupEvent event){
        CT_API_Client.init();
        ItemRenderEvent.EVENT.register((stack, mode, pose, mbs, light, overlay) -> {
            if(stack.getItem() instanceof ModelItem){
                var mc = Minecraft.getInstance();
                var nbt = stack.getOrCreateTag();

                ItemStack stack2;
                try {
                    stack2 = new ItemStack(
                        Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(
                            ResourceLocation.tryParse(nbt.getString("Display"))
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

    //@SubscribeEvent
    //public void addModel(final ModelEvent.RegisterAdditional event) {
    //
    //}

}
