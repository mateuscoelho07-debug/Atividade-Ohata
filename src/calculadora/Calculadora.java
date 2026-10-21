package calculadora;

public class Calculadora {

    private int resultado = 0;

    public int calcular(int a, int b, String operador) {
        validarOperador(operador);

        switch (operador) {
            case "+":
                resultado = somar(a, b);
                break;
            case "-":
                resultado = subtrair(a, b);
                break;
            case "*":
                resultado = multiplicar(a, b);
                break;
            case "/":
                resultado = dividir(a, b);
                break;
            default:
                throw new IllegalArgumentException("Operacao invalida: " + operador);
        }

        return resultado;
    }

    public int getResultado() {
        return resultado;
    }

    private void validarOperador(String operador) {
        if (operador == null) {
            throw new IllegalArgumentException("Operacao invalida: operador nulo");
        }
    }

    private int somar(int a, int b) {
        return a + b;
    }

    private int subtrair(int a, int b) {
        return a - b;
    }

    private int multiplicar(int a, int b) {
        return a * b;
    }

    private int dividir(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Erro: divisao por zero nao e permitida");
        }
        return a / b;
    }
}
