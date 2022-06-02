
package devj120_lab4;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;


public class SimpleEditor extends JFrame{
    
    private Container cp;
    private JLabel fileName;
    private JTextArea text;
    private JMenuBar bar;
    private JMenu[] menu;
    private JMenuItem[] commandMenuFile;
    private JMenuItem[] commandMenuEdit;
    private JButton[] commandButton;
    private SimpleEditorListener listener;
    
    protected SimpleEditor(){
    setTitle("Simple text editor");
    setSize(800, 500);
    setLocation(400, 300);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    
    listener = new SimpleEditorListener(this);
    
    init();
    setJMenuBar(createMenu());
    createMenu();
    setVisible(true);
    }
    
    private void init(){
        cp=getContentPane();
        cp.setLayout(new BorderLayout());
        JPanel buttonPanel= new JPanel(new FlowLayout());
        cp.add(buttonPanel, BorderLayout.NORTH);
        
        commandButton  = new JButton[4];
        
        commandButton[0] = new JButton("Open");
        commandButton[0].addActionListener(listener);
        commandButton[0].setActionCommand("open");
        
        commandButton[1] = new JButton("Save");
        commandButton[1].addActionListener(listener);
        commandButton[1].setActionCommand("save");
        
        commandButton[2] = new JButton("Cancel");
        commandButton[2].addActionListener(listener);
        commandButton[2].setActionCommand("cancel");
        
        commandButton[3] = new JButton("Exit");
        commandButton[3].addActionListener(listener);
        commandButton[3].setActionCommand("exit");
        
        buttonPanel.add(commandButton[0]);
        buttonPanel.add(commandButton[1]);
        buttonPanel.add(commandButton[2]);
        buttonPanel.add(commandButton[3]);
        
        text = new JTextArea();
        cp.add(new JScrollPane(text), BorderLayout.CENTER);
    }
    
    private JMenuBar createMenu(){
        bar = new JMenuBar();
        menu = new JMenu[2];
        
        menu[0] = new JMenu("File");
        commandMenuFile = new JMenuItem[2];
        commandMenuFile[0] = new JMenuItem("Open");
        commandMenuFile[0].addActionListener(listener);
        commandMenuFile[0].setActionCommand("open");
        commandMenuFile[1] = new JMenuItem("Exit");
        commandMenuFile[1].addActionListener(listener);
        commandMenuFile[1].setActionCommand("exit");
        
        menu[1] = new JMenu("Edit");
        commandMenuEdit = new JMenuItem[2];
        commandMenuEdit[0] = new JMenuItem("Save");
        commandMenuEdit[0].addActionListener(listener);
        commandMenuEdit[0].setActionCommand("save");
        commandMenuEdit[1] = new JMenuItem("Cancel");
        commandMenuEdit[1].addActionListener(listener);
        commandMenuEdit[1].setActionCommand("cancel");
        
        menu[0].add(commandMenuFile[0]);
        menu[0].add(commandMenuFile[1]);
        menu[1].add(commandMenuEdit[0]);
        menu[1].add(commandMenuEdit[1]);
        
        bar.add(menu[0]);
        bar.add(menu[1]);
        
       return bar;
    }
    
    void apppendText(String str, boolean append){
        if(append){
            text.append(str);
        }else{
            text.setText(str);
        } 
    }
    
    String getText(){
        return text.getText();
    }

    public static void main(String[] args) {
        SimpleEditor simpleEditor = new SimpleEditor();
    }
}
