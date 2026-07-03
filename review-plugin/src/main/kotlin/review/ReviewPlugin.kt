package review

import org.gradle.api.Plugin
import org.gradle.api.Project

class ReviewPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val extension = project.extensions.create("review", ReviewExtension::class.java)
        project.tasks.register("reviewPr", ReviewTask::class.java) {
            it.group = "review"
            it.description = "Analyse IA du diff d'une PR (pre-review avant revue humaine)"
            it.extension.set(extension)
        }
    }
}