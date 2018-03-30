package projecthrzn.talesfromtheforge;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import projecthrzn.talesfromtheforge.util.TFTFConstants;

@Mod(modid = TFTFConstants.MODID, name = TFTFConstants.NAME, version = TFTFConstants.VERSION, dependencies = TFTFConstants.DEPS, acceptedMinecraftVersions = TFTFConstants.MCVERS)
public class TalesFromTheForge {
    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    }
}
