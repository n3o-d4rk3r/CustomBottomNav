package bd.com.qably.custombottomnav;

import android.content.Context;

import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

import com.google.android.material.snackbar.Snackbar;

class SpaceNavigationViewBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    public SpaceNavigationViewBehavior(Context context, AttributeSet attrs) {
        super();
    }

    public SpaceNavigationViewBehavior() {
        super();
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, V child, View dependency) {
        return dependency instanceof Snackbar.SnackbarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, final V child, View dependency) {
        float translationY = Math.min(0, dependency.getTranslationY() - dependency.getHeight());
        child.setTranslationY(translationY);
        return true;
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        // Ensure we react to vertical scrolling
        return (axes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0
                || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type);
    }

    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V child,
                               @NonNull View target, int dxConsumed, int dyConsumed,
                               int dxUnconsumed, int dyUnconsumed, int type,
                               @NonNull int[] consumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed,
                dxUnconsumed, dyUnconsumed, type, consumed);
        if (dyConsumed > 0) {
            Utils.makeTranslationYAnimation(child, child.getHeight());
        } else if (dyConsumed < 0) {
            Utils.makeTranslationYAnimation(child, 0);
        }
    }

}
