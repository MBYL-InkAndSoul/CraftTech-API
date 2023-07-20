package inkandsoul.ctapi.main.common.both.block;

import inkandsoul.ctapi.CT_API;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public final class BaseBlockTags {

    // Fragile
    public static final TagKey<Block> FRAGILE = create("fragile");
    public static final TagKey<Block> HARD = create("hard");
    public static final TagKey<Block> AIRTIGHT = create("airtight");

    private BaseBlockTags(){}

    private static TagKey<Block> create(String string) {
        return TagKey.create(Registries.BLOCK, CT_API.LOC.of(string));
    }
}
