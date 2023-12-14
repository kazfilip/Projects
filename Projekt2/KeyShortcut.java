package Projekt2;

import java.awt.*;

public class KeyShortcut extends MenuShortcut {
    int key;

    public KeyShortcut(int key,boolean shift) {
        super(key,shift);
        this.key = key;

    }
}
