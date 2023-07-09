package inkandsoul.ctapi.main.common.both.event.tag;

import dev.architectury.event.Event;
import dev.architectury.event.EventFactory;
import net.minecraft.core.Holder;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.TagManager;

import java.util.List;
import java.util.Map;

@FunctionalInterface
public interface TagLoader {
    Event<TagLoader> EVENT = EventFactory.createEventResult(new TagLoader[0]);

    <T> void onTagLoad(TagManager.LoadResult<T> loadResult, Map<TagKey<T>, List<Holder<T>>> map);
}
