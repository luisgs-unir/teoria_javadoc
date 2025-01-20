/**
 * Representa una cuenta bancaria con operaciones básicas como depositar y retirar dinero.
 * 
 * <p>Ejemplo de uso:</p>
 * <pre>{@code
 * CuentaBancaria cuenta = new CuentaBancaria();
 * cuenta.depositar(1000);
 * boolean exito = cuenta.retirar(500);
 * System.out.println("Retiro exitoso: " + exito);
 * }</pre>
 * 
 * @author Juan Pérez
 * @version 1.1
 * @see Cliente
 */
public class CuentaBancaria {

    private double saldo;

    /**
     * Constructor que inicializa la cuenta con un saldo de cero.
     */
    public CuentaBancaria() {
        this.saldo = 0;
    }

    /**
     * Deposita una cantidad en la cuenta.
     * 
     * @param cantidad Monto a depositar, debe ser positivo.
     * @throws IllegalArgumentException si la cantidad es negativa.
     */
    public void depositar(double cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser positivo");
        }
        saldo += cantidad;
    }

    /**
     * Retira una cantidad de la cuenta si hay saldo suficiente.
     * 
     * @param cantidad Monto a retirar.
     * @return {@code true} si la operación fue exitosa, {@code false} si no hay saldo suficiente.
     * @throws IllegalArgumentException si la cantidad es negativa.
     */
    public boolean retirar(double cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad a retirar no puede ser negativa");
        }
        if (saldo >= cantidad) {
            saldo -= cantidad;
            return true;
        }
        return false;
    }

    /**
     * Transfiere dinero de esta cuenta a otra cuenta bancaria.
     * 
     * @param destino Cuenta destino a la que se transferirá el dinero. Debe ser una instancia de {@link CuentaBancaria}.
     * @param monto Cantidad a transferir.
     * @return {@code true} si la transferencia fue exitosa, {@code false} en caso contrario.
     * @throws IllegalArgumentException si el monto es negativo o si la cuenta destino es {@code null}.
     */
    public boolean transferir(CuentaBancaria destino, double monto) {
        if (destino == null) {
            throw new IllegalArgumentException("La cuenta destino no puede ser null");
        }
        if (monto < 0) {
            throw new IllegalArgumentException("El monto a transferir debe ser positivo");
        }
        if (this.retirar(monto)) {
            destino.depositar(monto);
            return true;
        }
        return false;
    }
}