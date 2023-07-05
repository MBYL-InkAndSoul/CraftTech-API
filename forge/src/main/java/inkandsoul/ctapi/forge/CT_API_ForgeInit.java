package inkandsoul.ctapi.forge;

import dev.architectury.platform.forge.EventBuses;
import inkandsoul.ctapi.CT_API;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CT_API.MOD_ID)
public class CT_API_ForgeInit {
    public CT_API_ForgeInit() {
		// Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(CT_API.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
            CT_API.init();
    }
}