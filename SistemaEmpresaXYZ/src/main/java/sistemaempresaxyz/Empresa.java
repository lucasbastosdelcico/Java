package sistemaempresaxyz;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Empresa {
    
    ArrayList<Pessoa> funcionarios = new ArrayList<>();
    
    public void tipoFuncionario(String tipoFuncionario ){
        
        /*
            Metodo para adicionar funcionários de tipos diferentes
        */
        switch(tipoFuncionario.toUpperCase()){
            case "E": 
               try{
                    int id = Integer.parseInt(JOptionPane.showInputDialog(null,"Qual ID ?", "ID",JOptionPane.PLAIN_MESSAGE));
                    String nome = JOptionPane.showInputDialog(null, "Qual o nome ?","Nome",JOptionPane.PLAIN_MESSAGE);
                    double salario = Double.parseDouble(JOptionPane.showInputDialog(null, "Qual o salário ?","Salário",JOptionPane.PLAIN_MESSAGE ));
                    double valeCoxinha = Double.parseDouble(JOptionPane.showInputDialog(null, "Qual o valor do vale coxinha ?","Vale coxinha",JOptionPane.PLAIN_MESSAGE )); 
                    Estagiario estag = new Estagiario(id,nome,salario, valeCoxinha);
                    funcionarios.add(estag);
                    
                  }
                catch( Exception e){
                    JOptionPane.showMessageDialog(null,"Erro ao cadastrar o Estagiário","ERRO",JOptionPane.ERROR_MESSAGE);
                }   
            break;
            
            case "S": 
                try{
                    int id = Integer.parseInt(JOptionPane.showInputDialog(null,"Qual ID ?", "ID",JOptionPane.PLAIN_MESSAGE));
                    String nome = JOptionPane.showInputDialog(null, "Qual o nome ?","Nome",JOptionPane.PLAIN_MESSAGE);
                    double salario = Double.parseDouble(JOptionPane.showInputDialog(null, "Qual o salário ?","Salário",JOptionPane.PLAIN_MESSAGE ));
                    Secretaria secret = new Secretaria(id,nome,salario);
                    funcionarios.add(secret);
                   
                   }
                catch(Exception e ){
                   JOptionPane.showMessageDialog(null,"Erro ao cadastrar a Secretaria","ERRO",JOptionPane.ERROR_MESSAGE);
                }
            break;
                
            case "G": 
                try{
                     int id = Integer.parseInt(JOptionPane.showInputDialog(null,"Qual ID ?", "ID",JOptionPane.PLAIN_MESSAGE));
                    String nome = JOptionPane.showInputDialog(null, "Qual o nome ?","Nome",JOptionPane.PLAIN_MESSAGE);
                    double salario = Double.parseDouble(JOptionPane.showInputDialog(null, "Qual o salário ?","Salário",JOptionPane.PLAIN_MESSAGE ));
                    double adicional = Double.parseDouble(JOptionPane.showInputDialog(null, "Qual o valor do adicional ?", "Adicional",JOptionPane.PLAIN_MESSAGE));
                    Gerente gerente = new Gerente(id,nome,salario,adicional);
                    funcionarios.add(gerente); 
                    
                    }
                catch(Exception e ){
                    JOptionPane.showMessageDialog(null,"Erro ao cadastrar o Gerente","ERRO",JOptionPane.ERROR_MESSAGE );
                }
                break;
            case "P": 
                try{
                    int id = Integer.parseInt(JOptionPane.showInputDialog(null,"Qual ID ?", "ID",JOptionPane.PLAIN_MESSAGE));
                    String nome = JOptionPane.showInputDialog(null, "Qual o nome ?","Nome",JOptionPane.PLAIN_MESSAGE);
                    double salario = Double.parseDouble(JOptionPane.showInputDialog(null, "Qual o salário ?","Salário",JOptionPane.PLAIN_MESSAGE ));
                    Presidente presid = new Presidente(id, nome, salario);
                    funcionarios.add(presid);
                    
                    }
                catch( Exception e){
                    JOptionPane.showMessageDialog(null,"Erro ao cadastrar o Presidente","ERRO",JOptionPane.ERROR_MESSAGE);
                }
                break;
            default:
                    JOptionPane.showMessageDialog(null,"Tipo de cadastro inválido.","ERRO",JOptionPane.ERROR_MESSAGE);
                break;
        }
    }
    
    public void listarFuncionarios() {
    
         /*
            Metodo para Listar funcionários cadastrados
        */
        
        StringBuilder listaFuncionarios = new StringBuilder();
    
    
            if (funcionarios.isEmpty()) {
                listaFuncionarios.append("Não há funcionários cadastrados.\n");
            } else {
                listaFuncionarios.append("Lista de funcionários:\n");


            for (Pessoa funcionario : funcionarios) {
                 listaFuncionarios.append(funcionario.toString()).append("\n");
                 listaFuncionarios.append("\n");
                }
    
            }
       JOptionPane.showMessageDialog(null, listaFuncionarios.toString(), "Tipo de funcionário", JOptionPane.INFORMATION_MESSAGE);
    }  
    
    public void aumentarAdcSalario(int id){
    
         /*
            Metodo para aumentar o adicional dos  funcionários cadastrados
         */
        
        Integer getID = buscaId(funcionarios, id);        
      
     if(getID == null){
                JOptionPane.showMessageDialog(null,"O Id "+  id  +" Não foi encontrado","Não encontrado",JOptionPane.WARNING_MESSAGE);
        }
            else{
                 double valorAdc = Double.parseDouble(JOptionPane.showInputDialog(null,"Qual o valor a ser adicionado?","Adiciona",JOptionPane.PLAIN_MESSAGE));

                    if(valorAdc < 0.0 || valorAdc > 1.1){

                        JOptionPane.showMessageDialog(null,"O adicional não pode ser maior que 1.1 ou menos que 0.0","Valor incorreto",JOptionPane.WARNING_MESSAGE);
                    }
                        else{
                            Pessoa pessoa = funcionarios.get(getID);
                                if(pessoa instanceof Gerente || pessoa instanceof Presidente){
                                    pessoa.alteraAdicional(valorAdc);
                                    JOptionPane.showMessageDialog(null,"Salário alterado para: " + funcionarios.get(getID).getSalario(),"Salário alterado",JOptionPane.PLAIN_MESSAGE);
                                }
                                 else{
                                       JOptionPane.showMessageDialog(null, "Esta operação não é permitida para este tipo de funcionário", "Funcionário não permitido", JOptionPane.WARNING_MESSAGE);
                                    }
                            }
                }       
    }
    
    public Integer buscaId(ArrayList<Pessoa> listaFuncionario, int id ){
                   
         /*
            Metodo para procurar os id´s dos funcionários 
        */
        for(int i = 0; i < listaFuncionario.size() ; i++){
                        if(listaFuncionario.get(i).getId() == id){
                          return i;}
                    }
        return null;
    } 
    
    public void getDescSalario(int id) {
           /*
            Metodo que traz a descrição dos salários 
          */
          
        try {
             Integer getID = buscaId(funcionarios, id);
             if (getID == null) {
                 JOptionPane.showMessageDialog(null, "O Id " + id + " não foi encontrado", "Não encontrado", JOptionPane.WARNING_MESSAGE);
             } else {
                 calculaSalaio(getID);
             }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Erro ao calcular o salário", "ERRO", JOptionPane.ERROR_MESSAGE);
         }
    }
    
    public void calculaSalaio(int id){
            /*
            Metodo para calcular o salário dos funcionários baseando o quanto que eles ganham por hora
           */
        try{
        Pessoa pessoa = funcionarios.get(id);
                                if(pessoa instanceof Gerente || pessoa instanceof Presidente){
                                   
                                    JOptionPane.showMessageDialog(null,
                                    "O salário do funcionário " + funcionarios.get(id).getNome() + " com adicionais foi de " + String.format("%.2f", funcionarios.get(id).getSalario()/220) + " por horas trabalhadas.",
                                    "Salário calculado", JOptionPane.PLAIN_MESSAGE);
                                    
                                }
                                 else{
                                    JOptionPane.showMessageDialog(null,
                                    "O salário do funcionário " + funcionarios.get(id).getNome() + " foi de " + String.format("%.2f", funcionarios.get(id).getSalario()/220) + " por horas trabalhadas.",
                                    "Salário calculado", JOptionPane.PLAIN_MESSAGE);
                                    }
        }
        catch(Exception e ){
                     JOptionPane.showMessageDialog(null,"Erro ao recuperar as informações do  salário", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
}

