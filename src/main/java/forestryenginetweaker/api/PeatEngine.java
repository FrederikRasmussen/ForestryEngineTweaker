package forestryenginetweaker.api;

import com.blamejared.mtlib.helpers.InputHelper;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import forestry.api.fuels.FuelManager;
import forestry.api.fuels.EngineCopperFuel;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import net.minecraft.item.ItemStack;

@ZenClass("mods.forestry.engine.peat")
@ModOnly("forestry")
@ZenRegister
public class PeatEngine {
    @ZenMethod
    public static void addRecipe(
        IItemStack itemStack,
        int energyPerTick,
        int burnDurationInTicks
    ) {
        ItemStack item = InputHelper.toStack(itemStack);
        EngineCopperFuel fuel = new EngineCopperFuel(
            item,
            energyPerTick,
            burnDurationInTicks
        );
        FuelManager.copperEngineFuel.put(item, fuel);
    }

    @ZenMethod
    public static void removeAll()
    {
        FuelManager.copperEngineFuel.clear();
    }
}