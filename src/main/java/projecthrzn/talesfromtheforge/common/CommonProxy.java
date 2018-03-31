package projecthrzn.talesfromtheforge.common;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Level;
import projecthrzn.talesfromtheforge.common.blocks.TFTFBlocks;
import projecthrzn.talesfromtheforge.common.oregen.TFTFOreGeneration;
import projecthrzn.talesfromtheforge.util.TFTFConfigs.TFTFConfig;

import static projecthrzn.talesfromtheforge.TalesFromTheForge.logger;
import static projecthrzn.talesfromtheforge.common.blocks.TFTFBlocks.*;

public class CommonProxy {

    @EventBusSubscriber
    public static class RegistrationHandling {
        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            TFTFBlocks.register(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            TFTFBlocks.regsiterItemBlocks(event.getRegistry());
        }
    }


    public void preInit(FMLPreInitializationEvent e) {
        if (TFTFConfig.Debug.debug) {
            logger.log(Level.DEBUG, "TFTF: Is Loading During Pre-Init");
        }
        GameRegistry.registerWorldGenerator(new TFTFOreGeneration(), 3);
    }

    public void Init(FMLInitializationEvent e) {
        if (TFTFConfig.Debug.debug) {
            logger.log(Level.DEBUG, "TFTF: Is Loading During Init");
        }
        oreCassiterite.initOreDict();
        oreChalcopyrite.initOreDict();
        oreDigenite.initOreDict();
        oreGalena.initOreDict();
        oreSphalerite.initOreDict();
    }

    public void postInit(FMLPostInitializationEvent e) {
        if (TFTFConfig.Debug.debug) {
            logger.log(Level.DEBUG, "TFTF: Is Loading During Post-Init");
        }
    }

    public void serverStart(FMLServerStartingEvent e) {
        if (TFTFConfig.Debug.debug) {
            logger.log(Level.DEBUG, "TFTF: Is Loading During Server Start");
        }
    }
}
