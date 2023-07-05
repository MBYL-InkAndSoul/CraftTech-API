package inkandsoul.ctapi.registries;

import java.util.function.Supplier;

import com.google.common.base.Suppliers;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrarManager;
import inkandsoul.ctapi.CT_API;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

public final class ModRegistries {

    public static final Supplier<RegistrarManager> MANAGER = Suppliers
            .memoize(() -> RegistrarManager.get(CT_API.MOD_ID));

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(CT_API.MOD_ID,
            Registries.CREATIVE_MODE_TAB);

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(CT_API.MOD_ID, Registries.ITEM);

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(CT_API.MOD_ID, Registries.BLOCK);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(CT_API.MOD_ID,
            Registries.BLOCK_ENTITY_TYPE);

    public static void init(){
        BLOCKS.register();
        BLOCK_ENTITIES.register();
        ITEMS.register();
        TABS.register();
    }

    //
    // I don't know why it's not work. 
    // Maybe 1.20 break it.
    //
    // public static final Registrar<BlockEntityType<?>> BLOCK_ENTITIES =
    // ModRegistries.MANAGER.get().get(Registries.BLOCK_ENTITY_TYPE);

}
