import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.swing.border.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GUITask implements ActionListener {

    JFrame frame;
    JPanel buttonPanel, queenPanel;
    JMenuBar menuBar;
    GridLayout buttonLayout, menuLayout, queenLayout;
    JButton reset, north, south, east, west;
    JMenu fontOption, fontSize, textColor, textBackgroundColor, buttonOutlineColor;
    ArrayList<JMenuItem> fontOptions, fontSizes, textColors, textBackgroundColors, buttonOutlineColors;
    ArrayList<String> fontNamesArray, textColorNamesArray, textBackgroundColorNamesArray, buttonOutlineColorNamesArray;
    JTextArea textArea;
    Font currentFont;
    int currentFontSize;
    ArrayList<Font> fontArray;
    ArrayList<Integer> fontSizeArray;
    ArrayList<Color> textColorArray, textBackgroundColorArray, buttonOutlineColorArray, borderColorArray;


    public static void main(String[] args) {
        GUITask guiTask = new GUITask();
    }

    public GUITask(){
        frame = new JFrame();
        frame.setSize(900, 600);
        frame.setLayout(new BorderLayout());
        menuBar = new JMenuBar();

        fontOption = new JMenu("Font");
        fontSize = new JMenu("Font Size");
        textColor = new JMenu("Text Color");
        textBackgroundColor = new JMenu("Background Color");
        buttonOutlineColor = new JMenu("Outline Color");

        fontOptions = new ArrayList<JMenuItem>();
        fontSizes = new ArrayList<JMenuItem>();
        textColors = new ArrayList<JMenuItem>();
        textBackgroundColors = new ArrayList<JMenuItem>();
        buttonOutlineColors = new ArrayList<JMenuItem>();

        menuLayout = new GridLayout(1, 6);

        fontNamesArray = new ArrayList<String>();
        textColorNamesArray = new ArrayList<String>();
        textBackgroundColorNamesArray = new ArrayList<String>();
        buttonOutlineColorNamesArray = new ArrayList<String>();

        fontArray = new ArrayList<Font>();
        fontSizeArray = new ArrayList<Integer>();
        textColorArray = new ArrayList<Color>();
        textBackgroundColorArray = new ArrayList<Color>();
        buttonOutlineColorArray = new ArrayList<Color>();
        borderColorArray = new ArrayList<Color>();


        //fonts

        fontNamesArray.add("Times New Roman");
        fontNamesArray.add("Comic Sans MS");
        fontNamesArray.add("Courier");
        fontNamesArray.add("Dialog");

        for(int i=0;i<4;i++){
            fontArray.add(new Font(fontNamesArray.get(i), Font.PLAIN, 16));
            JMenuItem j = new JMenuItem(fontNamesArray.get(i));
            j.setFont(fontArray.get(i));
            j.addActionListener(this);
            fontOptions.add(j);
            fontOption.add(j);
        }
        currentFont = fontArray.get(0);

        //font sizes
        fontSizeArray.add(8);
        fontSizeArray.add(16);
        fontSizeArray.add(24);
        fontSizeArray.add(32);

        for(int i=0;i<4;i++){
            JMenuItem j = new JMenuItem(String.valueOf(fontSizeArray.get(i)));
            j.setFont(new Font(currentFont.getName(), Font.PLAIN, fontSizeArray.get(i)));
            j.addActionListener(this);
            fontSizes.add(j);
            fontSize.add(j);
        }
        currentFontSize = fontSizeArray.get(0);

        //text colors
        textColorNamesArray.add("Magenta");
        textColorNamesArray.add("Cyan");
        textColorNamesArray.add("Yellow");
        textColorNamesArray.add("Random");

        textColorArray.add(Color.magenta);
        textColorArray.add(Color.cyan);
        textColorArray.add(Color.yellow);
        textColorArray.add(new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256)));

        for(int i=0;i<4;i++){
            JMenuItem j = new JMenuItem(textColorNamesArray.get(i));
            j.setForeground(textColorArray.get(i));
            j.addActionListener(this);
            textColors.add(j);
            textColor.add(j);
        }

        //text background colors
        textBackgroundColorNamesArray.add("Magenta");
        textBackgroundColorNamesArray.add("Cyan");
        textBackgroundColorNamesArray.add("Yellow");
        textBackgroundColorNamesArray.add("Random");

        textBackgroundColorArray.add(Color.magenta);
        textBackgroundColorArray.add(Color.cyan);
        textBackgroundColorArray.add(Color.yellow);
        textBackgroundColorArray.add(new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256)));

        for(int i=0;i<4;i++){
            JMenuItem j = new JMenuItem(textBackgroundColorNamesArray.get(i));
            j.setBackground(textBackgroundColorArray.get(i));
            j.addActionListener(this);
            textBackgroundColors.add(j);
            textBackgroundColor.add(j);
        }

        //button outline colors
        buttonOutlineColorNamesArray.add("No Color");
        buttonOutlineColorNamesArray.add("Magenta");
        buttonOutlineColorNamesArray.add("Cyan");
        buttonOutlineColorNamesArray.add("Yellow");
        buttonOutlineColorNamesArray.add("Random");

        buttonOutlineColorArray.add(new Color(Color.TRANSLUCENT, Color.TRANSLUCENT, Color.TRANSLUCENT));
        buttonOutlineColorArray.add(Color.magenta);
        buttonOutlineColorArray.add(Color.cyan);
        buttonOutlineColorArray.add(Color.yellow);
        buttonOutlineColorArray.add(new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256)));

        for(int i=0;i<5;i++){
            JMenuItem j = new JMenuItem(buttonOutlineColorNamesArray.get(i));
            j.setBorder(new LineBorder(buttonOutlineColorArray.get(i), 3));
            j.addActionListener(this);
            buttonOutlineColors.add(j);
            buttonOutlineColor.add(j);
        }

        menuBar.add(fontOption);
        menuBar.add(fontSize);
        menuBar.add(textColor);
        menuBar.add(textBackgroundColor);
        menuBar.add(buttonOutlineColor);

        reset = new JButton("Reset");
        reset.addActionListener(this);
        menuBar.add(reset);

        north = new JButton("North");
        south = new JButton("South");
        east = new JButton("East");
        west = new JButton("West");

        queenPanel = new JPanel();
        queenLayout = new GridLayout();
        queenPanel.setLayout(queenLayout);
        
        buttonPanel = new JPanel();
        buttonLayout = new GridLayout();
        buttonPanel.setLayout(buttonLayout);

        reset.addActionListener(this);
        north.addActionListener(this);
        south.addActionListener(this);
        east.addActionListener(this);
        west.addActionListener(this);

        buttonPanel.add(north);
        buttonPanel.add(south);
        buttonPanel.add(east);
        buttonPanel.add(west);
        buttonPanel.add(reset);

        reset.setBorder(new LineBorder(buttonOutlineColorArray.get(0)));
        north.setBorder(new LineBorder(buttonOutlineColorArray.get(0)));
        south.setBorder(new LineBorder(buttonOutlineColorArray.get(0)));
        east.setBorder(new LineBorder(buttonOutlineColorArray.get(0)));
        west.setBorder(new LineBorder(buttonOutlineColorArray.get(0)));

        fontOption.setPreferredSize(new Dimension(fontOption.getPreferredSize().width+62, 25));
        fontOption.setBorderPainted(true);
        fontOption.setBorder(new LineBorder(buttonOutlineColorArray.get(0)));
        fontSize.setPreferredSize(new Dimension(fontSize.getPreferredSize().width+62, 25));
        fontSize.setBorderPainted(true);
        fontSize.setBorder(new LineBorder(buttonOutlineColorArray.get(0)));
        textColor.setPreferredSize(new Dimension(textColor.getPreferredSize().width+62, 25));
        textColor.setBorderPainted(true);
        textColor.setBorder(new LineBorder(buttonOutlineColorArray.get(0)));
        textBackgroundColor.setPreferredSize(new Dimension(textBackgroundColor.getPreferredSize().width+62, 25));
        textBackgroundColor.setBorderPainted(true);
        textBackgroundColor.setBorder(new LineBorder(buttonOutlineColorArray.get(0)));
        buttonOutlineColor.setPreferredSize(new Dimension(buttonOutlineColor.getPreferredSize().width+62, 25));
        buttonOutlineColor.setBorderPainted(true);
        buttonOutlineColor.setBorder(new LineBorder(buttonOutlineColorArray.get(0)));

        textArea = new JTextArea();

        textArea.setFont(new Font(currentFont.getName(), Font.PLAIN, currentFontSize));
        textArea.setForeground(textColorArray.get(3));
        textArea.setBackground(textBackgroundColorArray.get(3));
        textArea.setBorder(new LineBorder(buttonOutlineColorArray.get(4), 8));

        queenPanel.add(buttonPanel);
        queenPanel.add(menuBar);
        frame.add(queenPanel, BorderLayout.NORTH);
        frame.add(textArea, BorderLayout.CENTER);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == north){
            frame.remove(queenPanel);
            buttonLayout = new GridLayout(1, 5);
            queenLayout = new GridLayout(1, 2);
            buttonPanel.setLayout(buttonLayout);
            queenPanel.setLayout(queenLayout);
            menuBar.setLayout(new GridLayout(1, 6));
            frame.add(queenPanel, BorderLayout.NORTH);
        }
        if(e.getSource() == south){
            frame.remove(queenPanel);
            buttonLayout = new GridLayout(1, 5);
            queenLayout = new GridLayout(1, 2);
            buttonPanel.setLayout(buttonLayout);
            queenPanel.setLayout(queenLayout);
            menuBar.setLayout(new GridLayout(1, 6));
            frame.add(queenPanel, BorderLayout.SOUTH);
        }
        if(e.getSource() == east){
            frame.remove(queenPanel);
            buttonLayout = new GridLayout(5,1);
            queenLayout = new GridLayout(2,1);
            buttonPanel.setLayout(buttonLayout);
            queenPanel.setLayout(queenLayout);
            menuBar.setLayout(new GridLayout(6,1));
            frame.add(queenPanel, BorderLayout.EAST);
        }
        if(e.getSource() == west){
            frame.remove(queenPanel);
            buttonLayout = new GridLayout(5,1);
            queenLayout = new GridLayout(2,1);
            buttonPanel.setLayout(buttonLayout);
            queenPanel.setLayout(queenLayout);
            menuBar.setLayout(new GridLayout(6,1));
            frame.add(queenPanel, BorderLayout.WEST);
        }
        if(e.getSource() == reset){
            frame.remove(queenPanel);
            buttonLayout = new GridLayout(1, 5);
            queenLayout = new GridLayout(1, 2);
            buttonPanel.setLayout(buttonLayout);
            queenPanel.setLayout(queenLayout);
            menuBar.setLayout(new GridLayout(1, 6));
            frame.add(queenPanel, BorderLayout.NORTH);

            textArea.setText("");
            textArea.setFont(new Font(fontArray.get(0).getName(), Font.PLAIN, fontSizeArray.get(0)));
            textArea.setForeground(textColorArray.get(0));
            textArea.setBackground(textBackgroundColorArray.get(3));
            textArea.setBorder(new LineBorder(buttonOutlineColorArray.get(4), 8));

                
        }
        for(int i = 0;i<fontOptions.size();i++){
            if(e.getSource() == fontOptions.get(i)){
                currentFont = fontArray.get(i);
                textArea.setFont(new Font(currentFont.getName(), Font.PLAIN, currentFontSize));
            }
        }
        for(int i = 0;i<fontSizes.size();i++){
            if(e.getSource() == fontSizes.get(i)){
                currentFontSize = fontSizeArray.get(i);
                textArea.setFont(new Font(currentFont.getName(), Font.PLAIN, currentFontSize));
            }
        }
        for(int i = 0;i<textColors.size();i++){
            if(e.getSource() == textColors.get(i)){
                textArea.setForeground(textColorArray.get(i));
            }
        }
        for(int i = 0;i<textBackgroundColors.size();i++){
            if(e.getSource() == textBackgroundColors.get(i)){
                textArea.setBackground(textBackgroundColorArray.get(i));
            }
        }
        for(int i = 0;i<buttonOutlineColors.size();i++){
            if(e.getSource() == buttonOutlineColors.get(i)){
                textArea.setBorder(new LineBorder(buttonOutlineColorArray.get(i), 8));
            }
        }

        frame.revalidate();
        frame.repaint();
        
    }

    
}
