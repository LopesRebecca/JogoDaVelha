import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class JogoDaVelha implements ActionListener {

    Random aleatorio = new Random();
    JFrame frame = new JFrame();
    JPanel painel = new JPanel();
    JPanel botaoPainel = new JPanel();
    JLabel texto = new JLabel();
    JButton[] grelha = new JButton[9];


    boolean jogador1;

    JogoDaVelha() {

        //designer frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(255, 255, 255));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        //designer texto
        texto.setBackground(new Color(255, 255, 255));
        texto.setForeground(new Color(0, 0, 0));
        texto.setFont(new Font("Times new Roman", Font.BOLD, 75));
        texto.setHorizontalAlignment(JLabel.CENTER);
        texto.setText("Jogo da Velha");
        texto.setOpaque(true);

        //designer painel
        painel.setLayout(new BorderLayout());
        painel.setBounds(0, 0, 800, 100);

        //botão do painel
        botaoPainel.setLayout(new GridLayout(3, 3));
        botaoPainel.setBackground(new Color(254, 254, 254));

        //criando a grelha
        for (int i = 0; i < 9; i++) {
            grelha[i] = new JButton();
            botaoPainel.add(grelha[i]);
            grelha[i].setFont(new Font("MV Boli",Font.BOLD,120));
            grelha[i].setFocusable(false);
            grelha[i].addActionListener(this);
        }

        //montando tudo
        painel.add(texto);
        frame.add(painel, BorderLayout.NORTH);
        frame.add((botaoPainel));

        primeiraVez();
    }

    public void primeiraVez() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (aleatorio.nextInt(2) == 0) {
            jogador1 = true;
            texto.setText("É a vez do X");
        } else {
            jogador1 = false;
            texto.setText("É  a vez do O");

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {

            if (e.getSource() == grelha[i]) {
                if (jogador1) {
                    if (grelha[i].getText() == "") {
                        grelha[i].setForeground(new Color(255, 0, 0));
                        grelha[i].setText("X");
                        jogador1 = false;
                        texto.setText("É  a vez do O");
                        checar();
                    }
                } else {
                    if (grelha[i].getText() == "") {
                        grelha[i].setForeground(new Color(0, 0, 255));
                        grelha[i].setText("O");
                        jogador1 = true;
                        checar();

                    }

                }
            }
        }
    }

    //caso o x ganha
    public void xGanhador(int a, int b, int c) {
        grelha[a].setBackground(Color.GREEN);
        grelha[b].setBackground(Color.GREEN);
        grelha[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++) {
            grelha[i].setEnabled(false);
        }
        texto.setText("X é o ganhador");
    }

    //caso o ganha
    public void oGanhador(int a, int b, int c) {
        grelha[a].setBackground(Color.GREEN);
        grelha[b].setBackground(Color.GREEN);
        grelha[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++) {
            grelha[i].setEnabled(false);
        }
        texto.setText("O é o ganhador");
    }

    //verificando ganhador
    public void checar(){
        //verificando as condições para x ganhar
        if((grelha[0].getText()=="X") && (grelha[1].getText()=="X") && (grelha[2].getText()=="X")) {
            xGanhador(0,1,2);
        }
        if((grelha[3].getText()=="X") && (grelha[4].getText()=="X") && (grelha[5].getText()=="X")) {
            xGanhador(3,4,5);
        }
        if((grelha[6].getText()=="X") && (grelha[7].getText()=="X") && (grelha[8].getText()=="X")) {
            xGanhador(6, 7, 8);
        }
        if((grelha[0].getText()=="X") && (grelha[3].getText()=="X") && (grelha[6].getText()=="X")) {
            xGanhador(0,3,6);
        }
        if((grelha[1].getText()=="X") && (grelha[4].getText()=="X") && (grelha[7].getText()=="X")) {
            xGanhador(1,4,7);
        }
        if((grelha[2].getText()=="X") && (grelha[5].getText()=="X") && (grelha[8].getText()=="X")) {
            xGanhador(2,5,8);
        }
        if((grelha[0].getText()=="X") && (grelha[4].getText()=="X") && (grelha[8].getText()=="X")) {
            xGanhador(0,4,8);
        }
        if((grelha[2].getText()=="X") && (grelha[4].getText()=="X") && (grelha[6].getText()=="X")) {
            xGanhador(2,4,6);
        }

        //verificando as condições para O ganhar
        if((grelha[0].getText()=="O") && (grelha[1].getText()=="O") && (grelha[2].getText()=="O")) {
            oGanhador(0,1,2);
        }
        if((grelha[3].getText()=="O") && (grelha[4].getText()=="O") && (grelha[5].getText()=="O")) {
            oGanhador(3,4,5);
        }
        if((grelha[6].getText()=="O") && (grelha[7].getText()=="O") && (grelha[8].getText()=="O")) {
            oGanhador(6,7,8);
        }
        if((grelha[0].getText()=="O") && (grelha[3].getText()=="O") && (grelha[6].getText()=="O")) {
            oGanhador(0,3,6);
        }
        if((grelha[1].getText()=="O") && (grelha[4].getText()=="O") && (grelha[7].getText()=="O")) {
            oGanhador(1,4,7);
        }
        if((grelha[2].getText()=="O") && (grelha[5].getText()=="O") && (grelha[8].getText()=="O")) {
            oGanhador(2,5,8);
        }
        if((grelha[0].getText()=="O") && (grelha[4].getText()=="O") && (grelha[8].getText()=="O")) {
            oGanhador(0,4,8);
        }
        if((grelha[2].getText()=="O") && (grelha[4].getText() == "O") && (grelha[6].getText()=="O")) {
            oGanhador(2,4,6);
        }






    }
}
