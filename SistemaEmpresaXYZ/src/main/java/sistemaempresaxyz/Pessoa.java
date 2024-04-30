package sistemaempresaxyz;

public abstract class Pessoa  implements AddSalario  {

    private int Id; 
    private String Nome;
    private double Salario;
    private double Previdencia;
    
    public Pessoa(int Id, String Nome, double Salario, double Previdencia){
        this.Id = Id;
        this.Nome = Nome;
        this.Salario = Salario;
        this.Previdencia = Previdencia;
    }
    
    public Pessoa(int Id, String Nome, double Salario){
        this.Id = Id;
        this.Nome = Nome;
        this.Salario = Salario;
    }
    
    public void setId(int Id){
    this.Id = Id;
    }
    
    public int getId(){
        return Id;
    }
    
    public void setNome(String Nome){
    this.Nome = Nome;
    }
    
    public String getNome(){
        return Nome;
    }
    
    public void setPrevidencia(double Previdencia){
        this.Previdencia = Previdencia; 
    }
    
    public double getPrevidencia(){
       return Previdencia ; 
    }
    
    public  double getSalario(){
        return Salario;
    }
    
    public void setSalario(double Salario){
      this.Salario = Salario;
    }
    
    public String toString() {
    return "Id: " + getId() + "\n" 
         + "Nome: " + getNome() + "\n"
         + "Salário: R$ " + String.format("%.2f", getSalario()) + "\n";
}
}
