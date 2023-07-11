package inkandsoul.ctapi.expect.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class CommonRegistries {
    public static final CommonRegistry<Item> ITEM = new CommonRegistry<>(Registries.ITEM);
    public static final CommonRegistry<Block> BLOCK = new CommonRegistry<>(Registries.BLOCK);
    public static final CommonRegistry<BlockEntityType<?>> BLOCK_ENTITY_TYPE =
        new CommonRegistry<>(Registries.BLOCK_ENTITY_TYPE);

    public static void init() {

    }
}
