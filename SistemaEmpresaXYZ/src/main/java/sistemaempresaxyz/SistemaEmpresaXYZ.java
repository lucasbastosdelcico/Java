package sistemaempresaxyz;
import javax.swing.JOptionPane;

public class SistemaEmpresaXYZ {

    public static void main(String[] args) {
        
        Empresa emp = new Empresa();
       
         String tipoOperacao;   
  try {
         /*
            Switch  com looping para tratamento com o menu  
          */
    do {
        tipoOperacao = JOptionPane.showInputDialog(null, "Qual tipo de operação você irá fazer?\n"
                + "A: Adicionar um funcionário\n"
                + "B: Calcular pagamento do funcionário\n"
                + "C: Aumentar o adicional do funcionário\n"
                + "D: Relatório dos funcionários da empresa\n"
                + "E: Sair do sistema", "Menu", JOptionPane.PLAIN_MESSAGE);

        switch (tipoOperacao.toUpperCase()) {
            case "A":
                String selectFuncionario = JOptionPane.showInputDialog(null, "Qual o Tipo de funcionário ?\n"
                        + "E: Estagiário\n"
                        + "S: Secretária\n"
                        + "G: Gerente\n"
                        + "P: Presidente\n", "Tipo funcionário", JOptionPane.PLAIN_MESSAGE);
                emp.tipoFuncionario(selectFuncionario);
                break;
            case "B":
                int selectId = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe o Id do funcionário","Calcular salário",JOptionPane.PLAIN_MESSAGE));
                 emp.getDescSalario(selectId);
                break;
            case "C":
                  selectId = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe o Id do funcionário","Aumentar adicional",JOptionPane.PLAIN_MESSAGE));
                  emp.aumentarAdcSalario(selectId);
                break;
            case "D":
                emp.listarFuncionarios();
                break;
            case "E":
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Tipo de operação não válida", "ERRO", JOptionPane.ERROR_MESSAGE);
                break;
        }
    } while (!"E".equals(tipoOperacao));
} catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Sistema finalizado", "Saída", JOptionPane.WARNING_MESSAGE);
}
    }
}
   

    

