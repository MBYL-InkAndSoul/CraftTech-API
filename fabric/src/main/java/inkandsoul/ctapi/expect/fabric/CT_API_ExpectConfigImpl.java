package inkandsoul.ctapi.expect.fabric;

import fuzs.forgeconfigapiport.api.config.v2.ForgeConfigRegistry;
import inkandsoul.ctapi.CT_API;
import inkandsoul.ctapi.CT_API_Config;
import net.minecraftforge.fml.config.ModConfig;

public class CT_API_ExpectConfigImpl {
    public static void init() {
        ForgeConfigRegistry.INSTANCE.register(CT_API.MOD_ID, ModConfig.Type.COMMON, CT_API_Config.Common.SPEC);
        ForgeConfigRegistry.INSTANCE.register(CT_API.MOD_ID, ModConfig.Type.SERVER, CT_API_Config.Server.SPEC);
        ForgeConfigRegistry.INSTANCE.register(CT_API.MOD_ID, ModConfig.Type.CLIENT, CT_API_Config.Client.SPEC);
    }
}
