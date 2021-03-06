package projecthrzn.talesfromtheforge.client;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.logging.log4j.Level;
import projecthrzn.talesfromtheforge.common.CommonProxy;
import projecthrzn.talesfromtheforge.common.blocks.TFTFBlocks;
import projecthrzn.talesfromtheforge.common.items.TFTFItems;
import projecthrzn.talesfromtheforge.util.TFTFConfigs.TFTFConfig;
import projecthrzn.talesfromtheforge.util.TFTFConstants;

import static projecthrzn.talesfromtheforge.TalesFromTheForge.logger;

@EventBusSubscriber(value = Side.CLIENT, modid = TFTFConstants.MODID)
public class ClientProxy extends CommonProxy {
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        if (TFTFConfig.Debug.debug) {
            logger.log(Level.DEBUG, "TFTF: Is Loading Models");
        }
        TFTFItems.initModels();
        TFTFBlocks.initModels();
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }
}
