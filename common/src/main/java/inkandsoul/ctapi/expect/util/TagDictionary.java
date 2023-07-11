package inkandsoul.ctapi.expect.util;

import dev.architectury.event.Event;
import dev.architectury.event.EventFactory;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.Holder;
import net.minecraft.tags.TagKey;

import java.util.List;
import java.util.Map;

public class TagDictionary {

    /**
     * <p>Add tags.</p>
     * <p>Provide the Vanilla registry in Fabric!</p>
     * <p>Provide the Forge registry in Forge!</p>
     * @param reg Registry
     * @param tag Tag
     * @param items Anything
     * @return Items
     * @param <T> Type
     */
    @ExpectPlatform
    public static <T> T[] addTag(Iterable<T> reg, TagKey<T> tag, T[] items) {
        throw new AssertionError();
    }

//    public static <T> T[] addTag(Registry<T> reg, TagKey<T> tag, T[] items) {
//        reg.bindTags();
//        return items;
//    }

    /**
     * Call on {@code Registry.bindTags()} was fired.
     */
    interface TagsAdditionEvent {
        Event<TagsAdditionEvent> EVENT = EventFactory.createEventResult(new TagsAdditionEvent[0]);
        <T> void addTag(Map<TagKey<T>, List<Holder<T>>> map);
    }
}
