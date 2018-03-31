package projecthrzn.talesfromtheforge.common.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import projecthrzn.talesfromtheforge.TalesFromTheForge;
import projecthrzn.talesfromtheforge.common.GripType;
import projecthrzn.talesfromtheforge.util.TFTFConstants;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class ItemGrip extends Item {
    private final String name;

    public ItemGrip(String name) {
        this.name = name;
        setHasSubtypes(true);
        setUnlocalizedName(TFTFConstants.MODID + "." + name);
        setRegistryName(name);
        setCreativeTab(TalesFromTheForge.TAB);
    }

    @Override
    public int getMetadata(ItemStack stack) {
        return getGripType(stack).meta();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (isInCreativeTab(tab)) {
            for (GripType material : GripType.values()) {
                for (EnumRarity rarity : EnumRarity.values()) {
                    items.add(createStack(
                            material,
                            1,
                            rarity
                    ));
                }
            }
        }
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return getStackRarity(stack);
    }

    private ItemStack createStack(GripType material, int amount, EnumRarity rarity) {
        ItemStack stack = new ItemStack(this, amount);
        NBTTagCompound compound = getStackTag(stack);
        compound.setInteger("grip", material.meta());
        compound.setInteger("rarity", rarity.ordinal());
        return stack;
    }

    private EnumRarity getStackRarity(ItemStack stack) {
        NBTTagCompound tag = getStackTag(stack);
        if (!tag.hasKey("rarity", Constants.NBT.TAG_INT)) {
            tag.setInteger("rarity", 0);
        }
        return EnumRarity.values()[tag.getInteger("rarity")];
    }

    private GripType getGripType(ItemStack stack) {
        NBTTagCompound tag = getStackTag(stack);
        if (!tag.hasKey("grip", Constants.NBT.TAG_INT)) {
            tag.setInteger("grip", 0);
        }
        return GripType.ofKey(tag.getInteger("grip"));
    }

    @Nonnull
    private NBTTagCompound getStackTag(ItemStack stack) {
        NBTTagCompound tag = stack.getTagCompound();
        if (tag == null) {
            tag = new NBTTagCompound();
            stack.setTagCompound(tag);
        }
        return tag;
    }
}