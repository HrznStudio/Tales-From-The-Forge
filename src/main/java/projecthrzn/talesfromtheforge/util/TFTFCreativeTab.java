package projecthrzn.talesfromtheforge.util;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class TFTFCreativeTab extends CreativeTabs {

    public TFTFCreativeTab() {
        super(TFTFConstants.MODID);
        setBackgroundImageName("item_search.png");
    }

    @Override
    public boolean hasSearchBar() {
        return true;
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(Blocks.ANVIL);
    }
}
