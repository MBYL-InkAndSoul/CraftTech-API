package inkandsoul.ctapi;

import com.tterrag.registrate.Registrate;
import dev.architectury.platform.forge.EventBuses;
import inkandsoul.ctapi.expect.registry.forge.CommonRegistryImpl;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.NewRegistryEvent;
import net.minecraftforge.registries.RegisterEvent;

@Mod(CT_API.MOD_ID)
public class CT_API_ForgeInit {

    //public static final Registrate REGISTRATE = Registrate.create(CT_API.MOD_ID);
    public CT_API_ForgeInit() {
        //REGISTRATE.item("test", Item::new);
		// Submit our event bus to let architectury register our content on the right time
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        EventBuses.registerModEventBus(CT_API.MOD_ID, bus);
        bus.register(this);
    }

    @SubscribeEvent
    public void newReg(final NewRegistryEvent event){
        CommonRegistryImpl.onNewRegistry(event);
    }

    @SubscribeEvent
    public void regInit(final RegisterEvent event){
        CommonRegistryImpl.onRegister(event);
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