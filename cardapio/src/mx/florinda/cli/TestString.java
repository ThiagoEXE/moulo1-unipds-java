package mx.florinda.cli;

public class TestString {

    void main() {
        String nomeItem1 = "Refresco do Chaves";

        IO.println(nomeItem1.length());
        IO.println(nomeItem1.charAt(17));

        IO.println(nomeItem1.toUpperCase());//Converte para maíusculas
        IO.println(nomeItem1.toLowerCase());//Converte para minusculas
        IO.println(nomeItem1.toLowerCase().replace(" ", "-"));

        IO.println(nomeItem1 == "Refresco do Chaves");
        String nomeDigitado = IO.readln("Digite: ");
        IO.println(nomeItem1 == nomeDigitado);
        IO.println(nomeItem1.equals(nomeDigitado));
        IO.println(nomeItem1.equalsIgnoreCase(nomeDigitado));

        IO.println(nomeItem1.contains("Chaves"));//Case Sensitive
        IO.println("startsWitch: " +nomeItem1.startsWith("Refresco do"));
        IO.println("concat: " + nomeItem1.concat(" teste"));
        IO.println("endsWith: " + nomeItem1.endsWith("Chaves"));
        IO.println("substring: " + nomeItem1.substring(0,8));
        IO.println("substring: " + nomeItem1.substring(12));

        String[] pedacos = nomeItem1.split(" ");
        IO.println(pedacos.length);
        for (String pedaco : pedacos) {
            IO.println(pedaco);
        }

        // Imutabilidade
        String nomeItem1Miusculas = nomeItem1.toUpperCase();
        IO.println(nomeItem1);
        IO.println(nomeItem1Miusculas);

        long inicio = System.currentTimeMillis();//obter a hora atual em milisegundos
        String teste = "";
        for (int i = 0; i < 1_000; i++) {
            teste += i + ", ";
        }
        long fim = System.currentTimeMillis();
        IO.println("Tempo String: " + (fim - inicio));
        IO.println(teste);

        long inicioSB = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 1_000; i++) {
            builder.append(i).append(", ");
        }
        long fimSB = System.currentTimeMillis();
        IO.println("Tempo StringBuilder: " + (fimSB - inicioSB));
        IO.println("Tempo InicioSB: " + inicioSB);
        IO.println("Tempo FimSB: " + fimSB);
        IO.println(builder);

    }
}

