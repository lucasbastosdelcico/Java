package sistemaempresaxyz;

public class Secretaria extends Pessoa{
    
  
    public  Secretaria(int Id, String Nome , double Salario){
    super(Id, Nome, Salario, 0.05);
    }
    @Override
     public double getSalario() {
        return  super.getSalario()*(1- super.getPrevidencia());
    }
     
      @Override
    public String toString(){
       return "Secretário(a): \n" + super.toString();
    }

    @Override
    public void alteraAdicional(double novo_percentual){}
}
