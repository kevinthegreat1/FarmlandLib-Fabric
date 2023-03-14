package com.kevinthegreat.farmlandlib;

import com.llamalad7.mixinextras.MixinExtrasBootstrap;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

public class FarmlandLib implements PreLaunchEntrypoint, ModInitializer {
    @Override
    public void onPreLaunch() {
        MixinExtrasBootstrap.init();
    }

    @Override
    public void onInitialize() {
        FarmlandTag.init();
    }
}
