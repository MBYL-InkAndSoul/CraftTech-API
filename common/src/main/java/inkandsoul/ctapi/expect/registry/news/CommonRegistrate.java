package inkandsoul.ctapi.expect.registry.news;

import com.tterrag.registrate.Registrate;
import dev.architectury.injectables.annotations.ExpectPlatform;
import org.jetbrains.annotations.NotNull;

public class CommonRegistrate extends Registrate {

    @ExpectPlatform
    @NotNull
    public static CommonRegistrate of(String modid) {
        throw new AssertionError();
    }

    protected CommonRegistrate(String modid) {
        super(modid);
    }
}
