package inkandsoul.ctapi;

import inkandsoul.ctapi.main.common.both.item.ModelItem;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

public class CT_API_FabricInit implements ModInitializer {

    public static Item MODEL = Registry.register(BuiltInRegistries.ITEM, CT_API.LOC.of("model"), ModelItem.of());

    @Override
    public void onInitialize() {

        CT_API.init();
    }
}