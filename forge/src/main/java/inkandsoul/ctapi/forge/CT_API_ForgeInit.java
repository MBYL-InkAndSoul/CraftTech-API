package inkandsoul.ctapi.forge;

import dev.architectury.platform.forge.EventBuses;
import dev.architectury.registry.registries.RegistrySupplier;
import inkandsoul.ctapi.CT_API;
import inkandsoul.ctapi.item.BaseItem;
import inkandsoul.ctapi.registries.ModRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.ArrayList;
import java.util.List;

@Mod(CT_API.MOD_ID)
public class CT_API_ForgeInit {

    public CT_API_ForgeInit() {
		// Submit our event bus to let architectury register our content on the right time
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        // bus.addListener(CT_API_ForgeInit::commonInit);
        EventBuses.registerModEventBus(CT_API.MOD_ID, bus);

    }

    @SubscribeEvent
    public static void commonInit(final FMLCommonSetupEvent event){
        CT_API.init();
    }

    // public static final List<RegistrySupplier<Item>> ITEMS = new ArrayList<>();
    // public static final RegistrySupplier<Item> TEST = ModRegistries.ITEMS.register("test", () -> new BaseItem(Component.literal("Forge Test"), new Item.Properties()));
    //
    // static{
    //     ITEMS.add(TEST);
    // }

}