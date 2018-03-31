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
            public static boolean potteryNYI = true;

            @Comment("[Default: True]: Should 'Ore Smashing' be enabled?")
            public static boolean oreSmashingNYI = true;

            @Comment("[Default: True]: Should the 'Charcoal Pit' and Charcoal-Grade mechanics be enabled?")
            public static boolean charcoalPitNYI = true;

            @Comment("[Default: True]: Should 'Bloomery and Smithery' be enabled?")
            public static boolean bloomerySmitheryNYI = true;

        }

        public static class Features {
            @Comment("[Default: True]: Should TFTF disable vanilla tools and materials")
            public static boolean disableVanilla = true;
            @Comment("[Default: True]: Should TFTF disable vanilla recipes")
            public static boolean disableVanillaRecipesNYI = true;
        }

        public static class Compat {
            @Comment("[Default: False]: 'Tinker's Construct' Support")
            public static boolean enableTinkersCompatNYI = false;
        }

        public static class OreGen {
            @Comment("[Default: True]: Should Calcopyrite Spawn?")
            public static boolean Calcopyrite = true;
            @Comment("[Default Values: MinY: 16, MaxY: 32, VeinSize: 8, Chances: 5]")
            public static int calcopyriteMinY = 16;
            public static int calcopyriteMaxY = 32;
            public static int calcopyriteVeinSize = 8;
            public static int calcopyriteChances = 5;

            @Comment("[Default: True]: Should Cassiterite Spawn?")
            public static boolean Cassiterite = true;
            @Comment("[Default Values: MinY: 16, MaxY: 32, VeinSize: 8, Chances: 5]")
            public static int cassiteriteMinY = 16;
            public static int cassiteriteMaxY = 32;
            public static int cassiteriteVeinSize = 8;
            public static int cassiteriteChances = 5;

            @Comment("[Default: True]: Should Digenite Spawn?")
            public static boolean Digenite = true;
            @Comment("[Default Values: MinY: 16, MaxY: 32, VeinSize: 8, Chances: 5]")
            public static int digeniteMinY = 16;
            public static int digeniteMaxY = 32;
            public static int digeniteVeinSize = 8;
            public static int digeniteChances = 5;

            @Comment("[Default: True]: Should Galena Spawn?")
            public static boolean Galena = true;
            @Comment("[Default Values: MinY: 16, MaxY: 32, VeinSize: 8, Chances: 5]")
            public static int galenaMinY = 16;
            public static int galenaMaxY = 32;
            public static int galenaVeinSize = 8;
            public static int galenaChances = 5;

            @Comment("[Default: True]: Should Sphalerite Spawn?")
            public static boolean Sphalerite = true;
            @Comment("[Default Values: MinY: 16, MaxY: 32, VeinSize: 8, Chances: 5]")
            public static int sphaleriteMinY = 16;
            public static int sphaleriteMaxY = 32;
            public static int sphaleriteVeinSize = 8;
            public static int sphaleriteChances = 5;
        }
    }
}