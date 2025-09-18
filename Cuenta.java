import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 * Write a description of class Cuenta here.
 * 
 * @author (Randall Sanchez) 
 * @version (a version number or a date)
 */
public class Cuenta
{
    private String codCuenta= "cta-";
    private double saldo;
    private String nombreCuentaHabiente;
    private String fechaCreacion;
    private int cantDepositosRealizados;
    private int cantRetirosExitososRealizados;
    private static int cantCuentasCreadas;
    public Cuenta(String nombreCuentaHabiente, double pSaldo){
        cantCuentasCreadas++;
        this.codCuenta=codCuenta + cantCuentasCreadas;
        saldo= pSaldo;
        Date fecha= new Date();
        DateFormat formatoFecha = new SimpleDateFormat("dd//MM//yy HH:mm:ss" );
        fechaCreacion = formatoFecha.format(fecha);
        this.nombreCuentaHabiente= nombreCuentaHabiente;
    }
    public Cuenta(double pSaldo){
        this("Sin nombre", pSaldo);
    }
    public void setnombreCuentaHabiente(String pnombreCuentaHabiente){
        nombreCuentaHabiente= pnombreCuentaHabiente;
    }
    public String getCodCuentas(){
        return codCuenta;
    }
    public double getSaldo(){
        return saldo;
    }
    public double depositar(double monto){
        saldo+=monto;
        cantDepositosRealizados++;
        System.out.println("Deposito Exitoso");
        return saldo;
    }
    public double retirar(double monto) {
        if (validarRetiro(monto)) {
            saldo -= monto;
            cantRetirosExitososRealizados++;
            System.out.println("Retiro Exitoso");
        } else {
            System.out.println("Saldo Insuficiente");
        }
        return saldo;
    }
    private boolean validarRetiro(double monto){
        return (monto<=saldo ? true :false );
    }
    public static int getCantidadCuentaCreadas(){
      return cantCuentasCreadas;
    }
    public String toString(){
        String msg = "";
        msg+= "========== Estado de Cuenta ==========\n";
        msg+= "Nombre de Cuenta:" + nombreCuentaHabiente +"\n";
        msg+= "Codigo de Cuenta:" +codCuenta + "\n";
        msg+= "Saldo total:" + saldo + "\n";
        msg+= "Fecha de Creacion:" + fechaCreacion +"\n";
        msg+= "Cantidad de Depositos Realizados:" + cantDepositosRealizados + "\n";
        msg+= "Cantidad de Retiros Realizados:" + cantRetirosExitososRealizados+"\n";
        return msg;
    }
}
