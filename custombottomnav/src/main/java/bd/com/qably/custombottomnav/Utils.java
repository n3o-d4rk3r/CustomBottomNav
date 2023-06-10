package bd.com.qably.custombottomnav;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import android.widget.ImageView;

class Utils {

    /**
     * Change given image view tint
     *
     * @param imageView target image view
     * @param color     tint color
     */
    static void changeImageViewTint(ImageView imageView, int color) {
        imageView.setColorFilter(color);
    }

    /**
     * Change view visibility
     *
     * @param view target view
     */
    static void changeViewVisibilityGone(View view) {
        if (view != null && view.getVisibility() == View.VISIBLE)
            view.setVisibility(View.GONE);
    }

    /**
     * Change view visibility
     *
     * @param view target view
     */
    static void changeViewVisibilityVisible(View view) {
        if (view != null && view.getVisibility() == View.GONE)
            view.setVisibility(View.VISIBLE);
    }

    /**
     * Change given image view tint with animation
     *
     * @param image     target image view
     * @param fromColor start animation from color
     * @param toColor   final color
     */
    static void changeImageViewTintWithAnimation(final ImageView image, int fromColor, int toColor) {
        ValueAnimator imageTintChangeAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), fromColor, toColor);
        imageTintChangeAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                image.setColorFilter((Integer) animator.getAnimatedValue());
            }
        });
        imageTintChangeAnimation.setDuration(150);
        imageTintChangeAnimation.start();
    }

    static void makeTranslationYAnimation(View view, float value) {
        view.animate()
                .translationY(value)
                .setDuration(150)
                .start();
    }

    // TODO: 15.08.2016 add ripple effect programmatically
    @TargetApi(21)
    static RippleDrawable getPressedColorRippleDrawable(int normalColor, int pressedColor) {
        return new RippleDrawable(getPressedColorSelector(normalColor, pressedColor), new ColorDrawable(normalColor), null);
    }

    private static ColorStateList getPressedColorSelector(int normalColor, int pressedColor) {
        return new ColorStateList(
                new int[][]
                        {
                                new int[]{android.R.attr.state_pressed},
                                new int[]{android.R.attr.state_focused},
                                new int[]{android.R.attr.state_activated},
                                new int[]{}
                        },
                new int[]
                        {
                                pressedColor,
                                pressedColor,
                                pressedColor,
                                normalColor
                        }
        );
    }
}
