package toolbox;

import graph.Graph;
import graph.InheritanceArrow;
import graph.SimpleArrow;

import java.awt.*;
import java.awt.event.MouseEvent;

public class InheritanceArrowTool extends Tool{
    private Point mouseBuffer, startPoint;
    private boolean dragging = false;
    private InheritanceArrow arrowBuffer = null;
    public InheritanceArrowTool(Graph G) {
        super(G);
        setToolName("InheritanceArrowTool");
    }

    @Override
    public void doubleClicked(MouseEvent e) {

    }

    @Override
    public void singleClicked(MouseEvent e) {

    }

    @Override
    public void mouseDown(MouseEvent e) {
        dragging = true;
        startPoint = e.getPoint();
        arrowBuffer = new InheritanceArrow(startPoint.x, startPoint.y, startPoint.x, startPoint.y);
        G.newElem(arrowBuffer);
    }

    @Override
    public void mouseUp(MouseEvent e) {
        dragging = false;
        arrowBuffer.pop();
        arrowBuffer = null;
    }

    @Override
    public void mouseDrag(MouseEvent e) {
        if (dragging)
        {
            mouseBuffer = e.getPoint();
            arrowBuffer.setT(mouseBuffer);
//            G.getActor().update(startPoint.x, startPoint.y, mouseBuffer.x, mouseBuffer.y);
        }
    }
}
