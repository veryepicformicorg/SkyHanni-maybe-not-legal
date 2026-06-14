package at.hannibal2.skyhanni.config.features.dungeon

import at.hannibal2.skyhanni.config.FeatureToggle
import com.google.gson.annotations.Expose
import io.github.notenoughupdates.moulconfig.ChromaColour
import io.github.notenoughupdates.moulconfig.annotations.ConfigEditorBoolean
import io.github.notenoughupdates.moulconfig.annotations.ConfigEditorColour
import io.github.notenoughupdates.moulconfig.annotations.ConfigOption
import io.github.notenoughupdates.moulconfig.observer.Property

class BonzoESPConfig {
    @Expose
    @ConfigOption(name = "Enabled", desc = "Bonzo ESP.")
    @ConfigEditorBoolean
    @FeatureToggle
    val enabled: Property<Boolean> = Property.of(true)

    @Expose
    @ConfigOption(name = "Bnozo Color", desc = "Colour of Bozo")
    @ConfigEditorColour
    var color: ChromaColour = ChromaColour.fromStaticRGB(255, 0, 0, 255)
}
