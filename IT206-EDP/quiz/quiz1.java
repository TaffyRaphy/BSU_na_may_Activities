
//import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class quiz1 {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Calculator"); //Calculator title ng frame
        JLabel firstLabel, secondLabel,thirdLabel, resultLabel;
        JTextField firstNum, secondNum, thirdNum, result;
        JButton addBtn, subBtn, multBtn, divBtn;
        
        frame.setSize(800,600);
        frame.setLayout(null); //pwede pa maiba
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        firstLabel = new JLabel("First Number");
        frame.add(firstLabel);
        firstLabel.setBounds(75, 50, 100, 50); //(x axis, y axis, width, height)
        //firstLabel.setFont(new Font("Arial",Font.BOLD,24));
        
        firstNum = new JTextField();
        frame.add(firstNum);
        firstNum.setBounds(450, 50, 250, 50);
        
        secondLabel = new JLabel("Second Number");
        frame.add(secondLabel);
        secondLabel.setBounds(75, 130, 100, 50);
        
        
        
        secondNum = new JTextField();
        frame.add(secondNum);
        secondNum.setBounds(450, 130, 250, 50);
        
        thirdLabel = new JLabel("Third Number");
        frame.add(thirdLabel);
        thirdLabel.setBounds(75, 210, 100, 50);
        
        thirdNum = new JTextField();
        frame.add(thirdNum);
        thirdNum.setBounds(450 ,210, 250, 50);
        
        
        
        addBtn = new JButton("Addition");
        subBtn = new JButton("Subtraction");
        multBtn = new JButton ("Multiplication");
        divBtn = new JButton ("Division");
        
        frame.add(addBtn);
        frame.add(subBtn);
        frame.add(multBtn);
        frame.add(divBtn);
        
        addBtn.setBounds(200, 300, 250, 50);
        subBtn.setBounds(450, 300, 250, 50);
        multBtn.setBounds(200, 360, 250, 50);
        divBtn.setBounds(450, 360, 250, 50);
        
        resultLabel = new JLabel("Result:");
        frame.add(resultLabel);
        resultLabel.setBounds(75, 420, 100, 50);
        
        result = new JTextField();
        frame.add(result);
        result.setBounds(450, 425, 250, 50);
        result.setEditable(false);
        
        
        addBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int num1 = Integer.parseInt(firstNum.getText());
                int num2 = Integer.parseInt(secondNum.getText());
                int num3 = Integer.parseInt(thirdNum.getText());
                
                int sum = num1 + num2 + num3;
                
                result.setText(String.valueOf(sum));
            }
        });
        
        subBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int num1 = Integer.parseInt(firstNum.getText());
                int num2 = Integer.parseInt(secondNum.getText());
                int num3 = Integer.parseInt(thirdNum.getText());
                
                int difference = num1 - num2 - num3;
                
                result.setText(String.valueOf(difference));
            }
        });
        
        multBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(firstNum.getText());
                int num2 = Integer.parseInt(secondNum.getText());
                int num3 = Integer.parseInt(thirdNum.getText());
                
                int product = num1 * num2 * num3;
                
                result.setText(String.valueOf(product));
            }
        });
        
        divBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(firstNum.getText());
                int num2 = Integer.parseInt(secondNum.getText());
                int num3 = Integer.parseInt(thirdNum.getText());
                
                int quotient = num1/num2/num3;
                
                result.setText(String.valueOf(quotient));
            }
        });
    }
}

