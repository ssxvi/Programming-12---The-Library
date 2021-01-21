import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Collections;
import java.awt.GridBagConstraints;  
import java.awt.GridBagLayout;

public class library implements ActionListener{

    JFrame frame;
    JPanel panel;
    JLabel label, label1;
    JComboBox<String> cb1 = new JComboBox<String>(unFinList.toArray(new String[unFinList.size()]));
    JComboBox<String> cb2 = new JComboBox<String>(finList.toArray(new String[finList.size()]));
    JButton button, button1, button2;
    JTextField field;
    static ArrayList<String> unFinList = new ArrayList<String>();
    static ArrayList<String> finList = new ArrayList<String>();
    static int index;
    static int input = 0;


    library() {

        frame = new JFrame("this looks bad");


        panel = new JPanel(new GridBagLayout());
    

        label = new JLabel("Library Book Sorter!");
        label1 = new JLabel("Welcome to program!");   
        field = new JTextField("Enter book title here!");

        button = new JButton("Move to unfinished");
        button1 = new JButton("Move to finished");
        button2 = new JButton("Remove");
        frame.add(panel);

        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.BOTH; //makes element fill maximum horizontal space
        label.setHorizontalAlignment(SwingConstants.CENTER); //centers element

        //Below is just the x and y coordinates of the element, as well as the size of the element


        label.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        c.insets = new Insets(
        10,
        10,
        10,
        10);

        c.weightx = 1;
        c.weighty = 1;
             
        c.gridwidth = 1;
        c.gridx = 1 ;
        c.gridy = 0;
        panel.add(label, c);

        c.gridy = 5;
        panel.add(label1, c);




        c.gridy = 3;

        c.gridwidth = 1;
        c.gridx = 0;
        panel.add(cb1, c);

        c.gridwidth = 1;
        c.gridx = 2;
        panel.add(cb2, c);

        c.gridx = 1;
        panel.add(field, c);

        //Buttons
        c.gridy = 4;

        c.gridx = 0;
        panel.add(button, c);
        button.addActionListener(this);
   
        c.gridx = 2;
        panel.add(button1, c);
        button1.addActionListener(this);

        c.gridx = 1;
        panel.add(button2, c);  
        button2.addActionListener(this);


        frame.setSize(500,300);
        //frame.pack();
        frame.setVisible(true);

    

    }

    public static void removeFrom(String title, JComboBox<String> cb, ArrayList<String> list){
        cb.removeItem(title);
        list.remove(title);
    }

     public static void addTo(String title, JComboBox<String> cb, ArrayList<String> list){
       cb.addItem(title);
       list.add(title);
     }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println(input);

        if (e.getSource() == button){



        } else if (e.getSource() == button1){

            if (){

            }

        } else if (e.getSource() == button2){



        }

    }
    
    public static void main(String[] args) throws Exception {
        new library();
    }


}
