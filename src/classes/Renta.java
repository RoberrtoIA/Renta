/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author rober
 */
public class Renta {
    
    public double salario;
    public double salariomenos;
    public double afp;
    public double isss;
    public double renta;
    public double salarionetom;
    public double bono;

    public double getSalariomenos() {
        return salariomenos;
    }

    public void setSalariomenos(double salariomenos) {
        this.salariomenos = salariomenos;
    }
    
    

    public Renta(double salario, double salariomenos, double afp, double isss, double renta, double salarionetom, double bono) {
        this.salario = salario;
        this.salariomenos = salariomenos;
        this.afp = afp;
        this.isss = isss;
        this.renta = renta;
        this.salarionetom = salarionetom;
        this.bono = bono;
    }
    
    
    public Renta(double salario, double bono) {
        this.salario = salario;
        this.bono = round(bono, 2);
        this.salario = round((this.salario + this.bono), 2);
        this.afp = round((this.salario * 0.0725), 2);
        
        if(this.salario > 1000){
            this.isss = 1000 * 0.03;
        }else{
            this.isss = round((this.salario * 0.03), 2);
        }
        this.salariomenos = round((this.salario - (this.isss + this.afp)), 2);
        
        if(this.salariomenos <= 472){//tramo 1
            this.renta = 0;
        }else if((this.salariomenos > 472) && (this.salariomenos <= 895.24)){//tramo 2
            this.renta = this.salariomenos - 472;
            this.renta = this.renta * 0.1;
            this.renta = round((this.renta + 17.67), 2);
        }else if((this.salariomenos > 895.24) && (this.salariomenos <= 2038.10)){//tramo 3
            this.renta = this.salariomenos - 895.24;
            this.renta = this.renta * 0.2;
            this.renta = round((this.renta + 60), 2);
        }else if(this.salariomenos > 2038.10){//tramo 4
            this.renta = this.salariomenos - 2038.10;
            this.renta = this.renta * 0.3;
            this.renta = round((this.renta + 288.57), 2);
        }
        this.salarionetom = round((this.salario - (this.afp + this.isss + this.renta)), 2);
    }
    
    public Renta(double salario, double aguinaldo, double bono) {
        this.salario = salario;
        this.bono = round(bono, 2);
        this.salario = round((this.salario + this.bono), 2);
        this.afp = round((this.salario * 0.0725), 2);
        
        if(this.salario > 1000){
            this.isss = 1000 * 0.03;
        }else{
            this.isss = round((this.salario * 0.03), 2);
        }
        this.salariomenos = round((this.salario - (this.isss + this.afp)), 2);
        
        if(this.salariomenos <= 472){//tramo 1
            this.renta = 0;
        }else if((this.salariomenos > 472) && (this.salariomenos <= 895.24)){//tramo 2
            this.renta = this.salariomenos - 472;
            this.renta = this.renta * 0.1;
            this.renta = round((this.renta + 17.67), 2);
        }else if((this.salariomenos > 895.24) && (this.salariomenos <= 2038.10)){//tramo 3
            this.renta = this.salariomenos - 895.24;
            this.renta = this.renta * 0.2;
            this.renta = round((this.renta + 60), 2);
        }else if(this.salariomenos > 2038.10){//tramo 4
            this.renta = this.salariomenos - 2038.10;
            this.renta = this.renta * 0.3;
            this.renta = round((this.renta + 288.57), 2);
        }
        this.salarionetom = round((this.salario - (this.afp + this.isss + this.renta)), 2);
    }
    
    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
    
}
