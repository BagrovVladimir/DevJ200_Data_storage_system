
package devj120_lab4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class SimpleEditorListener extends WindowAdapter implements ActionListener, AutoCloseable{
    
    private SimpleEditor editor;
    private File file;
    private FileReader reader;
    private FileWriter writer;
    
    JFileChooser fileChooser = new JFileChooser();

    public SimpleEditorListener(SimpleEditor editor) {
        this.editor = editor;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ea) {
        switch(ea.getActionCommand()){
            case "open":{
            try {
                openFile();
            } catch (FileNotFoundException ex) {
                System.out.println("Error 1: " + ex.getMessage());
            }
            break;
            }
            case "save":{
                saveFile();
                break;
            }
            case "cancel":{
                cancelFile();
                break;
            }
            case "exit":{
                exitFile();
                break;
            }
        }
    }
    
    private void selectFileToSave(){
        fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select file to save");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i = fileChooser.showSaveDialog(editor);
        if(i == JFileChooser.APPROVE_OPTION){
            file = fileChooser.getSelectedFile();
        }
    }
    
    private void openFile() throws FileNotFoundException{
        if(file == null){
            fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Select file");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int i = fileChooser.showOpenDialog(editor);
            if (i == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();
                try{
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    String s = " ";
                    while (bufferedReader.ready()) {
                        try{
                            s += bufferedReader.readLine();
                        } catch (IOException e){ 
                            System.out.println("Error IO:" + e.getMessage());
                        }
                    }
                    bufferedReader.close();
                    editor.apppendText(s, true);
                    } catch (IOException e){
                        JOptionPane.showMessageDialog(editor, "Error: File do not read");
                    }
            }
        }
    }
    
    private void saveFile(){
        if (file == null) {
            selectFileToSave();
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            String rezultText = editor.getText();
            bufferedWriter.write(" " + rezultText);
            bufferedWriter.flush();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(editor, "Error of recording file");
        }
    }
    
    private void cancelFile(){
        editor.apppendText("", false);
    }
    
    private void exitFile(){
        if(file != null){
            Object[] actions = {"Save", "Cancel"};
            int i = JOptionPane.showOptionDialog(editor, "Save chages?", null, 
                                                JOptionPane.YES_NO_CANCEL_OPTION, 
                                                JOptionPane.QUESTION_MESSAGE, 
                                                null, actions, null);
            if(i == 0){
                saveFile();
            }
            if(i == 1){
                cancelFile();
            }
        }
        editor.dispose();
    }
    
    

    @Override
    public void close() throws Exception {
        if(file != null){
            saveFile();
        }
    }
    
}
