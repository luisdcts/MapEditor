package org.academiadecodigo.bootcamp.InputHandlers;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public class KeyboardManager {

    public static void init(Keyboard keyboard){

        KeyboardEvent eventUP = new KeyboardEvent();
        eventUP.setKey(KeyboardEvent.KEY_UP);
        eventUP.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventUP);

        KeyboardEvent eventDown = new KeyboardEvent();
        eventDown.setKey(KeyboardEvent.KEY_DOWN);
        eventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventDown);

        KeyboardEvent eventRight = new KeyboardEvent();
        eventRight.setKey(KeyboardEvent.KEY_RIGHT);
        eventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventRight);

        KeyboardEvent eventLeft = new KeyboardEvent();
        eventLeft.setKey(KeyboardEvent.KEY_LEFT);
        eventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventLeft);

        KeyboardEvent eventPaint = new KeyboardEvent();
        eventPaint.setKey(KeyboardEvent.KEY_SPACE);
        eventPaint.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventPaint);

        KeyboardEvent eventStopPainting = new KeyboardEvent();
        eventStopPainting.setKey(KeyboardEvent.KEY_SPACE);
        eventStopPainting.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(eventStopPainting);

        KeyboardEvent eventClear = new KeyboardEvent();
        eventClear.setKey(KeyboardEvent.KEY_C);
        eventClear.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventClear);

        KeyboardEvent eventSave = new KeyboardEvent();
        eventSave.setKey(KeyboardEvent.KEY_S);
        eventSave.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventSave);

        KeyboardEvent eventLoad = new KeyboardEvent();
        eventLoad.setKey(KeyboardEvent.KEY_L);
        eventLoad.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventLoad);

        KeyboardEvent eventRandomColor = new KeyboardEvent();
        eventRandomColor.setKey(KeyboardEvent.KEY_R);
        eventRandomColor.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventRandomColor);

        KeyboardEvent eventContinuousRandomColor = new KeyboardEvent();
        eventContinuousRandomColor.setKey(KeyboardEvent.KEY_R);
        eventContinuousRandomColor.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(eventContinuousRandomColor);



    }
}
