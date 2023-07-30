package inkandsoul.ctapi.expect.forge;

import inkandsoul.ctapi.CT_API_Config;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class CT_API_ExpectConfigImpl {
    public static void init() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CT_API_Config.Common.SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, CT_API_Config.Server.SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CT_API_Config.Client.SPEC);
    }
}
