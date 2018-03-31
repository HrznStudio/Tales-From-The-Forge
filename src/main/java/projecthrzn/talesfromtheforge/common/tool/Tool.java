package projecthrzn.talesfromtheforge.common.tool;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import projecthrzn.talesfromtheforge.TalesFromTheForge;
import projecthrzn.talesfromtheforge.common.IPart;
import projecthrzn.talesfromtheforge.common.MaterialRegistry;
import projecthrzn.talesfromtheforge.util.TFTFConstants;
import projecthrzn.talesfromtheforge.util.Tags;

import javax.annotation.Nullable;
import java.util.List;

public class Tool extends Item {
    protected String name;
    protected IPart[] parts;

    public Tool(String name, IPart... parts) {
        this.name = name;
        this.parts = parts;
        setHasSubtypes(true);
        setUnlocalizedName(TFTFConstants.MODID + "." + name);
        setRegistryName(name);
        setCreativeTab(TalesFromTheForge.TAB);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);

        NBTTagCompound compound = Tags.getTagSafe(stack);
        if (compound.hasKey(Tags.PARTS, Constants.NBT.TAG_LIST)) {
            for (NBTBase base : compound.getTagList(Tags.PARTS, Constants.NBT.TAG_COMPOUND)) {
                if (base instanceof NBTTagCompound) {
                    tooltip.add("Part id: " + ((NBTTagCompound) base).getString(Tags.PARTID));
                    tooltip.add(" - Material: " + MaterialRegistry.getMaterial(((NBTTagCompound) base).getString(Tags.MATERIAL)));
                }
            }
        }
    }
}