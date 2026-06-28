package at.hannibal2.skyhanni.features.misc

import at.hannibal2.skyhanni.SkyHanniMod
import at.hannibal2.skyhanni.api.event.HandleEvent
import at.hannibal2.skyhanni.events.minecraft.ClientDisconnectEvent
import at.hannibal2.skyhanni.events.minecraft.SkyHanniTickEvent
import at.hannibal2.skyhanni.skyhannimodule.SkyHanniModule
import at.hannibal2.skyhanni.utils.BlockUtils.getBlockStateAt

import at.hannibal2.skyhanni.utils.compat.MinecraftCompat
import at.hannibal2.skyhanni.utils.toLorenzVec
import net.minecraft.client.Minecraft
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.world.InteractionHand
import net.minecraft.world.level.block.ChestBlock
import net.minecraft.world.phys.BlockHitResult
import net.minecraft.world.phys.Vec3


@SkyHanniModule
object ChestOpener {
    val OPENED_CHESTS: MutableSet<BlockPos> = HashSet()
    private val config get() = SkyHanniMod.feature.misc


    @HandleEvent
    fun onTick(event: SkyHanniTickEvent) {
        if (!config.chestOpener) return

        val player = MinecraftCompat.localPlayer
        val playerPos = player.position().toLorenzVec()

        val range = 4

        for (x in -range..range) {
            for (y in -range..range) {
                for (z in -range..range) {
                    val blockPos = playerPos.add(x, y, z)
                    val checkPos = blockPos.toBlockPos()

                    if (config.chestOpenerMemory && OPENED_CHESTS.contains(checkPos)) continue

                    if (blockPos.getBlockStateAt().block is ChestBlock) {
                        sendUsePacket(checkPos)
                        OPENED_CHESTS.add(checkPos)
                        return
                    }
                }
            }
        }
    }

    @HandleEvent
    fun onDisconnect(event: ClientDisconnectEvent) {
        OPENED_CHESTS.clear()
    }

    private fun sendUsePacket(pos: BlockPos) {

        val hitResult = BlockHitResult(
            Vec3(pos.x + 0.5, pos.y + 0.5, pos.z + 0.5),
            Direction.UP,
            pos,
            false,
        )
        val mc = Minecraft.getInstance()
        val gm = mc.gameMode ?: return
        val p = mc.player ?: return
        gm.useItemOn(p, InteractionHand.MAIN_HAND, hitResult)
    }
}
