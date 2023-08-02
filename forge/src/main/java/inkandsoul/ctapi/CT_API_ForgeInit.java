package inkandsoul.ctapi;

import com.tterrag.registrate.Registrate;
import dev.architectury.platform.forge.EventBuses;
import inkandsoul.ctapi.main.common.both.i18n.I18n;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.*;

//@SuppressWarnings("deprecation")
@Mod(CT_API.MOD_ID)
public class CT_API_ForgeInit {

    static {
        CT_API.staticInit();
    }

    public CT_API_ForgeInit() {
        CT_API.init();
		// Submit our event bus to let architectury register our content on the right time
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(CT_API.MOD_ID, bus);
        bus.register(this);
        bus.register(new CT_API_ForgeConfig());
    }

    @SubscribeEvent
    public void newReg(final NewRegistryEvent event){
        CT_API.sRegInit();
    }

    @SubscribeEvent
    public void reg(final RegisterEvent event){
    }

    @SubscribeEvent
    public void init(final FMLCommonSetupEvent event) {
        CT_API.LOGGER.warn("[CT-API] Forge common setup!");
        //Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation("oak_log"), new BaseBlock(BlockBehaviour.Properties.of()));
    }

    @SubscribeEvent
    public void loadingEnd(final FMLLoadCompleteEvent event) {
        I18n.postInit();
    }

}