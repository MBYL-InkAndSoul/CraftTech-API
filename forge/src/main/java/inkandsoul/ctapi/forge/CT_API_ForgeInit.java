package inkandsoul.ctapi.forge;

import dev.architectury.platform.forge.EventBuses;
import inkandsoul.ctapi.CT_API;
import inkandsoul.ctapi.registries.ModRegistries;
import inkandsoul.ctapi.registry.VanillaRegistryLock;
import inkandsoul.fys.ForgeYourself;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
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

        bus.addListener(this::init);
        bus.addListener(this::regInit);
        bus.addListener(this::warn);

        EventBuses.registerModEventBus(CT_API.MOD_ID, bus);

        ModRegistries.init();
    }

    public void regInit(final RegisterEvent event){
        CT_API.init();
    }

    public void init(final FMLCommonSetupEvent event) {

    }

    public void warn(final FMLLoadCompleteEvent event) {
        CT_API.LOGGER.warn("[CT-API]Forge support is not in plan!");
        CT_API.LOGGER.warn("[CT-API]Maybe will catch a lot of problems!");
    }

}