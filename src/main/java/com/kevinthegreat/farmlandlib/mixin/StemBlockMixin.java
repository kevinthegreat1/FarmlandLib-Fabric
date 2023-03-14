package com.kevinthegreat.farmlandlib.mixin;

import com.kevinthegreat.farmlandlib.FarmlandTag;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.BlockState;
import net.minecraft.block.StemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(StemBlock.class)
public abstract class StemBlockMixin {
    @ModifyExpressionValue(method = "canPlantOnTop", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"))
    private boolean farmlandlib$isFarmland(boolean original, BlockState floor, BlockView world, BlockPos pos) {
        return original || floor.isIn(FarmlandTag.FARMLAND);
    }

    @ModifyExpressionValue(method = "randomTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"))
    private boolean farmlandlib$isFarmland(boolean original, @Local(ordinal = 1) BlockState state) {
        return original || state.isIn(FarmlandTag.FARMLAND);
    }
}
