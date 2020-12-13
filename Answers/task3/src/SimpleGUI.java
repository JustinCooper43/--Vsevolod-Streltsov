import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.SplittableRandom;

public class SimpleGUI extends JFrame {

    public JButton button1 = new JButton("Поиск");
    public JButton button2 = new JButton("Обновить");
    public JTextField input = new JTextField("", 3);
    public JTextField output = new JTextField("", 3);
    public JLabel inputLabel = new JLabel("Исходный массив");
    public JLabel outputLabel = new JLabel("Элементы кратные трём");
    public static int[] array = new int[15];

    public SimpleGUI() {
        super("Task #3");
        {

            this.setBounds(20, 20, 500, 200);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Container container = this.getContentPane();
            container.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
           this.getContentPane().setBackground(Color.CYAN);

            container.add(inputLabel);
            container.add(input);
            container.add(outputLabel);
            container.add(output);

            container.add(button1);
            container.add(button2);

            button1.addActionListener(new SearchNumber());
            button2.addActionListener(new SearchNumber());

            getArray();

            input.setText(Arrays.toString(array));
        }


    }

    public static void getArray() {
        SplittableRandom rand = new SplittableRandom();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(-100, 100);
        }
    }

    public class SearchNumber implements ActionListener {
        public void actionPerformed(ActionEvent e) {


            if (e.getSource() == button1) {
                ArrayList<Integer> list = resultArray(array);
                Integer[] array2 = list.toArray(new Integer[list.size()]);
                output.setText(Arrays.toString(array2));

            }else if (e.getSource()==button2){
                input.setText(null);
                getArray();
                input.setText(Arrays.toString(array));
            }

        }

        public ArrayList<Integer> resultArray(int[] array) {
            ArrayList<Integer> result = new ArrayList<>();
            for (int var : array) {
                if (var % 3 == 0) {
                    result.add(var);
                }

            }
            return result;
        }
    }

}
