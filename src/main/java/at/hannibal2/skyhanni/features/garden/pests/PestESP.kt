package at.hannibal2.skyhanni.features.garden.pests

import at.hannibal2.skyhanni.api.event.HandleEvent
import at.hannibal2.skyhanni.data.IslandType
import at.hannibal2.skyhanni.events.SecondPassedEvent
import at.hannibal2.skyhanni.mixins.hooks.RenderLivingEntityHelper
import at.hannibal2.skyhanni.skyhannimodule.SkyHanniModule
import at.hannibal2.skyhanni.utils.AllEntitiesGetter
import at.hannibal2.skyhanni.utils.EntityUtils
import net.minecraft.world.entity.decoration.ArmorStand

@SkyHanniModule
object PestESP {
    private val config get() = PestApi.config.pestESP
    private var pests = mutableSetOf<ArmorStand>()

    @OptIn(AllEntitiesGetter::class)
    @HandleEvent(SecondPassedEvent::class, onlyOnIsland = IslandType.GARDEN)
    fun onSecondPassed() {
        if (!config.enabled.get()) return

        val entities = EntityUtils.getEntities<ArmorStand>()
            .filter { entity ->
                entity.showArms() && entity.showBasePlate().not() && !entity.isInvisible
            }

        for (entity in entities) {
            RenderLivingEntityHelper.setEntityColor(
                entity,
                color = java.awt.Color(255, 0, 0),
                condition = { true }
            )
        }
    }
}
