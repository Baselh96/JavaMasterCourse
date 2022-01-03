import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Gui extends JFrame {
    private JPanel headerpane, outer,listPane,buttonSpace, inputSpace,lableSpace;
    private JButton addButton, clearButton;
    private JLabel lable;
    private JTextField inputfield;
    JList<String> listspace;
    private ArrayList<String> liste;
    public Gui(){
        this.setBackground(Color.LIGHT_GRAY);
        this.setTitle("Ihre Liste");
        liste = new ArrayList<>();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(800, 700));
        this.init();
        this.setMaximumSize(new Dimension(1000, 900));
        this.setMinimumSize(new Dimension(500, 500));
        this.pack();
        this.setVisible(true);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(liste.size()+" wurde gelöscht");
                liste.clear();
                //listspace = new JList<String>(liste.toArray((n) -> new String[0]));
                clearButton.repaint();
            }
        });
    }
    public void init(){
        // Hauptlayout
        outer = new JPanel( new BorderLayout());
        // Workspace
        headerpane = new JPanel(new BorderLayout());

        // InputSpace in Headerspace
        inputSpace =new JPanel(new FlowLayout());
        inputfield = new JTextField(30);
        inputSpace.add(inputfield, BorderLayout.CENTER);
        headerpane.add(inputSpace, BorderLayout.NORTH);


        // ButtonSpace in Headerspace
        buttonSpace =new JPanel(new FlowLayout());
        // addbutton
        addButton = new JButton();
        addButton.setText("add");
        addButton.setBackground(Color.green);
        addButton.setMargin(new Insets(10, 40, 10, 40));
        buttonSpace.add(addButton, BorderLayout.WEST);

        // clearButton
        clearButton = new JButton();
        clearButton.setText("clear");
        clearButton.setBackground(Color.RED);
        clearButton.setMargin(new Insets(10, 40, 10, 40));
        buttonSpace.add(clearButton, BorderLayout.EAST);

        headerpane.add(buttonSpace, BorderLayout.CENTER);

        // lebelSpace in Headerspace
        lableSpace = new JPanel(new FlowLayout());
        lable = new JLabel("Basel ");
        lable.setForeground(Color.green);
        lableSpace.add(lable, BorderLayout.CENTER);
        headerpane.add(lableSpace, BorderLayout.SOUTH);


        outer.add(headerpane, BorderLayout.NORTH);

        liste.add("Hallo");
        liste.add("Hello");

        // für den Titel
        listPane = new JPanel();
        listPane.setBackground(Color.lightGray);

        listPane.setPreferredSize(new Dimension(40, 10));

        listPane.setBackground(Color.CYAN);
        JLabel titel = new JLabel("Es sind "+ liste.size()+" Elemente vorhanden");
        listPane.add(titel, BorderLayout.CENTER);
        outer.add(listPane);

        //Tabelle
        JPanel tablespace  = new JPanel(new FlowLayout());
        //listspace = new JList<String>(liste.toArray((n) -> new String[0]));
        tablespace.add(listspace, BorderLayout.CENTER);
        listspace.setBackground(Color.BLUE);
        outer.add(tablespace, BorderLayout.SOUTH);

        this.add(outer);
    }
    public static void main(String[] args) {
        Gui gui = new Gui();
    }
}
