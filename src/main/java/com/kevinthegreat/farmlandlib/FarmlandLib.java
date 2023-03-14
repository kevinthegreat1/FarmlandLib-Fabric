package com.kevinthegreat.farmlandlib;

import com.llamalad7.mixinextras.MixinExtrasBootstrap;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class FarmlandLib implements PreLaunchEntrypoint, ModInitializer {
    public static final TagKey<Block> FARMLAND = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "farmlands"));

    @Override
    public void onPreLaunch() {
        MixinExtrasBootstrap.init();
    }

    @Override
    public void onInitialize() {

    }
}
