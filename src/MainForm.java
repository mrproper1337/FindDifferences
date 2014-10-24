import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Mon Oct 13 22:01:57 EEST 2014
 */



/**
 * @author unknown
 */
public class MainForm extends JFrame {


    Image select=new ImageIcon("res/select.png").getImage();
    static ArrayList<Integer[]> map=new ArrayList();
    static ArrayList<Integer[]> current_m=new ArrayList();
    static ArrayList<Integer> check=new ArrayList();
    int task_n=1;
    int find_n=0;

    public MainForm() throws FileNotFoundException {
        initComponents();
        initmap(true);
        initmap(task_n);
    }

    private void label2MouseClicked(MouseEvent e) {

        int[] result=cmp_m(e.getX(),e.getY());
        Graphics gr1=label2.getGraphics();
        Graphics gr2=label3.getGraphics();

        if(result[0]!=-1){
            if (gr1 != null && gr2 != null) {
                gr1.drawImage(select,result[1],result[0],null);
                gr2.drawImage(select,result[1],result[0],null);
            }
            label1.setText("Знайдено "+find_n+"/4");
        }
    }

    private void button_nextActionPerformed(ActionEvent e) {
        if(task_n!=3){
            task_n++;
            initmap(task_n);
            find_n=0;
            check.clear();
            label1.setText("Знайдено "+find_n+"/4");
            label2.setIcon(new ImageIcon("res/dom/pic"+task_n+"a.png"));
            label3.setIcon(new ImageIcon("res/dom/pic" + task_n + "b.png"));
            label4.setText("Завдання "+task_n);
        }
    }

    private void button_prevActionPerformed(ActionEvent e) {
        if(task_n!=1){
            task_n--;
            initmap(task_n);
            find_n=0;
            check.clear();
            label1.setText("Знайдено "+find_n+"/4");
            label2.setIcon(new ImageIcon("res/dom/pic"+task_n+"a.png"));
            label3.setIcon(new ImageIcon("res/dom/pic"+task_n+"b.png"));
            label4.setText("Завдання "+task_n);
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ash Clarck
        button_prev = new JButton();
        button_next = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();

        //======== this ========
        Container contentPane = getContentPane();

        //---- button_prev ----
        button_prev.setText("\u041f\u043e\u043f\u0435\u0440\u0435\u0434\u043d\u0454");
        button_prev.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        button_prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button_prevActionPerformed(e);
            }
        });

        //---- button_next ----
        button_next.setText("\u041d\u0430\u0441\u0442\u0443\u043f\u043d\u0435");
        button_next.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        button_next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button_nextActionPerformed(e);
            }
        });

        //---- label1 ----
        label1.setText("\u0417\u043d\u0430\u0439\u0434\u0435\u043d\u043e 0/4");
        label1.setFont(new Font("Calibri", Font.BOLD, 24));
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        //---- label2 ----
        label2.setIcon(new ImageIcon("C:\\Users\\mrproper\\IdeaProjects\\FindDifferences\\res\\pic1a.png"));
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setHorizontalTextPosition(SwingConstants.CENTER);
        label2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label2MouseClicked(e);
            }
        });

        //---- label3 ----
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setIcon(new ImageIcon("C:\\Users\\mrproper\\IdeaProjects\\FindDifferences\\res\\pic1b.png"));
        label3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label2MouseClicked(e);
            }
        });

        //---- label4 ----
        label4.setText("\u0417\u0430\u0432\u0434\u0430\u043d\u043d\u044f 1");
        label4.setFont(new Font("Calibri", Font.BOLD, 24));
        label4.setHorizontalAlignment(SwingConstants.CENTER);

        //---- radioButton1 ----
        radioButton1.setText("\u0414\u043e\u043c\u0456\u043d\u043e");
        radioButton1.setSelected(true);

        //---- radioButton2 ----
        radioButton2.setText("\u0424\u043e\u0442\u043e");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(74, 74, 74)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(button_prev, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(label2)
                            .addGap(34, 34, 34)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(button_next, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(label3)))
                    .addGap(81, 81, 81))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(radioButton1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(radioButton2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
                    .addGap(14, 14, 14))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addComponent(radioButton1)
                                .addComponent(radioButton2))))
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(label2)
                        .addComponent(label3))
                    .addGap(0, 70, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(button_prev)
                        .addComponent(button_next))
                    .addContainerGap(11, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButton1);
        buttonGroup1.add(radioButton2);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ash Clarck
    private JButton button_prev;
    private JButton button_next;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private static void initmap(boolean mode)throws FileNotFoundException{

        if(mode){
            File difmap=new File("res/dom/difmap_d.txt");
            ArrayList<Integer> il=new ArrayList<Integer>();
            Integer[] arr=new Integer[0];

            try {

                BufferedReader in = new BufferedReader(new FileReader( difmap.getAbsoluteFile()));
                try {
                    String s;
                    while ((s = in.readLine()) != null) {
                        for(char a:s.toCharArray())il.add(Character.getNumericValue(a));
                        map.add(il.toArray(arr));
                        il.clear();
                    }
                } finally {

                    in.close();
                }
            } catch(IOException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            File difmap=new File("res/dom/difmap_f.txt");
            ArrayList<Integer> il=new ArrayList<Integer>();
            Integer[] arr=new Integer[0];
        }

    }
    private static void initmap(int task){
        int mx;
        int my;

        mx=task*2-1;
        my=task*2-2;

        current_m.add(0,map.get(my));
        current_m.add(1,map.get(mx));


    }
    private int[] cmp_m(int x,int y){

        int px=(x-4)/30;
        int py=(y-4)/30;
        int[] ret=new int[2];
        ret[0]=-1;

        for(int i=0;i<current_m.get(0).length;i++)
            if(py==current_m.get(0)[i] && px==current_m.get(1)[i]){
                ret[0]=py*30+4;
                ret[1]=px*30+4;
                if(!check.contains(i)){
                    find_n++;
                    check.add(i);
                }
            }

     return ret;
    }

}
