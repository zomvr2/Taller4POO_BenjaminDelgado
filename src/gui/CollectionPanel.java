package gui;

import javax.swing.*;
import logic.Sistema;
import logic.SistemaImpl;

public class CollectionPanel extends JPanel {
    private Sistema sistema;
    public CollectionPanel() {
        sistema = SistemaImpl.getInstance();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}
