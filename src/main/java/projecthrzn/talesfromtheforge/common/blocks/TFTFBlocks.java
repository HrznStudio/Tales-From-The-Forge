package projecthrzn.talesfromtheforge.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import projecthrzn.talesfromtheforge.TalesFromTheForge;
import projecthrzn.talesfromtheforge.common.oregen.OreBase;

public class TFTFBlocks {
    public static CreativeTabs tab = TalesFromTheForge.TAB;

    public static OreBase oreCassiterite = new OreBase("ore_cassiterite", "oreCassiterite").setCreativeTab(tab);
    public static OreBase oreChalcopyrite = new OreBase("ore_chalcopyrite", "oreChalcopyrite").setCreativeTab(tab);
    public static OreBase oreDigenite = new OreBase("ore_digenite", "oreDigenite").setCreativeTab(tab);
    public static OreBase oreGalena = new OreBase("ore_galena", "oreGalena").setCreativeTab(tab);
    public static OreBase oreSphalerite = new OreBase("ore_sphalerite", "oreSphalerite").setCreativeTab(tab);

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        oreCassiterite.initModel();
        oreChalcopyrite.initModel();
        oreDigenite.initModel();
        oreGalena.initModel();
        oreSphalerite.initModel();
    }

    public static void register(IForgeRegistry<Block> registry) {
        registry.register(oreCassiterite);
        registry.register(oreChalcopyrite);
        registry.register(oreDigenite);
        registry.register(oreGalena);
        registry.register(oreSphalerite);
    }

    public static void regsiterItemBlocks(IForgeRegistry<Item> registry) {
        registry.register(oreCassiterite.createItemBlock());
        registry.register(oreChalcopyrite.createItemBlock());
        registry.register(oreDigenite.createItemBlock());
        registry.register(oreGalena.createItemBlock());
        registry.register(oreSphalerite.createItemBlock());
    }
}
