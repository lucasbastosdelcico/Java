package sistemaempresaxyz;
public class Presidente extends Gerente {
    
    private double adicional_whisky;
    private double adicional_helicoptero;
    private double adicional_adicional;
    
    public Presidente(int Id,
                      String Nome, 
                      double Salario){
    
        super(Id, Nome, Salario,0.15);
        
        this.adicional_whisky = 0.9;
        this.adicional_helicoptero = 0.7;
        this.adicional_adicional = 3.8;
    }

    @Override 
     public void alteraAdicional(double novo_percentual){
            this.adicional_whisky = 0.9*(1+novo_percentual);
            this.adicional_helicoptero = 0.7*(1+novo_percentual);
            this.adicional_adicional = 3.8*(1+novo_percentual);
     }; 
     
     @Override 
    public double getSalario() {
        return super.getSalario() * ((1 - super.getPrevidencia()) + getAdicional_whisky() + getAdicional_helicoptero() + getAdicional_adicional());
    }

    public double getAdicional_whisky() {
        return adicional_whisky;
    }

    public void setAdicional_whisky(double adicional_whisky) {
        this.adicional_whisky = adicional_whisky;
    }

    public double getAdicional_helicoptero() {
        return adicional_helicoptero;
    }

    public void setAdicional_helicoptero(double adicional_helicoptero) {
        this.adicional_helicoptero = adicional_helicoptero;
    }

    public double getAdicional_adicional() {
        return adicional_adicional;
    }

    public void setAdicional_adicional(double adicional_adicional) {
        this.adicional_adicional = adicional_adicional;
    }
     
         
    @Override
      public String toString() {
      return "Presidente: \n" + "Nome: " + getNome() + "\n" + "Salário: " + String.format("%.2f",getSalario()) + "\n"
             + "Adicional Whisky: " + this.adicional_whisky + "\n"
             + "Adicional Helicóptero: " + this.adicional_helicoptero + "\n"
             + "Adicional Plus: " + this.adicional_adicional + "\n";
}
}
