package com.kevinthegreat.farmlandlib;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public interface FarmlandTag {
    TagKey<Block> FARMLAND = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "farmlands"));

    static void init() {}
}
