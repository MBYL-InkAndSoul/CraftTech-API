package inkandsoul.ctapi.main.common.both.block.event;

import dev.architectury.event.Event;
import dev.architectury.event.EventFactory;
import net.minecraft.world.level.block.Block;

/**
 * 用於處理特殊情況
 */
@FunctionalInterface
public interface EasilyBreak {
    Event<EasilyBreak> EVENT = EventFactory.createEventResult(new EasilyBreak[0]);

    boolean applyHardcoreBreak(Block block);

}