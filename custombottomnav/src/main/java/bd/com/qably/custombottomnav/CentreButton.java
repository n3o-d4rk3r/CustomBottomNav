package bd.com.qably.custombottomnav;


import android.content.Context;
import android.view.MotionEvent;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CentreButton extends FloatingActionButton {

    public CentreButton(Context context) {
        super(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        boolean result = super.onTouchEvent(ev);
        if (!result) {
            if(ev.getAction() == MotionEvent.ACTION_UP) {
                cancelLongPress();
            }
            setPressed(false);
        }
        return result;
    }
}
