package inkandsoul.ctapi.expect.util.forge;

import com.google.common.collect.Lists;
import net.minecraft.tags.TagKey;
import net.minecraftforge.registries.ForgeRegistry;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TagDictionaryImpl {


    public static <T> T[] addTag(Iterable<T> reg, TagKey<T> tag, T[] items) {
        Stream<Supplier<T>> items2 = Lists.newArrayList(items).stream().map(i-> {
            return () -> i;
        });

        Objects.requireNonNull(((IForgeRegistry<T>)reg).tags())
            .addOptionalTagDefaults(tag, items2.collect(Collectors.toSet()));

        return items;
    }

}
