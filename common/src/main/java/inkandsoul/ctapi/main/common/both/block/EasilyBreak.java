package inkandsoul.ctapi.main.common.both.block;

import dev.architectury.event.Event;
import dev.architectury.event.EventFactory;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.AbstractGlassBlock;
import net.minecraft.world.level.block.Block;

/**
 * 用於處理特殊情況
 */
@FunctionalInterface
public interface EasilyBreak {
    Event<EasilyBreak> EVENT = EventFactory.createEventResult(EasilyBreak.class);

    boolean applyHardcoreBreak(Block block);

}