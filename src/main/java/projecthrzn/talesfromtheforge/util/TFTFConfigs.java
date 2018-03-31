package projecthrzn.talesfromtheforge.util;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.RangeInt;
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
        public static OreGen oreGen;

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
            @Config.Ignore //Ignore till after modjam
            public static boolean enableTinkersCompatNYI = false;
        }

        public static class OreGen {

            public static Generation Chalcopyrite = new Generation();
            public static Generation Cassiterite = new Generation();
            public static Generation Digenite = new Generation();
            public static Generation Galena = new Generation();
            public static Generation Sphalerite = new Generation();

            public static class Generation {
                @Comment("[Default: True]: Should this ore Spawn?")
                public boolean shouldGenerate = true;
                @Comment("[Default: 16]: Minimum Y level")
                @RangeInt(min = 0, max = 255)
                public int minY = 16;
                @Comment("[Default: 32]: Maximum Y level")
                @RangeInt(min = 0, max = 255)
                public int maxY = 32;
                @Comment("[Default: 8]")
                public int veinSize = 8;
                @Comment("[Default: 5]")
                public int Chance = 5;
            }
        }
    }
}