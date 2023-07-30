package inkandsoul.ctapi.main.common.both.block.hooks;

import net.minecraft.nbt.CompoundTag;

public interface CT_BlockEntity {

    default CompoundTag ct$saveMeta(CompoundTag nbt){
        return nbt;
    }

    default CompoundTag ct$saveMetadataWithNoPos(CompoundTag nbt){
        return nbt;
    }
}
