package tv.sporttotal.toothpick

import toothpick.Toothpick
import javax.inject.Inject


interface ViewModel {

}

class ToBeInjected {

    @Inject lateinit var viewModel : ViewModel


    fun onCreate() {
        Toothpick.inject(this, Toothpick.openScope(ToBeInjected::class.java))
    }
}
