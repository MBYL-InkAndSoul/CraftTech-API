package inkandsoul.ctapi.block;

import dev.architectury.event.Event;
import dev.architectury.event.EventFactory;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.AbstractGlassBlock;
import net.minecraft.world.level.block.Block;

/**
 * 用於處理特殊情況
 */
public interface EasilyBreak {
    Event<EasilyBreak> EVENT = EventFactory.createEventResult(EasilyBreak.class);

    boolean applyHardcoreBreak(Block block);
}

class DefaultBreak {
    static{
        // 原木
        EasilyBreak.EVENT.register(
            block->!block.defaultBlockState().is(BlockTags.LOGS)
        );
        // 玻璃
        EasilyBreak.EVENT.register(
            AbstractGlassBlock.class::isInstance
        );
        // 易碎
        EasilyBreak.EVENT.register(
            block->block.defaultBlockState().is(BaseBlockTags.FRAGILE)
        );
        // 堅固
        // 
        // EasilyBreak.EVENT.register(
        //     block->block.defaultBlockState().is(BaseBlockTags.FRAGILE)
        // );
    }
}