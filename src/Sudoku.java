import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sudoku extends JFrame implements ActionListener {

    private JButton[][] botones;

    public Sudoku() {
        setTitle("Sudoku 9x9");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel sudokuPanel = new JPanel();
        sudokuPanel.setLayout(new GridLayout(9, 9));

        botones = new JButton[9][9];
        Font bonita = new Font("Arial", Font.BOLD, 30);
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                JButton button = new JButton();
                button.addActionListener(this);
                button.setFont(bonita);
                Dimension dimensionbotones = new Dimension(80,80);
                button.setPreferredSize(dimensionbotones);
                botones[row][col] = button;
                sudokuPanel.add(button);
            }
        }

        add(sudokuPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        
        ponerNumeros();
        bloquearBotonesFijos();
        todoBlanco();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Sudoku());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        int row = -1;
        int col = -1;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (botones[i][j] == clickedButton) {
                    row = i;
                    col = j;
                    break;
                }
            }
        }

        System.out.println("Clicked Button Position: (" + row + ", " + col + ")");
        String numBoton = botones[row][col].getText();
        String numPorPoner="";
        int numeroIngresado=0;
        try{
            numeroIngresado=0;
        numPorPoner=JOptionPane.showInputDialog("Ingrese un numero de 1 al 9 para la posicion ("+row+", "+col+")");
            System.out.println(numPorPoner);
           numeroIngresado = Integer.valueOf(numPorPoner);
            
        }catch(Exception NumberFormatException){
            JOptionPane.showMessageDialog(null, "INGRESE UN NUMERO");
        }
if(numPorPoner==null){
    numPorPoner="";
}else{
while(numeroIngresado>9 || numeroIngresado<1){
    numeroIngresado=1;
    numPorPoner=JOptionPane.showInputDialog("Ingrese un numero de 1 al 9 para la posicion ("+row+", "+col+")");
    numeroIngresado = Integer.valueOf(numPorPoner);
        
}
    
}           
           
           if(!numPorPoner.equals("")){
        botones[row][col].setText(numPorPoner);
        boolean estaenXoY = BuscarNumero(row, col);
        if(estaenXoY==true){
            botones[row][col].setBackground(Color.red);
        }else{
            botones[row][col].setBackground(Color.white);
        }
        boolean finPartida=TerminoPartido();
        if(finPartida==true){
            JOptionPane.showMessageDialog(null, "Has ganado!");
            MenuPrincipal mp = new MenuPrincipal();
            mp.setVisible(true);
            this.dispose();
        }
            
        }
    }
        
    public void todoBlanco(){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                botones[i][j].setBackground(Color.white);
                
                
                }
            }
        
    }
    public void ponerNumeros(){
        botones[0][0].setText("5");
        botones[0][1].setText("3");
        botones[1][0].setText("6");
        botones[2][1].setText("9");
        botones[2][2].setText("8");
        botones[1][3].setText("1");
        botones[1][4].setText("9");
        botones[1][5].setText("5");
        botones[0][4].setText("7");
        botones[2][7].setText("6");
        botones[3][0].setText("8");
        botones[4][0].setText("4");
        botones[4][3].setText("8");
        botones[4][5].setText("3");
        botones[3][4].setText("6");
        botones[5][4].setText("2");
        botones[3][8].setText("3");
        botones[4][8].setText("1");
        botones[5][8].setText("6");
        botones[6][1].setText("6");
        botones[7][3].setText("4");
        botones[7][4].setText("1");
        botones[7][5].setText("9");
        botones[6][6].setText("2");
        botones[6][7].setText("8");
        botones[7][8].setText("5");
        botones[8][8].setText("9");
        botones[8][4].setText("8");
        botones[5][0].setText("7");
        botones[8][7].setText("7");
        
        
        
        
    }
   public boolean BuscarNumero(int row, int col) {
    boolean aparecex = false, aparecey = false;
    String numBoton = botones[row][col].getText(); 
    
    for (int i = 0; i < 9; i++) {
        if (botones[row][i].getText().equals(numBoton) && i != col) { 
            aparecex = true;
        }
    }

    for (int i = 0; i < 9; i++) {
        if (botones[i][col].getText().equals(numBoton) && i != row) {
            aparecey = true;
        }
    }

    return aparecex || aparecey;
}

    
    public void pintar(int row, int col){
            botones[row][col].setBackground(Color.red);
    }
    
    
    public void bloquearBotonesFijos(){
        int row;
        int col;
        botones[0][0].setEnabled(false);
        botones[0][1].setEnabled(false);
        botones[1][0].setEnabled(false);
        botones[2][1].setEnabled(false);
        botones[2][2].setEnabled(false);
        botones[1][3].setEnabled(false);
        botones[1][4].setEnabled(false);
        botones[1][5].setEnabled(false);
        botones[0][4].setEnabled(false);
        botones[2][7].setEnabled(false);
        botones[3][0].setEnabled(false);
        botones[4][0].setEnabled(false);
        botones[4][3].setEnabled(false);
        botones[4][5].setEnabled(false);
        botones[3][4].setEnabled(false);
        botones[5][4].setEnabled(false);
        botones[3][8].setEnabled(false);
        botones[4][8].setEnabled(false);
        botones[5][8].setEnabled(false);
        botones[6][1].setEnabled(false);
        botones[7][3].setEnabled(false);
        botones[7][4].setEnabled(false);
        botones[7][5].setEnabled(false);
        botones[6][6].setEnabled(false);
        botones[6][7].setEnabled(false);
        botones[7][8].setEnabled(false);
        botones[8][8].setEnabled(false);
        botones[8][4].setEnabled(false);
        botones[5][0].setEnabled(false);
        botones[8][7].setEnabled(false);
        
    }
    
    public boolean TerminoPartido(){
        boolean tamalo=false;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(botones[i][j].getText().equals("") || botones[i][j].getBackground().equals(Color.red)){
                    tamalo=true;
                }
            }
        }
        if(tamalo==true){
            return false;
        }
        return true;
    }
            
    
}
