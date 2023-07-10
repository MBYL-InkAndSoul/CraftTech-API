package inkandsoul.ctapi;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegisterEvent;

@Mod(CT_API.MOD_ID)
public class CT_API_ForgeInit {


    public CT_API_ForgeInit() {
		// Submit our event bus to let architectury register our content on the right time
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        EventBuses.registerModEventBus(CT_API.MOD_ID, bus);
        bus.register(this);
    }

    @SubscribeEvent
    public void regInit(final RegisterEvent event){

    }

    @SubscribeEvent
    public void init(final FMLCommonSetupEvent event) {
        CT_API.LOGGER.warn("[CT-API] Forge common setup!");
    }

    @SubscribeEvent
    public void warn(final FMLLoadCompleteEvent event) {
        CT_API.LOGGER.warn("[CT-API] Forge support is not in plan!");
        CT_API.LOGGER.warn("[CT-API] Maybe will catch a lot of problems!");
    }

}