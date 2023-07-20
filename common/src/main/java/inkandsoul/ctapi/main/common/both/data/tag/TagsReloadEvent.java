package inkandsoul.ctapi.main.common.both.data.tag;

import dev.architectury.event.Event;
import dev.architectury.event.EventFactory;
import net.minecraft.core.RegistryAccess;

/**
 * Will be called on tag reload.
 */
@FunctionalInterface
public interface TagsReloadEvent {
    Event<TagsReloadEvent> EVENT = EventFactory.createEventResult(TagsReloadEvent.class);

    void reload(RegistryAccess registryAccess);
}
