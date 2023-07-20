package inkandsoul.ctapi.main.common.both.data.tag;

import inkandsoul.ctapi.mixin.common.both.accessors.NamedAccessor;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unchecked")
public class TagUtil {

    public static <T> void add(Registry<T> reg, TagKey<T> tag, T[] things) {
        add(reg, tag, Arrays.asList(things));
    }

    /**
     * <p>Add something to tag.</p>
     * <p>If you need to replace the binds of tag.</p>
     * <p>Please use {@link TagUtil#bind(Registry, TagKey, List)}.</p>
     * @param reg Registry
     * @param tag Tag
     * @param things Things
     * @param <T> Type
     */
    public static <T> void add(Registry<T> reg, TagKey<T> tag, List<T> things) {
        List<Holder<T>> list = getHolders(reg, things);
        list.addAll(((NamedAccessor<T>)reg.getOrCreateTag(tag)).getContents());

        rawBind(reg, tag, list);
    }

    public static <T> void addTag(Registry<T> reg, TagKey<T> tag, TagKey<T> things) {
        List<Holder<T>> list = new ArrayList<>(((NamedAccessor<T>)reg.getOrCreateTag(things)).getContents());
        list.addAll(((NamedAccessor<T>)reg.getOrCreateTag(tag)).getContents());

        rawBind(reg, tag, list);
    }

    public static <T> void rawAdd(Registry<T> reg, TagKey<T> tag, List<Holder<T>> things) {
        List<Holder<T>> list = new ArrayList<>(things);
        list.addAll(((NamedAccessor<T>)reg.getOrCreateTag(tag)).getContents());

        rawBind(reg, tag, list);
    }

    /**
     * Array version {@link TagUtil#rawBind(Registry, TagKey, List)}
     */
    public static <T> void bind(Registry<T> reg, TagKey<T> tag, T[] things) {
        bind(reg, tag, Arrays.asList(things));
    }

    /**
     * <p>Bind a tag with something.</p>
     * <p>Will replace original binds!</p>
     * @param <T>    Type
     * @param reg    Registry
     * @param tag    Tag
     * @param things Things
     */
    public static <T> void bind(Registry<T> reg, TagKey<T> tag, List<T> things) {
        List<Holder<T>> list = getHolders(reg, things);

        rawBind(reg, tag, list);
    }

    @NotNull
    private static <T> List<Holder<T>> getHolders(Registry<T> reg, List<T> things) {
        return new ArrayList<>(things.stream()
            .map(t -> (Holder<T>) (reg.getHolder(reg.getResourceKey(t).orElseThrow()).orElseThrow())).toList());
    }

    public static <T> void rawBind(Registry<T> reg, TagKey<T> tag, List<Holder<T>> list) {
        ((NamedAccessor<T>) reg.getOrCreateTag(tag)).bindTags(list);
    }

}
