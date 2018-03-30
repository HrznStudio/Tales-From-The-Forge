package projecthrzn.talesfromtheforge.common;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Level;

import static projecthrzn.talesfromtheforge.TalesFromTheForge.logger;

public class CommonProxy {

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event){

    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){

    }

    public void preInit(FMLPreInitializationEvent e){
        logger.log(Level.INFO, "TFTF: Is Loading During Pre-Init");
    }

    public void Init(FMLInitializationEvent e) {
        logger.log(Level.INFO, "TFTF: Is Loading During Init");
    }

    public void postInit(FMLPostInitializationEvent e){
        logger.log(Level.INFO, "TFTF: Is Loading During Post-Init");
    }

    public void serverStart(FMLServerStartingEvent e){
        logger.log(Level.INFO, "TFTF: Is Loading During Server Start");
    }
}
