
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {

    public JButton button1 = new JButton("Пуск");
    public JTextField input = new JTextField("", 3);
    public JTextField output = new JTextField("", 3);
    public JLabel inputLabel = new JLabel("Ввод");
    public JLabel outputLabel = new JLabel("Вывод");

    public GUI() {
        super("Task #1");
        this.setBounds(10, 10, 400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        container.add(button1);
        container.add(inputLabel);
        container.add(input);
        container.add(outputLabel);
        container.add(output);

//        button1.setSize(1, 1);

        button1.addActionListener(new ButtonEventListener());
        container.add(button1);
    }

    public class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button1) {


                try {
                    output.setText(result (Integer.parseInt(input.getText())));
                } catch (Exception ex) {
                    output.setText ("Введённый символ не является числом");
                }

                input.setText(null);

            }

        }
    }


    public static String result(int number) {
        String str = "";
        if (number > 7) {
            str = "Привет";
        } else if (number < 7) {
            str = "Попробуй ещё раз";
        } else if (number == 7) {
            str = "Уже близко";
        }
        return str;
    }
}
