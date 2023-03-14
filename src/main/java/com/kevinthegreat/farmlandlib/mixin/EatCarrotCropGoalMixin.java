package com.kevinthegreat.farmlandlib.mixin;

import com.kevinthegreat.farmlandlib.FarmlandTag;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(targets = "net/minecraft/entity/passive/RabbitEntity$EatCarrotCropGoal")
public abstract class EatCarrotCropGoalMixin {
    @ModifyExpressionValue(method = "isTargetPos", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"))
    private boolean farmlandlib$isFarmland(boolean original, WorldView world, BlockPos pos) {
        return original || world.getBlockState(pos).isIn(FarmlandTag.FARMLAND);
    }
}
