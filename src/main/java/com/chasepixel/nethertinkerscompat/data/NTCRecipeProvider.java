package com.chasepixel.nethertinkerscompat.data;

import com.chasepixel.nethertinkerscompat.NetherTinkers;
import com.chasepixel.nethertinkerscompat.common.item.NTCItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import slimeknights.tconstruct.common.data.BaseRecipeProvider;
import slimeknights.tconstruct.library.data.recipe.IToolRecipeHelper;
import slimeknights.tconstruct.library.recipe.TinkerRecipeTypes;

import java.util.function.Consumer;

public class NTCRecipeProvider extends RecipeProvider implements IToolRecipeHelper {

    public NTCRecipeProvider(PackOutput generator) {
        super(generator);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        toolBuilding(consumer, NTCItems.machete, "tools/building");
    }

    @Override
    public String getModId() {
        return NetherTinkers.MODID;
    }
}
