package inkandsoul.ctapi.block;

import inkandsoul.ctapi.util.ResourceUtil;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public final class BaseBlockTags {

    // Fragile
    public static final TagKey<Block> FRAGILE = create("fragile");

    private BaseBlockTags(){}

    private static TagKey<Block> create(String string) {
        return TagKey.create(Registries.BLOCK, ResourceUtil.of(string));
    }
}
