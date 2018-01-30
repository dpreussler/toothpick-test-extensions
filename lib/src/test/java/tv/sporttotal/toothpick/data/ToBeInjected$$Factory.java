package tv.sporttotal.toothpick.data;

import toothpick.Factory;
import toothpick.MemberInjector;
import toothpick.Scope;

public final class ToBeInjected$$Factory implements Factory<ToBeInjected> {
  private MemberInjector<ToBeInjected> memberInjector = new ToBeInjected$$MemberInjector();

  @Override
  public ToBeInjected createInstance(Scope scope) {
    scope = getTargetScope(scope);
    ToBeInjected toBeInjected = new ToBeInjected();
    memberInjector.inject(toBeInjected, scope);
    return toBeInjected;
  }

  @Override
  public Scope getTargetScope(Scope scope) {
    return scope;
  }

  @Override
  public boolean hasScopeAnnotation() {
    return false;
  }

  @Override
  public boolean hasProvidesSingletonInScopeAnnotation() {
    return false;
  }
}
