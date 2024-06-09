import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidHiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val lib = extensions.getByType<VersionCatalogsExtension>().named("libs")
            with(pluginManager) {
                apply("com.google.devtools.ksp")
                apply("com.google.dagger.hilt.android")
            }
            dependencies {
                "implementation"(lib.findLibrary("hilt-android").get())
                "implementation"(lib.findLibrary("gradle-plugin-ksp").get())
                "ksp"(lib.findLibrary("hilt-compiler").get())
            }
        }
    }
}