package Projekt2;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class ColorRenderer extends DefaultTableCellRenderer  {
    public ColorRenderer(){
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (value instanceof Number){
            int number = ((Number) value).intValue();
            if (number == 0){
                c.setBackground(Color.BLACK);
                c.setForeground(Color.BLACK);

            }
            if (number == 1){
                c.setBackground(Color.BLUE);
                c.setForeground(Color.BLUE);
            }
            if (number == 3){
                c.setBackground(Color.BLACK);
                c.setForeground(Color.BLACK);

            }
        }
        return c;

    }
}
