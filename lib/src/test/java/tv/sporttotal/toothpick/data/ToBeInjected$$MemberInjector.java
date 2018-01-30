package tv.sporttotal.toothpick.data;

import toothpick.MemberInjector;
import toothpick.Scope;
import tv.sporttotal.toothpick.data.ToBeInjected;
import tv.sporttotal.toothpick.data.ViewModel;

public final class ToBeInjected$$MemberInjector implements MemberInjector<ToBeInjected> {
  @Override
  public void inject(ToBeInjected target, Scope scope) {
    target.viewModel = scope.getInstance(ViewModel.class);
  }
}
