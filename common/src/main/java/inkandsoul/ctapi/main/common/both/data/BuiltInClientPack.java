package inkandsoul.ctapi.main.common.both.data;

import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.RepositorySource;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

@ParametersAreNonnullByDefault
public class BuiltInClientPack implements RepositorySource {

    public static final BuiltInClientPack INSTANCE = new BuiltInClientPack();

    @Override
    public void loadPacks(Consumer<Pack> consumer) {

    }
}
