package michaelstanek.tescht;

import android.view.DragEvent;
import android.view.View;

/**
 * Created by The Unvelievable Stan on 26.06.2016.
 * Draglistener for setting ships
 */
public class ShipDragListener implements View.OnDragListener{

    @Override
    public boolean onDrag(View v, DragEvent event) {
        final int action=event.getAction();
        switch(action){
            case DragEvent.ACTION_DRAG_STARTED: {

            }
            case DragEvent.ACTION_DRAG_ENTERED: {

            }
        }
        return false;
    }
}
