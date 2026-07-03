package review

import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

abstract class ReviewTask : DefaultTask() {

    @get:Input
    abstract val extension: Property<ReviewExtension>

    @TaskAction
    fun reviewPr() {
        val ext = extension.get()
        logger.lifecycle("reviewPr — stub (RVW-1). PR #${ext.prNumber.get()}, repo=${ext.repo.get()}, model=${ext.llmModel.get()}")
        logger.lifecycle("Analyse IA du diff non implémentée — voir EPIC RVW-2.")
    }
}