package forestryenginetweaker.api;

import com.blamejared.mtlib.helpers.InputHelper;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.liquid.ILiquidStack;
import forestry.api.fuels.FuelManager;
import forestry.api.fuels.EngineBronzeFuel;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import net.minecraftforge.fluids.Fluid;

@ZenClass("mods.forestry.engine.biogas")
@ModOnly("forestry")
@ZenRegister
public class BiogasEngine {
    @ZenMethod
    public static void addRecipe(
        ILiquidStack liquid,
        int energyPerMillibucket,
        int burnDurationInTicks,
        int dissipationMultiplier
    ) {
        Fluid fluid = InputHelper.getFluid(liquid);
        EngineBronzeFuel fuel = new EngineBronzeFuel(
            fluid,
            energyPerMillibucket,
            burnDurationInTicks,
            dissipationMultiplier
        );
        FuelManager.bronzeEngineFuel.put(fluid, fuel);
    }

    @ZenMethod
    public static void removeAll()
    {
        FuelManager.bronzeEngineFuel.clear();
    }
}