package projecthrzn.talesfromtheforge.util;

import net.minecraftforge.common.config.Config;
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

        }

        public static class Modules {

        }

        public static class Features {

        }

        public static class Compat {

        }
    }
}
