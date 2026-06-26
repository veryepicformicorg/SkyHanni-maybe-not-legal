package at.hannibal2.skyhanni.features.misc

import at.hannibal2.skyhanni.SkyHanniMod
import at.hannibal2.skyhanni.api.event.HandleEvent
import at.hannibal2.skyhanni.events.minecraft.ClientDisconnectEvent
import at.hannibal2.skyhanni.events.minecraft.SkyHanniTickEvent
import at.hannibal2.skyhanni.skyhannimodule.SkyHanniModule
import at.hannibal2.skyhanni.utils.BlockUtils.getBlockStateAt
import at.hannibal2.skyhanni.utils.LorenzVec
import at.hannibal2.skyhanni.utils.compat.MinecraftCompat
import at.hannibal2.skyhanni.utils.toLorenzVec
import net.minecraft.client.Minecraft
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.network.protocol.game.ServerboundUseItemOnPacket
import net.minecraft.world.InteractionHand
import net.minecraft.world.level.block.ChestBlock
import net.minecraft.world.phys.BlockHitResult
import net.minecraft.world.phys.Vec3


@SkyHanniModule
object ChestOpener {
    val OPENED_CHESTS: MutableSet<LorenzVec> = HashSet<LorenzVec>()
     private val config get() = SkyHanniMod.feature.misc


    @HandleEvent
    fun onTick(event: SkyHanniTickEvent) {
        if (!config.chestOpener) return

        val player = MinecraftCompat.localPlayer
        val playerPos = player.position().toLorenzVec()


        for (x in -3..3) {
            for (y in -3..3) {
                for (z in -3..3) {
                    val checkPos = playerPos.add(x, y, z)

                    if (config.chestOpenerMemory && OPENED_CHESTS.contains(checkPos)) continue

                    if (checkPos.getBlockStateAt().block is ChestBlock) {
                        sendUsePacket(checkPos.toBlockPos())
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
