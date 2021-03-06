package projecthrzn.talesfromtheforge.common.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class DeprecatedItemOverride extends Item {
    public DeprecatedItemOverride(Item original) {
        setUnlocalizedName(original.getUnlocalizedName().replaceFirst("item\\.", ""));
        setRegistryName(original.getRegistryName());
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(String.format("%s%sDeprecated Item", TextFormatting.BOLD, TextFormatting.RED.toString()));
    }
}