import javax.swing.*;

public class GraphicalInterface {


    //Look ma, Jframe!
    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu fileMenu, editMenu, helpMenu;
    JMenuItem newItem, openItem, saveItem, saveAsItem, exitItem, undoItem, redoItem, aboutItem;


    public static void main (String [] args){
        new GraphicalInterface();
    }

    // Constructor to get everything started
    public GraphicalInterface(){
        newWindow();
        newTextArea();
        newMenuBar();
        window.setVisible(true);
    }


    //Create a GUI window
    public void newWindow(){
        window = new JFrame("BasicText");
        window.setSize(1024,768);  //Y2K's new year's resolution.
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    // Create an area for the text to go,
    // attach it to a scrollpane for horizontal and vertical scrolling,
    // ensure the pane has an empty border
    // and CREATE PAIN! (pane)
    public void newTextArea(){
       textArea = new JTextArea();
       scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }


    public void newMenuBar(){

        ///generate menu bar and menus--------------------------
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        helpMenu = new JMenu("Help");

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        //generate menu items ---------------------------------

        newItem = new JMenuItem("New");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        saveAsItem = new JMenuItem("Save As");
        exitItem = new JMenuItem("Exit");
        undoItem = new JMenuItem("Undo");
        redoItem = new JMenuItem("Redo");
        aboutItem = new JMenuItem("About");


        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        fileMenu.add(exitItem);
        editMenu.add(undoItem);
        editMenu.add(redoItem);
        helpMenu.add(aboutItem);
    }

}
