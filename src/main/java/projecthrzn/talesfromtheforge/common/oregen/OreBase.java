package projecthrzn.talesfromtheforge.common.oregen;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.oredict.OreDictionary;
import projecthrzn.talesfromtheforge.common.blocks.BlockBase;
import projecthrzn.talesfromtheforge.util.TFTFUtilityMethods;

import static projecthrzn.talesfromtheforge.util.TFTFUtilityMethods.tryPercentage;

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
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        super.getDrops(drops, world, pos, state, fortune);
    }

    @Override
    public OreBase setCreativeTab(CreativeTabs tab){
        super.setCreativeTab(tab);
        return this;
    }
}
