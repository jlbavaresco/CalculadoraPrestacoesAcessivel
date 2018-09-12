package br.edu.ifsul.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class CalculadoraPrestacaoAcessivel extends JFrame {

    private JButton botaoCalcular = new JButton("Calcular");
    private JButton botaoLimpar = new JButton("Limpar");
    private JLabel labelValor = new JLabel("Valor:");
    private JTextField campoValor = new JTextField(10);
    private JLabel labelPrestacoes = new JLabel("Prestações:");
    private JTextField campoPrestacoes = new JTextField(5);
    private JLabel labelValorPrestacao = new JLabel("Valor da prestação:");
    private JTextField campoValorPrestacao = new JTextField(10);

    public CalculadoraPrestacaoAcessivel() {
    	// os labels para o NVDA Ler deve-se deixar focavel que ele lê o texto
    	labelValor.setFocusable(true);    	
    	labelPrestacoes.setFocusable(true);    	
        labelValorPrestacao.setFocusable(true);
    	// os campos de entrada e damis componentes basta setar o accessible description para 
    	// o leitor ser capaz de ler a tela
    	campoValor.getAccessibleContext().setAccessibleDescription("Campo Valor");
    	campoPrestacoes.getAccessibleContext().setAccessibleDescription("Campo Quantidade de prestações");
    	campoValorPrestacao.getAccessibleContext().setAccessibleDescription("Campo Valor da prestação");
        botaoCalcular.getAccessibleContext().setAccessibleDescription("Botão Calcular");
        botaoLimpar.getAccessibleContext().setAccessibleDescription("Botão Limpar");
        setTitle("Prestações");
        // largura/altura
        setSize(330, 130);
        // centro da tela
        setLocationRelativeTo(null);
        // fechar ao sair
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // cor de fundo
        getContentPane().setBackground(Color.blue);
        //setLayout(new GridLayout(2, 2));
        setLayout(new FlowLayout());
        setVisible(true);
        add(labelValor);
        add(campoValor);
        add(labelPrestacoes);
        add(campoPrestacoes);
        add(labelValorPrestacao);
        add(campoValorPrestacao);
        add(botaoCalcular);
        add(botaoLimpar);
        OuvinteCalculo ouvinteCalculo = new OuvinteCalculo();
        botaoCalcular.addActionListener(ouvinteCalculo);
        OuvinteLimpar ouvinteLimpar = new OuvinteLimpar();
        botaoLimpar.addActionListener(ouvinteLimpar);        
    }

    public static void main(String[] args) {
        CalculadoraPrestacaoAcessivel janela = new CalculadoraPrestacaoAcessivel();
        janela.campoValor.requestFocus();
    }

    private class OuvinteCalculo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Double valor = Double.parseDouble(campoValor.getText());
            Integer parcelas = Integer.parseInt(campoPrestacoes.getText());
            Double valorPrestacao = valor + parcelas;
            campoValorPrestacao.setText(valorPrestacao.toString());
        }
    }

    private class OuvinteLimpar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            campoValor.setText("");
            campoPrestacoes.setText("");
            campoValorPrestacao.setText("");
        }
    }

}
