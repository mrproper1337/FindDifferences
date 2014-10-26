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


    static ArrayList<Integer[]> map=new ArrayList();
    static ArrayList<Integer[]> current_m=new ArrayList();
    static ArrayList<Integer> check=new ArrayList();

    boolean mode=true;
    int task_n=1;
    int find_n=0;

    public MainForm() throws FileNotFoundException {
        initComponents();
        initmap(true);
        initmap(task_n);
    }

    private void label2MouseClicked(MouseEvent e){
        int x,y;
        if(mode){
            x=(e.getX()-4)/30;
            y=(e.getY()-4)/30;
        }else{
            x=e.getX()/40;
            y=e.getY()/40;
        }
        Graphics gr1=label2.getGraphics();
        Graphics gr2=label3.getGraphics();

//        if(!mode)for(int i=0;i<4;i++){
//            Image select=new ImageIcon("res/select2.png").getImage();
//            gr1.drawImage(select,(current_m.get(1)[i])*40,(current_m.get(0)[i])*40,null);
//            gr2.drawImage(select,(current_m.get(1)[i])*40,(current_m.get(0)[i])*40,null);
//        }

        if(cmp_m(x,y)){
            if (gr1 != null && gr2 != null) {
                if(mode){
                    Image select=new ImageIcon("res/select1.png").getImage();
                    gr1.drawImage(select,x*30+4,y*30+4,null);
                    gr2.drawImage(select,x*30+4,y*30+4,null);
                }else{
                    Image select=new ImageIcon("res/select2.png").getImage();
                    gr1.drawImage(select,x*40,y*40,null);
                    gr2.drawImage(select,x*40,y*40,null);
                }

            }
            label1.setText("Знайдено "+find_n+"/4");
            if(find_n==4)JOptionPane.showMessageDialog(null,"Завдання виконано");
        }
    }

    private void button_nextActionPerformed(ActionEvent e) {
        if(task_n!=3){
            task_n++;
            initmap(task_n);
            reset();
        }
    }

    private void button_prevActionPerformed(ActionEvent e) {
        if(task_n!=1){
            task_n--;
            initmap(task_n);
            reset();
        }
    }

    private void radioButton1ActionPerformed(ActionEvent e) {
        if(radioButton1.isSelected())mode=true;
        else mode=false;
        try {
            initmap(mode);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        initmap(task_n);
        reset();

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ash Coopeer
        button_prev = new JButton();
        button_next = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();

        //======== this ========
        setTitle("\u0417\u043d\u0430\u0439\u0434\u0438 \u0432\u0456\u0434\u043c\u0456\u043d\u043d\u043e\u0441\u0442\u0456");
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
        label2.setIcon(new ImageIcon("C:\\Users\\mrproper\\IdeaProjects\\FindDifferences\\res\\dom\\pic1a.png"));
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
        label3.setIcon(new ImageIcon("C:\\Users\\mrproper\\IdeaProjects\\FindDifferences\\res\\dom\\pic1b.png"));
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
        radioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radioButton1ActionPerformed(e);
            }
        });

        //---- radioButton2 ----
        radioButton2.setText("\u0424\u043e\u0442\u043e");
        radioButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radioButton1ActionPerformed(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(radioButton1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(radioButton2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
                            .addGap(14, 14, 14))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(button_prev, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 277, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(button_next, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label3))
                            .addContainerGap())))
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
                    .addGap(53, 53, 53)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(label2)
                        .addComponent(label3))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button_prev)
                        .addComponent(button_next))
                    .addContainerGap())
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
    // Generated using JFormDesigner Evaluation license - Ash Coopeer
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
        if(!map.isEmpty())map.clear();
        File difmap=null;
        ArrayList<Integer> il=new ArrayList<Integer>();
        Integer[] arr=new Integer[0];
        if(mode)difmap=new File("res/dom/difmap_d.txt");
        else difmap=new File("res/foto/difmap_f.txt");

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
    private static void initmap(int task){
        int mx;
        int my;

        mx=task*2-1;
        my=task*2-2;

        current_m.add(0,map.get(my));
        current_m.add(1,map.get(mx));


    }
    private boolean cmp_m(int x,int y){

        for(int i=0;i<current_m.get(0).length;i++)
            if(y==current_m.get(0)[i] && x==current_m.get(1)[i] && !check.contains(i)){
                find_n++;
                check.add(i);
                return true;
            }
     return false;
    }
    private void reset(){
        find_n=0;
        check.clear();
        label1.setText("Знайдено "+find_n+"/4");
        label4.setText("Завдання "+task_n);
        if(mode){
            label2.setIcon(new ImageIcon("res/dom/pic"+task_n+"a.png"));
            label3.setIcon(new ImageIcon("res/dom/pic" + task_n + "b.png"));
        }
        else{
            label2.setIcon(new ImageIcon("res/foto/"+task_n+"a.png"));
            label3.setIcon(new ImageIcon("res/foto/"+task_n + "b.png"));
        }
    }
}
