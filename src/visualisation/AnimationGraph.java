package visualisation;


import edu.uci.ics.jung.algorithms.layout.*;
import edu.uci.ics.jung.algorithms.layout.SpringLayout;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import logic.CourierCar;
import logic.Data;
import logic.Map;
import org.apache.commons.collections15.Transformer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AnimationGraph {

    private Map map;
    private Data<CourierCar> courierCars;
    private JFrame jframe;
    private JPanel component = new JPanel();
    private VisualizationViewer<VertexLabel, Edge> graph;


    private int time = 0;

    public AnimationGraph(Map map, Data<CourierCar> courierCar) {

        this.map = map;
        this.courierCars = courierCar;
    }

    private VisualizationViewer<VertexLabel, Edge>  draw( ) {

        GraphView graphView = new GraphView( map, courierCars );
        Layout<VertexLabel, Edge> layout = new KKLayout( graphView.refresh( time ) );
        //layout.setLocation( graphView.getVertexLabel(0), new Point(0, 0) );


        layout.setSize(new Dimension(1624, 1624));
        VisualizationViewer<VertexLabel, Edge> vv = new VisualizationViewer<VertexLabel, Edge>(layout);

        Transformer<VertexLabel,Paint> vertexPaint = new Transformer<VertexLabel, Paint>() {
            @Override
            public Paint transform(VertexLabel i) {
                if ( i.getCourierCars().size() != 0 )
                    return (Paint) Color.GREEN;
                else
                    return  (Paint) Color.RED;
            }
        };

        vv.getRenderContext().setVertexFillPaintTransformer( vertexPaint );

        vv.setPreferredSize(new Dimension(1024, 768));

        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());

        DefaultModalGraphMouse gm = new DefaultModalGraphMouse();
        gm.setMode(ModalGraphMouse.Mode.TRANSFORMING);
        vv.setGraphMouse(gm);

        return vv;
    }

    public void run() {


        jframe = new JFrame("Interactive Graph View 1");

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jframe.getContentPane().add( draw() );

        jframe.pack();
        jframe.setVisible(true);
    }

    private void refresh() {

        time += 100;

        jframe.getContentPane().removeAll();
        jframe.getContentPane().add(graph);

        jframe.pack();
        jframe.setVisible(true);

        System.out.println( time );
    }


    class keyListener implements KeyListener {


        @Override
        public void keyTyped(KeyEvent keyEvent) {
            System.out.println( keyEvent.getKeyChar() );
            refresh();
        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {
             System.out.println( keyEvent.getKeyChar() );
        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {
             System.out.println( keyEvent.getKeyChar() );
        }
    }

    class Listener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            time += 100;
            refresh();
            System.out.println(time);

        }
    }
}
