package logic;

import java.awt.Color;
import java.awt.Paint;
import org.jfree.chart.renderer.category.GanttRenderer;

class MyGanttRenderer extends GanttRenderer {

    private static final Color subtask1Color = Color.blue;
    private static final Color subtask2Color = Color.cyan;
    private static final Color subtask3Color = Color.green;
    private static final long serialVersionUID = 1L;

    public MyGanttRenderer() {
        super();
    }

    @Override
    public Paint getItemPaint(int row, int col) {
        System.out.println(row + " " + col + " " + super.getItemPaint(row, col));
        if (col == 0) {
            return subtask1Color;
        } else if (col == 1) {
            return subtask2Color;
        } else if (col == 2) {
            return subtask3Color;
        } else {
            return super.getItemPaint(row, col);
        }

    }
}
