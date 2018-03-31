package projecthrzn.talesfromtheforge.common.tool;

import net.minecraft.item.Item;
import projecthrzn.talesfromtheforge.TalesFromTheForge;
import projecthrzn.talesfromtheforge.common.IPart;
import projecthrzn.talesfromtheforge.util.TFTFConstants;

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
}