import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener{
    /*----------------------------declare the components----------------------------*/
    double num1=0,num2=0,result=0;
    String num1S="",num2S="",resultS="";
    char operator=' ';

    JTextField screen = new JTextField();
    JTextField operatorScrn = new JTextField();
    

    JButton b00 = new JButton("00");
    JButton b0 = new JButton("0");
    JButton b1 = new JButton("1");
    JButton b2 = new JButton("2");
    JButton b3 = new JButton("3");
    JButton b4 = new JButton("4");
    JButton b5 = new JButton("5");
    JButton b6 = new JButton("6");
    JButton b7 = new JButton("7");
    JButton b8 = new JButton("8");
    JButton b9 = new JButton("9");
    
    JButton bPlus = new JButton("+");
    JButton bMinus = new JButton("-");
    JButton bMultiply = new JButton("\u00D7");
    JButton bDivide = new JButton("\u00F7");
    JButton bEqual = new JButton("=");
    JButton bClear = new JButton("C");
    JButton bDot = new JButton(".");
    JButton bBack = new JButton("<B");
    JButton bPercent = new JButton("%");
    JButton bSign = new JButton("-() or -ve");

    public Calculator(){
 
        setLayout(null);

        screen.setBounds(15, 15, 355, 80);
        screen.setFont(new Font("Arial",Font.BOLD,35));
        add(screen);

        operatorScrn.setHorizontalAlignment(SwingConstants.CENTER);
        operatorScrn.setBounds(279, 105, 88, 40);
        operatorScrn.setFont(new Font("Arial",Font.BOLD,30));
        add(operatorScrn);

        bSign.setBounds(15, 105, 255, 40);
        bSign.setFont(new Font("Arial",Font.BOLD,30));
        add(bSign);
        bSign.addActionListener(this);

        bClear.setBounds(15, 150, 78, 50);
        bClear.setFont(new Font("Arial",Font.BOLD,35));
        add(bClear);
        bClear.addActionListener(this);

        bPercent.setBounds(103, 150, 78, 50);
        bPercent.setFont(new Font("Arial",Font.BOLD,35));
        add(bPercent);
        bPercent.addActionListener(this);

        bBack.setBounds(191, 150, 78, 50);
        bBack.setFont(new Font("Arial",Font.BOLD,35));
        add(bBack);
        bBack.addActionListener(this);

        bDivide.setBounds(279, 150, 88, 50);
        bDivide.setFont(new Font("Arial",Font.BOLD,35));
        add(bDivide);
        bDivide.addActionListener(this);

        b7.setBounds(15, 210, 78, 50);
        b7.setFont(new Font("Arial",Font.BOLD,35));
        add(b7);
        b7.addActionListener(this);

        b8.setBounds(103, 210, 78, 50);
        b8.setFont(new Font("Arial",Font.BOLD,35));
        add(b8);
        b8.addActionListener(this);

        b9.setBounds(191, 210, 78, 50);
        b9.setFont(new Font("Arial",Font.BOLD,35));
        add(b9);
        b9.addActionListener(this);

        bMultiply.setBounds(279, 210, 88, 50);
        bMultiply.setFont(new Font("Arial",Font.BOLD,35));
        add(bMultiply);
        bMultiply.addActionListener(this);

        b4.setBounds(15, 270, 78, 50);
        b4.setFont(new Font("Arial",Font.BOLD,35));
        add(b4);
        b4.addActionListener(this);

        b5.setBounds(103, 270, 78, 50);
        b5.setFont(new Font("Arial",Font.BOLD,35));
        add(b5);
        b5.addActionListener(this);
        

        b6.setBounds(191, 270, 78, 50);
        b6.setFont(new Font("Arial",Font.BOLD,35));
        add(b6);
        b6.addActionListener(this);

        bMinus.setBounds(279, 270, 88, 50);
        bMinus.setFont(new Font("Arial",Font.BOLD,35));
        add(bMinus);
        bMinus.addActionListener(this);

        b1.setBounds(15, 330, 78, 50);
        b1.setFont(new Font("Arial",Font.BOLD,35));
        add(b1);
        b1.addActionListener(this);

        b2.setBounds(103, 330, 78, 50);
        b2.setFont(new Font("Arial",Font.BOLD,35));
        add(b2);
        b2.addActionListener(this);

        b3.setBounds(191, 330, 78, 50);
        b3.setFont(new Font("Arial",Font.BOLD,35));
        add(b3);
        b3.addActionListener(this);

        bPlus.setBounds(279, 330, 88, 50);
        bPlus.setFont(new Font("Arial",Font.BOLD,35));
        add(bPlus);
        bPlus.addActionListener(this);

        b00.setBounds(15, 390, 78, 50);
        b00.setFont(new Font("Arial",Font.BOLD,35));
        add(b00);
        b00.addActionListener(this);

        b0.setBounds(103, 390, 78, 50);
        b0.setFont(new Font("Arial",Font.BOLD,35));
        add(b0);
        b0.addActionListener(this);

        bDot.setBounds(191, 390, 78, 50);
        bDot.setFont(new Font("Arial",Font.BOLD,35));
        add(bDot);
        bDot.addActionListener(this);

        bEqual.setBounds(279, 390, 88, 50);
        bEqual.setFont(new Font("Arial",Font.BOLD,35));
        add(bEqual);
        bEqual.addActionListener(this);



        /*----------------------------set the frame----------------------------*/
        setSize(400,500);
        setVisible(true);
        setLocation(450,75);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==bClear){
            num1=0;
            num2=0;
            result=0;
            num1S="";
            num2S="";
            resultS="";
            screen.setText("");
            operatorScrn.setText("");
        }
        if(ae.getSource()==bBack){
            String screenS=screen.getText();
            if(screenS.length()>0){
                screenS=screenS.substring(0,screenS.length()-1);
                screen.setText(screenS);
            }
        }
        if(ae.getSource()==b00){
            if(screen.getText().length()==0)
                screen.setText("0");
            else if(screen.getText().equals("0"))
                screen.setText("0");
            else
                screen.setText(screen.getText()+"00");
        }
        if(ae.getSource()==b0){
            if(screen.getText().length()==0)
                screen.setText("0");
            else if(screen.getText().equals("0"))
                screen.setText("0");
            else
                screen.setText(screen.getText()+"0");
        }
        if(ae.getSource()==b1){
            screen.setText(screen.getText()+"1");
        }
        if(ae.getSource()==b2){
            screen.setText(screen.getText()+"2");
        }
        if(ae.getSource()==b3){
            screen.setText(screen.getText()+"3");
        }
        if(ae.getSource()==b4){
            screen.setText(screen.getText()+"4");
        }
        if(ae.getSource()==b5){
            screen.setText(screen.getText()+"5");
        }
        if(ae.getSource()==b6){
            screen.setText(screen.getText()+"6");
        }
        if(ae.getSource()==b7){
            screen.setText(screen.getText()+"7");
        }
        if(ae.getSource()==b8){
            screen.setText(screen.getText()+"8");
        }
        if(ae.getSource()==b9){
            screen.setText(screen.getText()+"9");
        }
        if(ae.getSource()==bDot){
            if(screen.getText().indexOf(".")==-1){
                if(screen.getText().length()==0)
                    screen.setText("0.");
                else
                    screen.setText(screen.getText()+".");
            }else{
                JOptionPane.showMessageDialog(null,"You can't add more than one dot");
            }
        }
        if(ae.getSource()==bPlus){
            if(screen.getText().length()==0){
                JOptionPane.showMessageDialog(null,"Please enter a number first");
            }
            else{
                num1=Double.parseDouble(screen.getText());
                num1S=screen.getText();
                screen.setText("");
                operator='+';
                operatorScrn.setText("+");
            }
        }
        if(ae.getSource()==bMinus){
            if(screen.getText().length()==0){
                JOptionPane.showMessageDialog(null,"Please enter a number first");
            }
            else{
                num1=Double.parseDouble(screen.getText());
                num1S=screen.getText();
                screen.setText("");
                operator='-';
                operatorScrn.setText("-");
            }
        }
        if(ae.getSource()==bMultiply){
            if(screen.getText().length()==0){
                JOptionPane.showMessageDialog(null,"Please enter a number first");
            }
            else{
                num1=Double.parseDouble(screen.getText());
                num1S=screen.getText();
                screen.setText("");
                operator='*';
                operatorScrn.setText("\u00D7");
            }
        }
        if(ae.getSource()==bDivide){
            if(screen.getText().length()==0){
                JOptionPane.showMessageDialog(null,"Please enter a number first");
            }
            else{
                num1=Double.parseDouble(screen.getText());
                num1S=screen.getText();
                screen.setText("");
                operator='/';
                operatorScrn.setText("\u00F7");
            }
        }
        if(ae.getSource()==bPercent){
            if(screen.getText().length()==0){
                JOptionPane.showMessageDialog(null,"Please enter a number first");
            }
            else{
                num1=Double.parseDouble(screen.getText());
                num1S=screen.getText();
                screen.setText("");
                operator='%';
                operatorScrn.setText("%");
            }
        }
        if(ae.getSource()==bSign){
            if(screen.getText().length()==0){
                screen.setText(screen.getText()+"-");
            }
            else{
                JOptionPane.showMessageDialog(null,"-() can only be use before entering a number");
            }
        }
        if(ae.getSource()==bEqual){
            if(screen.getText().length()==0){
                JOptionPane.showMessageDialog(null,"Please enter a number first");
            }
            else{
                num2=Double.parseDouble(screen.getText());
                num2S=screen.getText();
                operatorScrn.setText("");
                switch(operator){
                    case '+':
                        result=num1+num2;
                        resultS=""+result;
                        screen.setText(resultS);
                        break;
                    case '-':
                        result=num1-num2;
                        screen.setText(""+result);
                        break;
                    case '*':
                        result=num1*num2;
                        resultS=""+result;
                        screen.setText(resultS);
                        break;
                    case '/':
                        if(num2==0){
                            JOptionPane.showMessageDialog(null,"You can't divide by zero");
                            screen.setText("");
                        }
                        else{
                            result=num1/num2;
                            resultS=""+result;
                            screen.setText(resultS);
                        }
                        break;
                    case '%':
                        result=num1*(num2/100);
                        resultS=String.valueOf(result);
                        screen.setText(resultS);
                        break;
                }
            }
        }

    }
    public static void main(String[] args){
        new Calculator();
    }
}
