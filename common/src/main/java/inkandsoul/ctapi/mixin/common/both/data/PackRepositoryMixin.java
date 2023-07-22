package inkandsoul.ctapi.mixin.common.both.data;

import com.google.common.collect.ImmutableSet;
import inkandsoul.ctapi.main.common.both.data.BuiltInClientPack;
import net.minecraft.server.packs.repository.PackRepository;
import net.minecraft.server.packs.repository.RepositorySource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Mixin(PackRepository.class)
public class PackRepositoryMixin {

    @Redirect(method = "<init>", at = @At(value = "HEAD", target = "Lcom/google/common/collect/ImmutableSet;copyOf([Ljava/lang/Object;)Lcom/google/common/collect/ImmutableSet;"))
    private static Set<RepositorySource> instance(RepositorySource[] repositorySources) {
        List<RepositorySource> list = Arrays.asList(repositorySources);
        list.add(BuiltInClientPack.INSTANCE);
        return ImmutableSet.copyOf(list.toArray(new RepositorySource[0]));
    }
}
