package inkandsoul.ctapi;

import dev.architectury.event.events.common.BlockEvent;
import dev.architectury.platform.forge.EventBuses;
import inkandsoul.ctapi.main.common.both.block.BaseBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.NewRegistryEvent;
import net.minecraftforge.registries.RegisterEvent;

@SuppressWarnings("deprecation")
@Mod(CT_API.MOD_ID)
public class CT_API_ForgeInit {

    //public static final Registrate REGISTRATE = Registrate.create(CT_API.MOD_ID);
    public CT_API_ForgeInit() {
        CT_API.init();
        //REGISTRATE.item("test", Item::new);
		// Submit our event bus to let architectury register our content on the right time
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(CT_API.MOD_ID, bus);
        bus.register(this);


    }

    @SubscribeEvent
    public void newReg(final NewRegistryEvent event){
        CT_API.sRegInit();
    }

    @SubscribeEvent
    public void reg(final RegisterEvent event){
        //BuiltInRegistries.BLOCK.
        //event.getForgeRegistry().re

        //event.register(Registries.BLOCK, brh -> {
        //    brh.register();
        //});
        //if(event.getForgeRegistry() == ForgeRegistries.BLOCKS)
    }

    @SubscribeEvent
    public void init(final FMLCommonSetupEvent event) {
        CT_API.LOGGER.warn("[CT-API] Forge common setup!");
        //Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation("oak_log"), new BaseBlock(BlockBehaviour.Properties.of()));
    }

    @SubscribeEvent
    public void warn(final FMLLoadCompleteEvent event) {
        CT_API.LOGGER.warn("[CT-API] Forge support is not in plan!");
        CT_API.LOGGER.warn("[CT-API] Maybe will catch a lot of problems!");
    }

}