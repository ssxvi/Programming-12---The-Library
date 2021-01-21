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
    JLabel label, label1, label2, label3;
    JComboBox<String> cb1 = new JComboBox<String>(unFinList.toArray(new String[unFinList.size()]));
    JComboBox<String> cb2 = new JComboBox<String>(finList.toArray(new String[finList.size()]));
    JButton button0, button1, button2, button3;
    JTextField field;
    JCheckBox checkbox;
    String lastSelectedItem;

    JComboBox<String> lastCb = cb1;
    ArrayList<String> lastList = unFinList;

    static ArrayList<String> unFinList = new ArrayList<String>();
    static ArrayList<String> finList = new ArrayList<String>();
    static int index;
    static String input = "";


    library() {

        frame = new JFrame("this looks bad");


        panel = new JPanel(new GridBagLayout());
    

        label = new JLabel("Library Book Sorter!");
        label1 = new JLabel("Welcome to program!");   
        label2 = new JLabel("Unfinished Books");
        label3 = new JLabel("Finished Books!");  
        field = new JTextField("Enter book title here!");

        button0 = new JButton("Move to unfinished");
        button1 = new JButton("Move to finished");
        button2 = new JButton("Remove");
        button3 = new JButton("Add book!");
        checkbox = new JCheckBox("Finished?");

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


        // 0
        c.gridy = 0;   
        c.gridwidth = 4;


        c.gridx = 0;

        panel.add(label, c);




        // 1
        c.gridy = 1;   
        c.gridwidth = 2;


        c.gridx = 0;
        panel.add(field, c);
        
        c.gridx = 2;
        c.gridwidth = 1;
        panel.add(checkbox, c);
        checkbox.addActionListener(this);


        c.gridx = 3;

        panel.add(button3, c);  
        button3.addActionListener(this);

        // 2
        c.gridy = 2;   
        c.gridwidth = 2;


        c.gridx = 0;
        panel.add(label2, c);

        c.gridx = 2;
        panel.add(label3, c);




        // 3
        c.gridy = 3;  


        c.gridx = 0;
        cb1.setSelectedIndex(-1);
        cb1.addActionListener(this);
        panel.add(cb1, c);

        c.gridx = 2;
        cb2.setSelectedIndex(-1);
        cb2.addActionListener(this);
        panel.add(cb2, c);





        // 4
        c.gridy = 4;   
        c.gridwidth = 1;

        c.gridx = 0;
        panel.add(button0, c);
        button0.addActionListener(this);

        c.gridx = 1;
        panel.add(button1, c);
        button1.addActionListener(this);

        c.gridx = 2;
        panel.add(button2, c);  
        button2.addActionListener(this);



        // 5
        c.gridy = 5; 
        c.gridx = 0;
        c.gridwidth = 4;
        panel.add(label1, c);

        c.gridy = 6;

        Box.createHorizontalStrut(200);



        frame.pack();
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

     public static String getInput(JTextField field){
        try  {

           return field.getText();

        } catch (Exception e){

            System.err.println("Yikes bud");

        }

        return "Error";
    }   


    @Override
    public void actionPerformed(ActionEvent e) {

        if (lastCb.getSelectedItem() != null){
            lastSelectedItem = lastCb.getSelectedItem().toString();
        } else {
            System.out.println("cool the combo was empty");
        }
        
        System.out.println(e.getSource());


        if (e.getSource() == cb1){
            lastCb = cb1;
            lastList = unFinList;

            System.out.println("cb1 SWITCH");
        }

        if (e.getSource() == cb2){
            lastCb = cb2;
            lastList = finList;

            System.out.println("cb2 SWITCH");
        }

        input = getInput(field);
        System.out.println(input);

        if (e.getSource() == button0){
            
            if (lastCb == cb2){
                addTo(lastSelectedItem, cb1, unFinList);
                removeFrom(lastSelectedItem, cb2, finList);
                label1.setText("Book moved!");
            } else {
                label1.setText("Selection Invalid!!");
            }

            lastCb = cb1;

        } else if (e.getSource() == button1){

            if (lastCb == cb1){
                addTo(lastSelectedItem, cb2, finList);
                removeFrom(lastSelectedItem, cb1, unFinList);
                label1.setText("Book moved!");

            } else {

                label1.setText("Selection Invalid!!");
            }
        
            lastCb = cb2;

        } else if (e.getSource() == button2){

            if (lastList.size() > 0){
                removeFrom(lastSelectedItem, lastCb, lastList);
                label1.setText("Book removed!");
            } else if (lastList.size() == 0){
                label1.setText("Error! That library is already empty!");
            }

        } else if (e.getSource() == button3){

            if (!field.getText().equals("")){ //it's literally equal to null why this code still runs
                if(checkbox.isSelected()){

                    addTo(input, cb2, finList);
                    cb2.setSelectedIndex(finList.size()-1);
    
                } else {
    
                    addTo(input, cb1, unFinList);
                    cb1.setSelectedIndex(unFinList.size()-1);
                }
    
                label1.setText("Book added!");
                System.out.println(field.getText());

            } else {

                label1.setText("Error! Book Name is invalid!");

            }

            field.setText("");

        }

    }
    

    public static void main(String[] args) throws Exception {
        new library();
    }


}


/*

        // 3
        c.gridy = 3;  


        c.gridx = 0;
        cb1.setSelectedIndex(-1);
        cb1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                lastCb = cb1;
                lastList = unFinList;
                System.out.println("CB1 CHANGE");
            }
        });
        panel.add(cb1, c);

        c.gridx = 2;
        cb2.setSelectedIndex(-1);
        cb2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                lastCb = cb2;
                lastList = finList;
                System.out.println("CB2 CHANGE");
            }
        });
        panel.add(cb2, c);

*/