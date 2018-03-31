package projecthrzn.talesfromtheforge.common.events;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import projecthrzn.talesfromtheforge.common.blocks.TFTFBlocks;
import projecthrzn.talesfromtheforge.common.items.TFTFItems;
import projecthrzn.talesfromtheforge.common.tool.Tool;

import java.util.List;

import static projecthrzn.talesfromtheforge.util.TFTFUtilityMethods.tryPercentage;

@EventBusSubscriber
public class OreSmashingHandler {
    @SubscribeEvent
    public static void blockHarvested(BlockEvent.HarvestDropsEvent event){
        List drops = event.getDrops();
        EntityPlayer player = event.getHarvester();
        EnumHand hand = player.getActiveHand();
        Item heldItem = player.getHeldItem(hand).getItem();
        Block block = event.getState().getBlock();
        int fortune = event.getFortuneLevel();

        if (block == TFTFBlocks.oreCassiterite){
            if (heldItem == TFTFItems.HAMMER){
                ItemStack cassiteriteROL = new ItemStack(TFTFItems.rawOreLumpCasserite);
                drops.add(cassiteriteROL);
                drops.add(cassiteriteROL);
                drops.add(cassiteriteROL);
                if (fortune >= 1){
                    drops.add(cassiteriteROL);
                    if (fortune >= 1 && tryPercentage(0.25D)){
                        drops.add(cassiteriteROL);
                    }
                    if (fortune >= 2 && tryPercentage(0.15D)){
                        drops.add(cassiteriteROL);
                    }
                    if (fortune == 3 && tryPercentage(0.10D)){
                        drops.add(cassiteriteROL);
                    }
                }
            }
        }

        if (block == TFTFBlocks.oreChalcopyrite){
            if (heldItem == TFTFItems.HAMMER){
                ItemStack chalcopyriteROL = new ItemStack(TFTFItems.rawOreLumpChalcopyrite);
                drops.add(chalcopyriteROL);
                drops.add(chalcopyriteROL);
                drops.add(chalcopyriteROL);
                if (fortune >= 1){
                    drops.add(chalcopyriteROL);
                    if (fortune >= 1 && tryPercentage(0.25D)){
                        drops.add(chalcopyriteROL);
                    }
                    if (fortune >= 2 && tryPercentage(0.15D)){
                        drops.add(chalcopyriteROL);
                    }
                    if (fortune == 3 && tryPercentage(0.10D)){
                        drops.add(chalcopyriteROL);
                    }
                }
            }
        }

        if (block == TFTFBlocks.oreDigenite){
            if (heldItem == TFTFItems.HAMMER){
                ItemStack digeniteROL = new ItemStack(TFTFItems.rawOreLumpDigenite);
                drops.add(digeniteROL);
                drops.add(digeniteROL);
                drops.add(digeniteROL);
                if (fortune >= 1){
                    drops.add(digeniteROL);
                    if (fortune >= 1 && tryPercentage(0.25D)){
                        drops.add(digeniteROL);
                    }
                    if (fortune >= 2 && tryPercentage(0.15D)){
                        drops.add(digeniteROL);
                    }
                    if (fortune == 3 && tryPercentage(0.10D)){
                        drops.add(digeniteROL);
                    }
                }
            }
        }

        if (block == TFTFBlocks.oreGalena){
            if (heldItem == TFTFItems.HAMMER){
                ItemStack galenaROL = new ItemStack(TFTFItems.rawOreLumpGalena);
                drops.add(galenaROL);
                drops.add(galenaROL);
                drops.add(galenaROL);
                if (fortune >= 1){
                    drops.add(galenaROL);
                    if (fortune >= 1 && tryPercentage(0.25D)){
                        drops.add(galenaROL);
                    }
                    if (fortune >= 2 && tryPercentage(0.15D)){
                        drops.add(galenaROL);
                    }
                    if (fortune == 3 && tryPercentage(0.10D)){
                        drops.add(galenaROL);
                    }
                }
            }
        }

        if (block == TFTFBlocks.oreSphalerite){
            if (heldItem == TFTFItems.HAMMER){
                ItemStack sphaleriteROL = new ItemStack(TFTFItems.rawOreLumpSphalerite);
                drops.add(sphaleriteROL);
                drops.add(sphaleriteROL);
                drops.add(sphaleriteROL);
                if (fortune >= 1){
                    drops.add(sphaleriteROL);
                    if (fortune >= 1 && tryPercentage(0.25D)){
                        drops.add(sphaleriteROL);
                    }
                    if (fortune >= 2 && tryPercentage(0.15D)){
                        drops.add(sphaleriteROL);
                    }
                    if (fortune == 3 && tryPercentage(0.10D)){
                        drops.add(sphaleriteROL);
                    }
                }
            }
        }
    }
}
