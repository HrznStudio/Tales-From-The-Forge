package projecthrzn.talesfromtheforge.common;

import net.minecraft.client.resources.I18n;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public enum GripType implements IStringSerializable {
    ONE_HANDED,
    TWO_HANDED,;

    public static final GripType[] ENABLED = values();

    public static GripType ofKey(int meta) {
        return ENABLED[meta % ENABLED.length];
    }

    @SideOnly(Side.CLIENT)
    public String getDisplayName() {
        return I18n.format("grip." + getName() + ".name");
    }

    @Override
    public String getName() {
        return name().toLowerCase();
    }

    public int meta() {
        return ordinal();
    }
}
