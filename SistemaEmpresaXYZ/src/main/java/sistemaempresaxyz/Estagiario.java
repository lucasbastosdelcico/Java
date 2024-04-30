package sistemaempresaxyz;
public class Estagiario extends Pessoa {
    
    private double ValeCoxinha;
    
    public Estagiario(int Id, String Nome, double Salario, double ValeCoxinha) {
        super(Id, Nome, Salario);
       
         this.ValeCoxinha = ValeCoxinha;
    }
   
    public void setValeCoxinha(double ValeCoxinha){
        this.ValeCoxinha = ValeCoxinha;
    } 
    
    public double getValeCoxinha(){
    return ValeCoxinha;
    }
    
     @Override
    public double getSalario() {
        return  super.getSalario() + ValeCoxinha;
    }   
    @Override
    public String toString(){
     return  "Estagiário: \n" + super.toString() + "Vale coxinha: " + getValeCoxinha();
    }

    @Override
    public void alteraAdicional(double novo_percentual) {}
}
