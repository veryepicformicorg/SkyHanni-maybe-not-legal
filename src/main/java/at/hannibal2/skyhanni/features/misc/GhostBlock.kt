package at.hannibal2.skyhanni.features.misc

import at.hannibal2.skyhanni.SkyHanniMod
import at.hannibal2.skyhanni.api.event.HandleEvent
import at.hannibal2.skyhanni.events.minecraft.KeyDownEvent
import at.hannibal2.skyhanni.skyhannimodule.SkyHanniModule
import net.minecraft.client.Minecraft
import net.minecraft.world.phys.BlockHitResult
import net.minecraft.world.phys.HitResult


@SkyHanniModule
object GhostBlock {

    private val hotkey get() = SkyHanniMod.feature.misc.ghostBlockKey


    @HandleEvent
    fun onKeyDown(event: KeyDownEvent) {
        val mc = Minecraft.getInstance()

        if (mc.screen != null) return
        when (event.keyCode) {
            hotkey -> {
                val target = mc.hitResult ?: return
                if (target.type == HitResult.Type.BLOCK) {
                    val hitResult = target as BlockHitResult
                    val targetPos = hitResult.blockPos

                    mc.level?.setBlock(targetPos, net.minecraft.world.level.block.Blocks.AIR.defaultBlockState(), 3)
                }
            }
            else -> return
        }
    }
}
