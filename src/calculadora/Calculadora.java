package calculadora;

/**
 * Motor de cálculos básicos do FinançApp.
 * <p>
 * Realiza soma, subtração, multiplicação e divisão de números inteiros.
 * Será usado em funções como orçamento mensal, divisão de despesas e
 * projeção de economia.
 * </p>
 *
 * @author Mateus Coelho Cardoso
 * @version 2.0
 */
public class Calculadora {

    /** Guarda o resultado da última operação realizada. */
    private int resultado = 0;

    /** Cria uma calculadora com o resultado inicial igual a zero. */
    public Calculadora() {
        // Nada a configurar: o resultado já começa em 0
    }

    /**
     * Realiza uma operação matemática entre dois números inteiros.
     *
     * @param a        primeiro número
     * @param b        segundo número
     * @param operador operação desejada: "+", "-", "*" ou "/"
     * @return o resultado da operação
     * @throws IllegalArgumentException se o operador for nulo ou não for suportado,
     *                                  ou se houver divisão por zero
     */
    public int calcular(int a, int b, String operador) {
        // Falha cedo se o operador for nulo
        validarOperador(operador);

        // Escolhe a operação de acordo com o operador recebido
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

    /**
     * Retorna o resultado da última operação realizada.
     *
     * @return último resultado calculado (0 se nenhuma operação foi feita)
     */
    public int getResultado() {
        return resultado;
    }

    /**
     * Confere se o operador foi informado.
     *
     * @param operador operador recebido
     * @throws IllegalArgumentException se o operador for nulo
     */
    private void validarOperador(String operador) {
        if (operador == null) {
            throw new IllegalArgumentException("Operacao invalida: operador nulo");
        }
    }

    /**
     * Soma dois números.
     *
     * @param a primeiro número
     * @param b segundo número
     * @return a + b
     */
    private int somar(int a, int b) {
        return a + b;
    }

    /**
     * Subtrai o segundo número do primeiro.
     *
     * @param a primeiro número
     * @param b segundo número
     * @return a - b
     */
    private int subtrair(int a, int b) {
        return a - b;
    }

    /**
     * Multiplica dois números.
     *
     * @param a primeiro número
     * @param b segundo número
     * @return a * b
     */
    private int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Divide o primeiro número pelo segundo (divisão inteira).
     *
     * @param a dividendo
     * @param b divisor
     * @return a / b
     * @throws IllegalArgumentException se o divisor for zero
     */
    private int dividir(int a, int b) {
        // Impede a divisão por zero
        if (b == 0) {
            throw new IllegalArgumentException("Erro: divisao por zero nao e permitida");
        }
        return a / b;
    }
}
