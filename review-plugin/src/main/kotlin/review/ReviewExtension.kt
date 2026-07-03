package review

import org.gradle.api.model.ObjectFactory
import javax.inject.Inject

abstract class ReviewExtension @Inject constructor(objects: ObjectFactory) {
    val prNumber = objects.property(Int::class.java).convention(0)
    val repo = objects.property(String::class.java).convention("")
    val llmModel = objects.property(String::class.java).convention("gpt-oss:120b-cloud")
}