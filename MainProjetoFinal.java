package coders_projeto_final;

import java.util.Scanner;

public class MainProjetoFinal { // Já me desculpo por não ter conseguido refatorar muito bem :(

    public static void main(String[] args) {

//pedir que o usuário digite a quantidade de temperaturas a serem transformadas.

        boolean quantidadeTemperaturasValida = false;
        int quantidadeTemperaturas = 0;
        while (!quantidadeTemperaturasValida || quantidadeTemperaturas<=0){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Digite quantas temperaturas você quer transformar, sendo um número inteiro e maior que zero:");
                quantidadeTemperaturas = scanner.nextInt();
                quantidadeTemperaturasValida = true;
            } catch (Exception e) {
                System.out.println("Digite uma quantidade válida sendo um número inteiro e maior que zero");
            }
        }

//pedir as temperaturas a serem transformadas.

        Double[] temperaturas = new Double[quantidadeTemperaturas];
        for (int i = 0; i < temperaturas.length; i++) {
            boolean temperaturasValidas = false;
            while (!temperaturasValidas){
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Digite a temperatura número " + (i+1));
                    temperaturas[i] = scanner.nextDouble();
                    temperaturasValidas = true;
                } catch (Exception e) {
                    System.out.println("Digite uma temperatura válida ");
                }
            }
        }

//pedir que o usuário digite a quantidade de temperaturas a serem transformadas. Origem

        boolean unidadeOrigemValida = false;
        Integer unidadeOrigem = 0;
        while (!unidadeOrigemValida){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Digite a unidade de origem pelo número: 1 - Celsius, 2 - Kelvin, 3 - Fahrenheit");
                unidadeOrigem = scanner.nextInt();
                unidadeOrigemValida = true;
            } catch (Exception e) {
                System.out.println("Digite uma opção valida");
            }
        }

//pedir que o usuário digite a quantidade de temperaturas a serem transformadas. convertida

        boolean unidadeFinalValida = false;
        int unidadeFinal = 0;
        while (!unidadeFinalValida){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Digite a unidade para converter pelo número: 1 - Celsius, 2 - Kelvin, 3 - Fahrenheit");
                unidadeFinal = scanner.nextInt();
                unidadeFinalValida = true;
            } catch (Exception e) {
                System.out.println("Digite uma opção valida");
            }
        }

        Double[] temperaturasconvertidas = new Double[quantidadeTemperaturas];

        for (int i = 0; i < temperaturas.length; i++) {

            if (unidadeOrigem.equals(unidadeFinal)){
                temperaturasconvertidas[i] = transformaTemperaturaIguas(temperaturas[i]);
                System.out.println("Não houve conversão, as unidades são iguais. Tente executar novamente.");
//                System.out.println("temperatura n" + (i+1) + ": " + temperaturas[i]);
//                System.out.println("temperatura n" + (i+1) + " convertida: " + temperaturasconvertidas[i]);

            } else if (unidadeOrigem == 1 && unidadeFinal == 2) {
                temperaturasconvertidas[i] = transformaTemperaturaCelsiusParaKelvin(temperaturas[i]);
                System.out.println("temperatura n" + (i+1) + ": " + temperaturas[i] + " graus Celsius");
                System.out.println("temperatura n" + (i+1) + " convertida: " + temperaturasconvertidas[i] + " Kelvins");

            } else if (unidadeOrigem == 2 && unidadeFinal == 1) {
                temperaturasconvertidas[i] = transformaTemperaturaKelvinParaCelsius(temperaturas[i]);
                System.out.println("temperatura n" + (i+1) + ": " + temperaturas[i] + " Kelvins");
                System.out.println("temperatura n" + (i+1) + " convertida: " + temperaturasconvertidas[i] + " graus Celsius");

            } else if (unidadeOrigem == 1 && unidadeFinal == 3) {
                temperaturasconvertidas[i] = transformaTemperaturaCelsiusParaFahrenheit(temperaturas[i]);
                System.out.println("temperatura n" + (i+1) + ": " + temperaturas[i] + " graus Celsius");
                System.out.println("temperatura n" + (i+1) + " convertida: " + temperaturasconvertidas[i] + " graus Fahrenheit");

            } else if (unidadeOrigem == 3 && unidadeFinal == 1) {
                temperaturasconvertidas[i] = transformaTemperaturaFahrenheitParaCelsius(temperaturas[i]);
                System.out.println("temperatura n" + (i+1) + ": " + temperaturas[i] + " graus Fahrenheit");
                System.out.println("temperatura n" + (i+1) + " convertida: " + temperaturasconvertidas[i] + " graus Celsius");

            } else if (unidadeOrigem == 3 && unidadeFinal == 2) {
                temperaturasconvertidas[i] = transformaTemperaturaFahrenheitParaKelvin(temperaturas[i]);
                System.out.println("temperatura n" + (i+1) + ": " + temperaturas[i] + " graus Fahrenheit");
                System.out.println("temperatura n" + (i+1) + " convertida: " + temperaturasconvertidas[i] + " Kelvins");

            } else if (unidadeOrigem == 2 && unidadeFinal == 3) {
                temperaturasconvertidas[i] = transformaTemperaturaKelvinParaFahrenheit(temperaturas[i]);
                System.out.println("temperatura n" + (i+1) + ": " + temperaturas[i] + " Kelvins");
                System.out.println("temperatura n" + (i+1) + " convertida: " + temperaturasconvertidas[i] + " graus Fahrenheit");

            } else {
                System.out.println("erro no programa. por favor revisar");
            }
        }

        double somaTempIniciais = 0.0;
        double somaTempFinais = 0.0;

        for (double valores : temperaturas) {
            somaTempIniciais += valores;
        }

        for (double valores : temperaturasconvertidas) {
            somaTempFinais += valores;
        }

        double mediaTempIniciais = somaTempIniciais/temperaturas.length;
        double mediaTempFinais = somaTempFinais/temperaturasconvertidas.length;

        System.out.println("\nA média das temperaturas iniciais é: " + mediaTempIniciais);
        System.out.println("A média das temperaturas convertidas é: " + mediaTempFinais);

    }

    public static Double transformaTemperaturaIguas(Double temperatura) {
        return temperatura;
    }

    public static Double transformaTemperaturaCelsiusParaKelvin(Double temperatura) {
        return temperatura + 273.15;
    }

    public static Double transformaTemperaturaKelvinParaCelsius(Double temperatura) {
        return temperatura - 273.15;
    }

    public static Double transformaTemperaturaCelsiusParaFahrenheit(Double temperatura) {
        return (temperatura * ( 9d / 5d )) + 32;
    }

    public static Double transformaTemperaturaFahrenheitParaCelsius(Double temperatura) {
        return (temperatura - 32) / ( 9d / 5d );
    }

    public static Double transformaTemperaturaFahrenheitParaKelvin(Double temperatura) {
        return ((temperatura - 32) * ( 9d / 5d )) + 273;
    }

    public static Double transformaTemperaturaKelvinParaFahrenheit(Double temperatura) {
        return ((temperatura - 273) * ( 9d / 5d )) + 32;
    }
}
