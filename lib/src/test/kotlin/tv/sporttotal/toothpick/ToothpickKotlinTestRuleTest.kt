package tv.sporttotal.toothpick


import org.amshove.kluent.mock
import org.amshove.kluent.shouldBe
import org.junit.After
import org.junit.Rule
import org.junit.Test
import tv.sporttotal.toothpick.data.ViewModel
import tv.sporttotal.toothpick.data.ToBeInjected

class ToothpickKotlinTestRuleTest {

    @Rule @JvmField val testRule = ToothpickKotlinTestRule(ToBeInjected::class.java)
    private val viewModel = mock<ViewModel>().injectable(this)

    private val tested = ToBeInjected()

    @After
    fun tearDown() = testRule.tearDown()

    @Test
    fun `should inject`() {
        tested.onCreate()
        tested.viewModel shouldBe viewModel
    }

}

