package com.kevinthegreat.farmlandlib.mixin;

import com.kevinthegreat.farmlandlib.FarmlandTag;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.entity.ai.brain.sensor.SecondaryPointsOfInterestSensor;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(SecondaryPointsOfInterestSensor.class)
public abstract class SecondaryPointsOfInterestSensorMixin {
    @ModifyExpressionValue(method = "sense", at = @At(value = "INVOKE", target = "Lcom/google/common/collect/ImmutableSet;contains(Ljava/lang/Object;)Z"))
    private boolean farmlandlib$isFarmland(boolean original, ServerWorld world, VillagerEntity villagerEntity, @Local(ordinal = 1) BlockPos pos){
        return original || (villagerEntity.getVillagerData().getProfession().id().equals("farmer") && world.getBlockState(pos).isIn(FarmlandTag.FARMLAND));
    }
}
