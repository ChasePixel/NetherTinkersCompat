package com.chasepixel.nethertinkerscompat.data;

import com.chasepixel.nethertinkerscompat.NetherTinkers;
import com.chasepixel.nethertinkerscompat.common.item.NTCItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class NTCLanguageProvider extends LanguageProvider {

    public NTCLanguageProvider(PackOutput output, String locale) {
        super(output, NetherTinkers.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        add(NTCItems.machete.get(), "Machete");
        add("item.nethertinkerscompat.machete.description",
                "A sharp blade useful for gathering extra drops from certain mobs or blocks.\nNot the best weapon, but gets the job done. Also used for cutting on a cutting board.");
    }
}
