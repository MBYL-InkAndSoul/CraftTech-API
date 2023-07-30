package inkandsoul.ctapi.main.common.both.registry.event;

import dev.architectury.event.Event;
import dev.architectury.event.EventFactory;

@FunctionalInterface
public interface SRegisterEvent {
    Event<SRegisterEvent> EVENT = EventFactory.createEventResult(SRegisterEvent.class);

    void onRegister();
}
