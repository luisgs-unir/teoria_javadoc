# 📌 Documentación de Código con Javadoc en IntelliJ IDEA

## 📖 1. Introducción a Javadoc

### ¿Qué es Javadoc?
Javadoc es una herramienta incluida en el JDK de Java que permite generar documentación en **HTML** a partir de comentarios especiales en el código fuente. Se usa para describir clases, métodos y atributos, facilitando la comprensión y mantenimiento del código.

### ¿Por qué es importante documentar el código?
✅ Permite que otros desarrolladores (y uno mismo en el futuro) comprendan mejor el código.  
✅ Facilita la colaboración en equipos de trabajo.  
✅ Es clave en proyectos grandes, donde una buena documentación mejora el mantenimiento.  
✅ Mejora la calidad del código al obligar a reflexionar sobre su diseño.

### Ejemplo de buena y mala documentación

❌ **Ejemplo de mala documentación (insuficiente):**
```java
public class Calculadora {
    public int sumar(int a, int b) {
        return a + b;
    }
}
```

✅ **Ejemplo de buena documentación (con Javadoc):**
```java
/**
 * Clase que proporciona operaciones matemáticas básicas.
 * @author Juan Pérez
 * @version 1.0
 */
public class Calculadora {

    /**
     * Suma dos números enteros y devuelve el resultado.
     * @param a Primer número a sumar.
     * @param b Segundo número a sumar.
     * @return La suma de a y b.
     */
    public int sumar(int a, int b) {
        return a + b;
    }
}
```

---

## 📝 2. Uso de Javadoc en Java

Los comentarios de Javadoc deben colocarse **antes de clases, métodos o atributos** y siempre comienzan con `/**` y terminan con `*/`.

### Etiquetas comunes en Javadoc

| Etiqueta    | Descripción |
|------------|------------|
| `@author`  | Indica el autor del código. |
| `@version` | Especifica la versión del código. |
| `@param`   | Describe un parámetro de un método. |
| `@return`  | Explica el valor de retorno de un método. |
| `@throws`  | Indica una excepción que el método puede lanzar. |
| `@see`     | Enlaza con otra clase o método. |
| `{@code }` | Permite escribir código dentro del comentario. |
| `{@link }` | Crea un enlace a otro elemento del código. |

---

## 🖥 3. Generación automática de documentación en IntelliJ IDEA

### 🚀 Atajos para escribir Javadoc rápido
1. **Ubícate en la clase o método** a documentar.
2. **Escribe `/**` y presiona `Enter`**, IntelliJ IDEA generará automáticamente una plantilla de Javadoc.
3. **Completa la descripción y las etiquetas necesarias.**

### 📜 Generación de documentación en HTML
1. Ve al menú **Tools > Generate JavaDoc**.
2. Selecciona los archivos de código fuente a documentar.
3. Define la carpeta donde se guardará la documentación.
4. **Presiona OK** y revisa los archivos generados en un navegador.

---

## 📌 4. Ejemplo guiado: `CuentaBancaria`

Aquí tienes una **versión mejorada** de la clase `CuentaBancaria` con documentación avanzada usando `{@code }` y `{@link }`:

```java
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
```

---

## ✍️ 5. Ejercicios prácticos

### 🔹 Ejercicio 1: Documentar una clase sencilla
Crea una clase llamada `Empleado` con los siguientes métodos:
- `Empleado(String nombre, double salario)`
- `aumentarSalario(double porcentaje)`
- `obtenerSalario()`

Agrega **Javadoc adecuado** con `@param`, `@return` y `@version`.

### 🔹 Ejercicio 2: Uso de etiquetas avanzadas
Modifica la clase `Empleado` para incluir:
- `@throws`
- `{@code }`
- `{@link }`

Genera la documentación en HTML y revisa cómo se muestra.

---

## 🎯 6. Cierre y resolución de dudas

- **Preguntas y respuestas** sobre el uso de Javadoc.
- **Discusión de errores comunes** en la documentación.
- **Recursos adicionales:**
  - 📖 [Documentación oficial de Javadoc](https://docs.oracle.com/en/java/javase/11/docs/specs/doc-comment-spec.html)
  - 🎥 [Tutorial sobre Javadoc en IntelliJ](https://www.jetbrains.com/help/idea/viewing-external-documentation.html)
  - 🎥 [HowTo: Generar Javadoc en Eclipse ](https://www.youtube.com/watch?v=w68TSP4r-eU)

  


