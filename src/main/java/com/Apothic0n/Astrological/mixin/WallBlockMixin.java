package com.Apothic0n.Astrological.mixin;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WallBlock.class)
public class WallBlockMixin {

    @Shadow @Final
    private Object2ObjectOpenHashMap<BlockState, VoxelShape> shapeByIndex;

    @Shadow @Final
    private Object2ObjectOpenHashMap<BlockState, VoxelShape> collisionShapeByIndex;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void fixShapeMaps(CallbackInfo ci) {
        shapeByIndex = fixShapeMap(shapeByIndex);
        collisionShapeByIndex = fixShapeMap(collisionShapeByIndex);
    }

    private Object2ObjectOpenHashMap<BlockState, VoxelShape> fixShapeMap(
            Object2ObjectOpenHashMap<BlockState, VoxelShape> map) {
        // Implement your shape fix logic here
        return map;
    }
}

