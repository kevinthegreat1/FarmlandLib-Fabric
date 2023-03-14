package com.kevinthegreat.farmlandlib.mixin;

import com.kevinthegreat.farmlandlib.FarmlandTag;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.block.AttachedStemBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(AttachedStemBlock.class)
public abstract class AttachedStemBlockMixin {
    @ModifyExpressionValue(method = "canPlantOnTop", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"))
    private boolean farmlandlib$isFarmland(boolean original, BlockState floor, BlockView world, BlockPos pos) {
        return original || floor.isIn(FarmlandTag.FARMLAND);
    }
}
