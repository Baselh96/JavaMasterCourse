package Frame;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class MyWindow extends Frame {
    private ArrayList<String> s = new ArrayList<>();
    public MyWindow(){
        setTitle("BaselHussein");
        setSize(600, 600);
        setVisible(true);
        s.add("Basel");
        s.add("Hussein");
        s.add("asd");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Font newFontbig = new Font("newFont", Font.BOLD, 20);
        Font newFontsmall = new Font("newFontsmall", Font.BOLD, 14);
        g.setFont(newFontbig);
        g.drawString(s.size()+" Elemente in der Liste", 100, 50);
        g.setFont(newFontsmall);
        for (int i = 0; i < s.size(); i++){
            g.drawString(i + " Element: " + s.get(i), 102, 70 +(i * 15));
        }
        g.drawString("beim Basel", 100,120);

    }
}
