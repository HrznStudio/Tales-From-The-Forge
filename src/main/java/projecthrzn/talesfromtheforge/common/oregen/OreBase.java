package projecthrzn.talesfromtheforge.common.oregen;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.oredict.OreDictionary;
import projecthrzn.talesfromtheforge.common.blocks.BlockBase;

public class OreBase extends BlockBase {

    private String oreName;

    public OreBase(String name, String oreName) {
        super(Material.ROCK, name);
        this.oreName = oreName;
        setHardness(3f);
        setResistance(5f);
    }

    public void initOreDict(){
        OreDictionary.registerOre(oreName, this);
    }

    @Override
    public OreBase setCreativeTab(CreativeTabs tab){
        super.setCreativeTab(tab);
        return this;
    }
}
