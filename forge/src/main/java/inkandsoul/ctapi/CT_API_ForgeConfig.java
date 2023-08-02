package inkandsoul.ctapi;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.config.ModConfigEvent;

public class CT_API_ForgeConfig {

    @SubscribeEvent
    public void loadConfig(final ModConfigEvent.Loading event) {
        CT_API_Values.HARDCORE_BREAK = CT_API_Config.Common.HARDCORE_BREAK.get();
    }

    @SubscribeEvent
    public void reloadConfig(final ModConfigEvent.Reloading event) {
        CT_API_Values.HARDCORE_BREAK = CT_API_Config.Common.HARDCORE_BREAK.get();
    }

    @SubscribeEvent
    public void unloadConfig(final ModConfigEvent.Unloading event) {

    }
}
