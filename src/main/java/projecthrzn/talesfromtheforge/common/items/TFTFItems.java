package projecthrzn.talesfromtheforge.common.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import projecthrzn.talesfromtheforge.common.GripType;
import projecthrzn.talesfromtheforge.common.Material;
import projecthrzn.talesfromtheforge.util.TFTFConfigs;

@Mod.EventBusSubscriber
public class TFTFItems {

    public static ItemMaterial INGOT;
    public static ItemMaterial NUGGET;
    public static ItemGrip GRIP;

    public static void preInit() {
        INGOT = new ItemMaterial("ingot");
        NUGGET = new ItemMaterial("nugget");
        GRIP = new ItemGrip("grip");
    }

    @SubscribeEvent
    public static void register(Register<Item> event) {
        event.getRegistry().registerAll(
                INGOT,
                NUGGET,
                GRIP
        );
        if (TFTFConfigs.TFTFConfig.Features.disableVanilla) {
            event.getRegistry().registerAll(
                    new DeprecatedItemOverride(Items.GOLD_INGOT),
                    new DeprecatedItemOverride(Items.IRON_INGOT),

                    new DeprecatedItemOverride(Items.IRON_NUGGET),
                    new DeprecatedItemOverride(Items.GOLD_NUGGET),

                    new DeprecatedItemOverride(Items.WOODEN_PICKAXE),
                    new DeprecatedItemOverride(Items.DIAMOND_PICKAXE),
                    new DeprecatedItemOverride(Items.GOLDEN_PICKAXE),
                    new DeprecatedItemOverride(Items.STONE_PICKAXE),
                    new DeprecatedItemOverride(Items.IRON_PICKAXE),

                    new DeprecatedItemOverride(Items.IRON_SHOVEL),
                    new DeprecatedItemOverride(Items.WOODEN_SHOVEL),
                    new DeprecatedItemOverride(Items.GOLDEN_SHOVEL),
                    new DeprecatedItemOverride(Items.STONE_SHOVEL),
                    new DeprecatedItemOverride(Items.DIAMOND_SHOVEL),

                    new DeprecatedItemOverride(Items.IRON_AXE),
                    new DeprecatedItemOverride(Items.WOODEN_AXE),
                    new DeprecatedItemOverride(Items.GOLDEN_AXE),
                    new DeprecatedItemOverride(Items.STONE_AXE),
                    new DeprecatedItemOverride(Items.DIAMOND_AXE),

                    new DeprecatedItemOverride(Items.IRON_HOE),
                    new DeprecatedItemOverride(Items.WOODEN_HOE),
                    new DeprecatedItemOverride(Items.GOLDEN_HOE),
                    new DeprecatedItemOverride(Items.STONE_HOE),
                    new DeprecatedItemOverride(Items.DIAMOND_HOE),

                    new DeprecatedItemOverride(Items.IRON_SWORD),
                    new DeprecatedItemOverride(Items.WOODEN_SWORD),
                    new DeprecatedItemOverride(Items.GOLDEN_SWORD),
                    new DeprecatedItemOverride(Items.STONE_SWORD),
                    new DeprecatedItemOverride(Items.DIAMOND_SWORD)
            );
        }
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        for (Material material : Material.ENABLED) {
            ModelLoader.setCustomModelResourceLocation(INGOT, material.meta(),
                    new ModelResourceLocation(
                            INGOT.getRegistryName().toString(),
                            "type=" + material.getName()
                    )
            );
            ModelLoader.setCustomModelResourceLocation(NUGGET, material.meta(),
                    new ModelResourceLocation(
                            NUGGET.getRegistryName().toString(),
                            "type=" + material.getName()
                    )
            );
        }
        for (GripType material : GripType.ENABLED) {
            ModelLoader.setCustomModelResourceLocation(GRIP, material.meta(),
                    new ModelResourceLocation(
                            GRIP.getRegistryName().toString(),
                            "type=" + material.getName()
                    )
            );
        }
    }
}