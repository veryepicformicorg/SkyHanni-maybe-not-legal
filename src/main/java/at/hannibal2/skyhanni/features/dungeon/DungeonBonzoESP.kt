package at.hannibal2.skyhanni.features.dungeon

import at.hannibal2.skyhanni.SkyHanniMod
import at.hannibal2.skyhanni.api.event.HandleEvent
import at.hannibal2.skyhanni.data.IslandType
import at.hannibal2.skyhanni.events.SecondPassedEvent
import at.hannibal2.skyhanni.events.minecraft.SkyHanniRenderWorldEvent
import at.hannibal2.skyhanni.mixins.hooks.RenderLivingEntityHelper
import at.hannibal2.skyhanni.skyhannimodule.SkyHanniModule
import at.hannibal2.skyhanni.utils.AllEntitiesGetter
import at.hannibal2.skyhanni.utils.ColorUtils.toColor
import at.hannibal2.skyhanni.utils.EntityUtils
import at.hannibal2.skyhanni.utils.EntityUtils.getSkinTexture
import at.hannibal2.skyhanni.utils.LorenzColor
import at.hannibal2.skyhanni.utils.render.WorldRenderUtils.drawFilledBoundingBox
import at.hannibal2.skyhanni.utils.render.WorldRenderUtils.drawLineToCrosshair
import at.hannibal2.skyhanni.utils.render.WorldRenderUtils.exactBoundingBox
import at.hannibal2.skyhanni.utils.render.WorldRenderUtils.exactLocation
import net.minecraft.client.player.RemotePlayer
import java.awt.Color

@SkyHanniModule
object DungeonBonzoESP {
//     private val config get() = SkyHanniMod.feature.dungeon.bonzoESP
//     var bonzo: RemotePlayer? = null
//         private set
//
//     const val BONZO: String = "ewogICJ0aW1lc3RhbXAiIDogMTYyMTEzNDcwMTk3MCwKICAicHJvZmlsZUlkIiA6ICI5ZDIyZGRhOTVmZGI0MjFmOGZhNjAzNTI1YThkZmE4ZCIsCiAgInByb2ZpbGVOYW1lIiA6ICJTYWZlRHJpZnQ0OCIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS85MWU3OWY3ZTYyOGYyMWY0Mjc2MTBjYzZjZWQwZmYxNTNlMjE4ODBkNjFjYmFjNjczYmY4NjJiMWQ0ZTQ0MjZiIiwKICAgICAgIm1ldGFkYXRhIiA6IHsKICAgICAgICAibW9kZWwiIDogInNsaW0iCiAgICAgIH0KICAgIH0KICB9Cn0="
//
//     const val DEAD_BONZO: String = "ewogICJ0aW1lc3RhbXAiIDogMTYyMjg1NTk2MzUyNCwKICAicHJvZmlsZUlkIiA6ICIyMDA2NTVkMjMyYTE0MTc2OGIwNjQ0NWNkNTliNDg3NCIsCiAgInByb2ZpbGVOYW1lIiA6ICJGaWVzdHlCbHVlXyIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS8xMjcxNmVjYmY1YjhkYTAwYjA1ZjMxNmVjNmFmNjFlOGJkMDI4MDViMjFlYjhlNDQwMTUxNDY4ZGM2NTY1NDljIgogICAgfQogIH0KfQ=="
//
//     val c = Color(255, 0, 0);
//
//     @OptIn(AllEntitiesGetter::class)
//     @HandleEvent(SecondPassedEvent::class)
//     fun onSecondPassed() {
//         if (!config.enabled.get()) return
//         if (!(DungeonApi.inBossRoom && DungeonApi.getCurrentBoss() == DungeonFloor.F1)) return
//
//         val entity = EntityUtils.getEntities<RemotePlayer>()
//             .firstOrNull { it.getSkinTexture() == BONZO || it.getSkinTexture() == DEAD_BONZO }
//             ?: return
//         RenderLivingEntityHelper.setEntityColor(
//             entity,
//             color = config.color.toColor(),
//             condition = { true },
//         )
//     }
//
//     @HandleEvent(SkyHanniRenderWorldEvent::class)
//     fun onRenderWorld(event: SkyHanniRenderWorldEvent) {
//         if (!config.enabled.get()) return
//
//         if (!(DungeonApi.inBossRoom && DungeonApi.getCurrentBoss() == DungeonFloor.F1)) return
//         val entity = bonzo ?: return
//
//         val location = event.exactLocation(entity)
//         val boundingBox = event.exactBoundingBox(entity)
//
//         event.drawFilledBoundingBox(boundingBox, c, 0.5f)
//         event.drawLineToCrosshair(location.add(0.5, 0.5), c, 3, true)
//
//     }
}
