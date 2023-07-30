package inkandsoul.ctapi;

import net.minecraftforge.common.ForgeConfigSpec;

public class CT_API_Config {

    public static class Common {
        private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

        public static final ForgeConfigSpec.BooleanValue HARDCORE_BREAK = BUILDER
            .comment("Disable break most block by wrong tools.")
            .comment("(Example: You can't break stone by hand.)")
            .define("hardcoreBreak", true);

        public static final ForgeConfigSpec SPEC = BUILDER.build();
    }

    public static class Server {
        private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

        public static final ForgeConfigSpec SPEC = BUILDER.build();
    }

    public static class Client {
        private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

        public static final ForgeConfigSpec SPEC = BUILDER.build();
    }
}
