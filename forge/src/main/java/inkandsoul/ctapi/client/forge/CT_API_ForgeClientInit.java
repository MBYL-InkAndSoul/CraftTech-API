package inkandsoul.ctapi.client.forge;

import inkandsoul.ctapi.CT_API;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = CT_API.MOD_ID, value = {Dist.CLIENT})
public class CT_API_ForgeClientInit {
    @SubscribeEvent
    public void init(final FMLClientSetupEvent event){

    }

    @SubscribeEvent
    public void addModel(final ModelEvent.RegisterAdditional event) {

    }

}
