package com.chasepixel.nethertinkerscompat.data;


import com.chasepixel.nethertinkerscompat.NetherTinkers;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import slimeknights.tconstruct.library.client.data.material.GeneratorPartTextureJsonGenerator;
import slimeknights.tconstruct.library.client.data.material.MaterialPartTextureGenerator;
import slimeknights.tconstruct.tools.data.sprite.TinkerMaterialSpriteProvider;

@Mod.EventBusSubscriber(modid = NetherTinkers.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NTCDataGenerators {

    public NTCDataGenerators() {}

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();

        generator.addProvider(event.includeServer(), new NTCToolDefinitionDataProvider(packOutput));
        generator.addProvider(event.includeServer(), new NTCSlotLayoutProvider(packOutput));
        generator.addProvider(event.includeServer(), new NTCRecipeProvider(packOutput));

        if (event.includeClient()) {
            genLanguages(generator, packOutput);
        }

        generator.addProvider(event.includeClient(), new NTCItemModelProvider(packOutput, event.getExistingFileHelper()));

        TinkerMaterialSpriteProvider materialSprites = new TinkerMaterialSpriteProvider();

        NTCSpriteProvider partSprites = new NTCSpriteProvider();

        generator.addProvider(event.includeClient(),
                new GeneratorPartTextureJsonGenerator(packOutput, NetherTinkers.MODID, partSprites));

        generator.addProvider(event.includeClient(),
                new MaterialPartTextureGenerator(packOutput, event.getExistingFileHelper(), partSprites, materialSprites));

    }

    private static void genLanguages(DataGenerator generator, PackOutput output) {
        //US
        generator.addProvider(true, new NTCLanguageProvider(output, "en_us"));
        //CA
        generator.addProvider(true, new NTCLanguageProvider(output, "en_ca"));
    }
}
