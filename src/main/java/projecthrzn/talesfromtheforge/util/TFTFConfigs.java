package projecthrzn.talesfromtheforge.util;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

public class TFTFConfigs {
    public static void postInit(FMLPostInitializationEvent event) {
    }

    @Config(modid = TFTFConstants.MODID)
    public static class TFTFConfig {
        public static Debug debug;
        public static Modules modules;
        public static Features features;
        public static Compat compat;

        public static class Debug {
            @Comment("[Default: False]: Should Debug Features Be Enabled?")
            public static boolean debug = false;
        }

        public static class Modules {
            @Comment("[Default: True]: Should 'Pottery' be enabled?")
            public static boolean pottery = true;

            @Comment("[Default: True]: Should 'Ore Smashing' be enabled?")
            public static boolean oreSmashing = true;

            @Comment("[Default: True]: Should the 'Charcoal Pit' and Charcoal-Grade mechanics be enabled?")
            public static boolean charcoalPit = true;

            @Comment("[Default: True]: Should 'Bloomery and Smithery' be enabled?")
            public static boolean bloomerySmithery = true;

        }

        public static class Features {
            @Comment("[Default: True]: Should TFTF disable vanilla tools and materials")
            public static boolean disableVanilla = true;
            @Comment("[Default: True]: Should TFTF disable vanilla recipes")
            public static boolean disableVanillaRecipes = true;
        }

        public static class Compat {

        }
    }
}