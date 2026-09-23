package com.chasepixel.nethertinkerscompat.data;

import com.chasepixel.nethertinkerscompat.NetherTinkers;
import com.chasepixel.nethertinkerscompat.common.item.ToolDefinitions;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.ToolActions;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.client.model.TinkerItemProperties;
import slimeknights.tconstruct.library.data.tinkering.AbstractToolDefinitionDataProvider;
import slimeknights.tconstruct.library.materials.RandomMaterial;
import slimeknights.tconstruct.library.tools.definition.module.ToolModule;
import slimeknights.tconstruct.library.tools.definition.module.build.MultiplyStatsModule;
import slimeknights.tconstruct.library.tools.definition.module.build.SetStatsModule;
import slimeknights.tconstruct.library.tools.definition.module.build.ToolActionsModule;
import slimeknights.tconstruct.library.tools.definition.module.build.ToolTraitsModule;
import slimeknights.tconstruct.library.tools.definition.module.material.DefaultMaterialsModule;
import slimeknights.tconstruct.library.tools.definition.module.material.PartStatsModule;
import slimeknights.tconstruct.library.tools.definition.module.mining.IsEffectiveModule;
import slimeknights.tconstruct.library.tools.definition.module.mining.MiningSpeedModifierModule;
import slimeknights.tconstruct.library.tools.nbt.MultiplierNBT;
import slimeknights.tconstruct.library.tools.nbt.StatsNBT;
import slimeknights.tconstruct.library.tools.stat.ToolStats;
import slimeknights.tconstruct.tools.TinkerModifiers;
import slimeknights.tconstruct.tools.TinkerToolParts;
import slimeknights.tconstruct.tools.TinkerTools;

public class NTCToolDefinitionDataProvider extends AbstractToolDefinitionDataProvider {

    public NTCToolDefinitionDataProvider(PackOutput packOutput) {
        super(packOutput, NetherTinkers.MODID);
    }

    @Override
    protected void addToolDefinitions() {
        RandomMaterial tier1Material = RandomMaterial.random().tier(1).build();
        DefaultMaterialsModule defaultTwoParts = DefaultMaterialsModule.builder().material(tier1Material, tier1Material).build();

        ToolModule[] swordHarvest = {
                IsEffectiveModule.tag(TinkerTags.Blocks.MINABLE_WITH_SWORD),
                MiningSpeedModifierModule.blocks(7.5f, Blocks.COBWEB)
        };

        define(ToolDefinitions.MACHETE)
                .module(PartStatsModule.parts()
                        .part(TinkerToolParts.broadBlade, 0.75f)
                        .part(TinkerToolParts.toolHandle, 0.45f)
                        .build())
                .module(defaultTwoParts)
                .module(new SetStatsModule(StatsNBT.builder()
                        .set(ToolStats.ATTACK_DAMAGE, 2f)
                        .set(ToolStats.ATTACK_SPEED, 0.95f)
                        .build()))
                .module(new MultiplyStatsModule(MultiplierNBT.builder()
                        .set(ToolStats.ATTACK_DAMAGE, 1.3f)
                        .set(ToolStats.MINING_SPEED, 0.15f)
                        .set(ToolStats.DURABILITY, 1.5f)
                        .build()))
                .smallToolStartingSlots()
                .module(ToolTraitsModule.builder()
                        .trait(TinkerModifiers.severing, 2)
                        .trait(TinkerModifiers.lacerating, 2)
                        .trait(TinkerModifiers.aoeSilkyShears)
                        .build())
                .module(ToolActionsModule.of(ToolActions.SWORD_DIG))
                .module(swordHarvest);
    }

    @Override
    public String getName() {
        return "Nether Tinkers' Compat Tool Definition Data Generator";
    }
}
