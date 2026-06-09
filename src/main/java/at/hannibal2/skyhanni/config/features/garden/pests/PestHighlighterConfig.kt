package at.hannibal2.skyhanni.config.features.garden.pests

import at.hannibal2.skyhanni.config.FeatureToggle
import com.google.gson.annotations.Expose
import io.github.notenoughupdates.moulconfig.annotations.ConfigEditorBoolean
import io.github.notenoughupdates.moulconfig.annotations.ConfigOption
import io.github.notenoughupdates.moulconfig.observer.Property

class PestHighlighterConfig {
    @Expose
    @ConfigOption(name = "Enabled", desc = "Enable Pest Highlighter.")
    @ConfigEditorBoolean
    @FeatureToggle
    val enabled: Property<Boolean> = Property.of(true)

    @Expose
    @ConfigOption(name = "Show Tracers", desc = "Show Tracers to Pests..")
    @ConfigEditorBoolean
    @FeatureToggle
    var showTracers: Boolean = true
}
