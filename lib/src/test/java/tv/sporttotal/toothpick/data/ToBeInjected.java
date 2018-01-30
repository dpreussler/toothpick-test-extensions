package tv.sporttotal.toothpick.data;

import toothpick.Toothpick;

import javax.inject.Inject;

public class ToBeInjected {

    @Inject
    public ViewModel viewModel;

    public void onCreate() {
        Toothpick.inject(this, Toothpick.openScope(ToBeInjected.class));
    }
}
