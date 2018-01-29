package tv.sporttotal.toothpick

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import toothpick.Toothpick
import toothpick.config.Module


class ToothpickKotlinTestRule(scopeName: Any) : TestRule {

    private val scope = Toothpick.openScope(scopeName)
    val module = Module()

    fun tearDown() {
        Toothpick.closeScope(scope.name)
    }

    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            override fun evaluate() {
                scope.installTestModules(module)
                base.evaluate()
            }
        }
    }
}

inline fun <reified T> T.injectable(instance: Any): T  {
    instance.javaClass.fields.forEach {
        if (it.type == ToothpickKotlinTestRule::class.java) {
            return injectable(it.get(instance) as ToothpickKotlinTestRule)
        }
    }
    return this
}

inline fun <reified T> T.injectable(rule: ToothpickKotlinTestRule): T  = this.injectable(T::class.java, rule.module)

fun <T> T.injectable(clazz: Class<T>, module: Module): T {
    module.bind(clazz).toInstance(this)
    return this
}
