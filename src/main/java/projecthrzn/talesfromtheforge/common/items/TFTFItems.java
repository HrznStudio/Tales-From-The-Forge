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
import projecthrzn.talesfromtheforge.common.Material;
import projecthrzn.talesfromtheforge.common.MaterialRegistry;
import projecthrzn.talesfromtheforge.common.tool.MaterialItem;
import projecthrzn.talesfromtheforge.common.tool.Part;
import projecthrzn.talesfromtheforge.common.tool.Tool;
import projecthrzn.talesfromtheforge.util.Amounts;
import projecthrzn.talesfromtheforge.util.TFTFConfigs;
import projecthrzn.talesfromtheforge.util.TFTFConfigs.TFTFConfig;

@Mod.EventBusSubscriber
public class TFTFItems {

    public static ItemBase rawOreLumpCasserite = new ItemBase("rawOreLump_Casserite");
    public static ItemBase rawOreLumpChalcopyrite = new ItemBase("rawOreLump_Chalcopyrite");
    public static ItemBase rawOreLumpDigenite = new ItemBase("rawOreLump_Digenite");
    public static ItemBase rawOreLumpGalena = new ItemBase("rawOreLump_Galena");
    public static ItemBase rawOreLumpSphalerite = new ItemBase("rawOreLump_Sphalerite");

    public static MaterialItem INGOT;
    public static MaterialItem NUGGET;

    public static Part PICK_HEAD;
    public static Part SHOVEL_HEAD;
    public static Part AXE_HEAD;
    public static Part SHORT_BLADE;
    public static Part LONG_BLADE;
    public static Part HAMMER_HEAD;
    public static Part LARGE_HAMMER_HEAD;
    public static Part ONE_HANDED_GUARD;
    public static Part TWO_HANDED_GUARD;
    public static Part ONE_HANDED_GRIP;
    public static Part TWO_HANDED_GRIP;

    public static Tool PICKAXE;
    public static Tool SHOVEL;
    public static Tool AXE;
    public static Tool DAGGER;
    public static Tool LONGSWORD;
    public static Tool HAMMER;
    public static Tool GREAT_HAMMER;

    public static void preInit() {
        INGOT = new MaterialItem("ingot");
        NUGGET = new MaterialItem("nugget");

        PICK_HEAD = new Part("pick_head", Amounts.INGOT.getAmount(3));
        SHOVEL_HEAD = new Part("shovel_head", Amounts.INGOT.getAmount(2));
        AXE_HEAD = new Part("axe_head", Amounts.INGOT.getAmount(3));
        SHORT_BLADE = new Part("short_blade", Amounts.INGOT.getAmount(1));
        LONG_BLADE = new Part("long_blade", Amounts.INGOT.getAmount(2));
        HAMMER_HEAD = new Part("hammer_head", Amounts.INGOT.getAmount(2));
        ONE_HANDED_GUARD = new Part("one_handed_guard", Amounts.INGOT.getAmount(1));
        TWO_HANDED_GUARD = new Part("two_handed_guard", Amounts.INGOT.getAmount(1));
        ONE_HANDED_GRIP = new PartGrip("one_handed_grip", Amounts.INGOT.getAmount(2));
        TWO_HANDED_GRIP = new PartGrip("two_handed_grip", Amounts.INGOT.getAmount(3));
        LARGE_HAMMER_HEAD = new PartGrip("large_hammer_head", Amounts.INGOT.getAmount(4));

        PICKAXE = new Tool("pickaxe", PICK_HEAD, TWO_HANDED_GRIP);
        SHOVEL = new Tool("shovel", SHOVEL_HEAD, TWO_HANDED_GRIP);
        AXE = new Tool("axe", AXE_HEAD, TWO_HANDED_GRIP);
        DAGGER = new Tool("dagger", LONG_BLADE, ONE_HANDED_GUARD, ONE_HANDED_GRIP);
        LONGSWORD = new Tool("longsword", LONG_BLADE, TWO_HANDED_GUARD, TWO_HANDED_GRIP);
        HAMMER = new Tool("hammer", HAMMER_HEAD, ONE_HANDED_GRIP);
        GREAT_HAMMER = new Tool("great_hammer", LARGE_HAMMER_HEAD, TWO_HANDED_GRIP);
    }

    @SubscribeEvent
    public static void register(Register<Item> event) {
        event.getRegistry().registerAll(
                INGOT,
                NUGGET,

                PICK_HEAD,
                SHOVEL_HEAD,
                AXE_HEAD,
                LONG_BLADE,
                SHORT_BLADE,
                ONE_HANDED_GUARD,
                TWO_HANDED_GUARD,
                ONE_HANDED_GRIP,
                TWO_HANDED_GRIP,
                HAMMER_HEAD,
                LARGE_HAMMER_HEAD,

                PICKAXE,
                SHOVEL,
                AXE,
                DAGGER,
                LONGSWORD,
                HAMMER,
                GREAT_HAMMER
        );

        if (TFTFConfig.OreGen.Cassiterite.shouldGenerate){
            event.getRegistry().register(rawOreLumpCasserite);
        }

        if (TFTFConfig.OreGen.Chalcopyrite.shouldGenerate){
            event.getRegistry().register(rawOreLumpChalcopyrite);
        }

        if (TFTFConfig.OreGen.Digenite.shouldGenerate){
            event.getRegistry().register(rawOreLumpDigenite);
        }

        if (TFTFConfig.OreGen.Galena.shouldGenerate) {
            event.getRegistry().register(rawOreLumpGalena);
        }

        if (TFTFConfig.OreGen.Sphalerite.shouldGenerate) {
            event.getRegistry().register(rawOreLumpSphalerite);
        }

        if (TFTFConfig.Features.disableVanilla) {
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
    }
}