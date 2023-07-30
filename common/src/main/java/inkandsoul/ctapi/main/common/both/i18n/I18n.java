package inkandsoul.ctapi.main.common.both.i18n;

import com.google.common.collect.ImmutableMap;
import dev.architectury.event.Event;
import dev.architectury.event.EventFactory;
import net.minecraft.network.chat.Component;

/**
 * <p>Vanilla i18n is client-only.</p>
 * <p>But it isn't.</p>
 */
public class I18n {

    @FunctionalInterface
    public interface LanguageReloadEvent {
        Event<LanguageReloadEvent> EVENT = EventFactory.createEventResult(LanguageReloadEvent.class);

        void onReload();
    }

    public static ImmutableMap<String, Component> TEXTS;
    private static final ImmutableMap.Builder<String, Component> BUILDER = new ImmutableMap.Builder<>();

    public static void postInit() {
        LanguageReloadEvent.EVENT.invoker().onReload();
        TEXTS = BUILDER.build();
    }

    public static Component get(String key) {
        return TEXTS.getOrDefault(key, Component.literal(key));
    }

    public static void add(String key, Component text) {
        BUILDER.put(key, text);
    }
}
