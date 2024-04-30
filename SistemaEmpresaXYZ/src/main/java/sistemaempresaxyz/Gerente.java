package sistemaempresaxyz;

public class Gerente extends Pessoa {
    
    private double Adicional;
    
    public Gerente(int Id, 
                   String Nome, 
                   double Salario,
                   double Adicional) {
      
        super(Id, Nome,Salario,0.07);
        this.Adicional = Adicional;
    }
    
    public Gerente(int Id, 
                   String Nome, 
                   double Salario) {
        
        super(Id, Nome,Salario,0.07);
    }
    
    
    public void setAdicional(int Adicional){
    this.Adicional = Adicional;
    }
    
    public double getAdicional(){
        return Adicional;
    }

    @Override
     public void alteraAdicional(double novo_percentual){
       this.Adicional  *= (1+novo_percentual);
     }
    
   @Override
    public double getSalario() {
    return  super.getSalario() *(1 - super.getPrevidencia()) + this.getAdicional();
    }

    @Override
    public String toString(){
     return "Gerente: \n" + super.toString() + "Adicional: "+ String.format("%.2f",getAdicional()) + "\n";
    }
}
