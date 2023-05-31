package Listeners;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class textfieldLisOnChange implements DocumentListener {

    public static interface MyInterface {
        void doSomething(Object obj, int i);
    }

    private MyInterface func;
    private int index;

    public textfieldLisOnChange(MyInterface func, int index){
        this.func = func;
        this.index = index;
    }

    public void changedUpdate(DocumentEvent e) {
        warn(e);
    }
    public void removeUpdate(DocumentEvent e) {
        warn(e);
    }
    public void insertUpdate(DocumentEvent e) {
        warn(e);
    }
    
    public void warn(DocumentEvent e) {
        try {
            this.func.doSomething(e.getDocument().getText(0, e.getDocument().getLength()), this.index);
        } catch (Exception ignored) {}
    }
}
