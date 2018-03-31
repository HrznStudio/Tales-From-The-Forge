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
import projecthrzn.talesfromtheforge.common.MaterialRegistry;
import projecthrzn.talesfromtheforge.common.tool.MaterialItem;
import projecthrzn.talesfromtheforge.common.tool.Part;
import projecthrzn.talesfromtheforge.common.tool.Tool;
import projecthrzn.talesfromtheforge.util.Amounts;
import projecthrzn.talesfromtheforge.util.TFTFConfigs;

@Mod.EventBusSubscriber
public class TFTFItems {

    public static MaterialItem INGOT;
    public static MaterialItem NUGGET;
    public static ItemGrip GRIP;

    public static Part PICK_HEAD;
    public static Part SHOVEL_HEAD;
    public static Part AXE_HEAD;
    public static Part SWORD_BLADE;

    public static Tool PICKAXE;
    public static Tool SHOVEL;
    public static Tool AXE;
    public static Tool SWORD;

    public static void preInit() {
        INGOT = new MaterialItem("ingot");
        NUGGET = new MaterialItem("nugget");
        GRIP = new ItemGrip("grip");

        PICK_HEAD = new Part("pick_head", Amounts.INGOT.getAmount(3));
        SHOVEL_HEAD = new Part("shovel_head", Amounts.INGOT.getAmount(2));
        AXE_HEAD = new Part("axe_head", Amounts.INGOT.getAmount(3));
        SWORD_BLADE = new Part("sword_blade", Amounts.INGOT.getAmount(3));

        PICKAXE = new Tool("pickaxe", PICK_HEAD);
        SHOVEL = new Tool("shovel", SHOVEL_HEAD);
        AXE = new Tool("axe", AXE_HEAD);
        SWORD = new Tool("sword", SWORD_BLADE);
    }

    @SubscribeEvent
    public static void register(Register<Item> event) {
        event.getRegistry().registerAll(
                INGOT,
                NUGGET,
                GRIP,

                PICK_HEAD,
                SHOVEL_HEAD,
                AXE_HEAD,
                SWORD_BLADE,

                PICKAXE,
                SHOVEL,
                AXE,
                SWORD
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
                    new DeprecatedItemOverride(Items.DIAMOND_SWORD),

                    new DeprecatedItemOverride(Items.IRON_HELMET),
                    new DeprecatedItemOverride(Items.GOLDEN_HELMET),
                    new DeprecatedItemOverride(Items.CHAINMAIL_HELMET),
                    new DeprecatedItemOverride(Items.DIAMOND_HELMET),
                    new DeprecatedItemOverride(Items.LEATHER_HELMET),

                    new DeprecatedItemOverride(Items.IRON_CHESTPLATE),
                    new DeprecatedItemOverride(Items.GOLDEN_CHESTPLATE),
                    new DeprecatedItemOverride(Items.CHAINMAIL_CHESTPLATE),
                    new DeprecatedItemOverride(Items.DIAMOND_CHESTPLATE),
                    new DeprecatedItemOverride(Items.LEATHER_CHESTPLATE),

                    new DeprecatedItemOverride(Items.IRON_LEGGINGS),
                    new DeprecatedItemOverride(Items.GOLDEN_LEGGINGS),
                    new DeprecatedItemOverride(Items.CHAINMAIL_LEGGINGS),
                    new DeprecatedItemOverride(Items.DIAMOND_LEGGINGS),
                    new DeprecatedItemOverride(Items.LEATHER_LEGGINGS),

                    new DeprecatedItemOverride(Items.IRON_BOOTS),
                    new DeprecatedItemOverride(Items.GOLDEN_BOOTS),
                    new DeprecatedItemOverride(Items.CHAINMAIL_BOOTS),
                    new DeprecatedItemOverride(Items.DIAMOND_BOOTS),
                    new DeprecatedItemOverride(Items.LEATHER_BOOTS)
            );
        }
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        for (Material material : MaterialRegistry.getAllMaterials()) {
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