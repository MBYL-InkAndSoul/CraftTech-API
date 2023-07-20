package inkandsoul.ctapi.main.common.both.data.recipe;

import com.google.common.collect.ImmutableMap;
import dev.architectury.event.Event;
import dev.architectury.event.EventFactory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.HashMap;

public interface RecipeReloadEvent {
    Event<RecipeReloadEvent> EVENT = EventFactory.createEventResult(new RecipeReloadEvent[0]);

    @SuppressWarnings("rawtypes")
    void reload(HashMap<RecipeType, ImmutableMap.Builder<ResourceLocation, Recipe<?>>> recipes);
}
