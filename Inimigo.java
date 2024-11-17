package MODEL;

import java.util.Random;

public class Inimigo {
    private String nome;
    private int nivel;
    private newWeapon arma;
    private newArmor armadura;

    // Lista de inimigos para cada nível
    private static final String[][] NOME_INIMIGOS = {
        {"Demonio", "Destruidor"},           // Nível 1
        {"Furia", "Dragao"},                 // Nível 2
        {"Dragao de Gelo", "Hidra"},         // Nível 3
        {"Ciclope", "Gigante de Gelo"},      // Nível 4
        {"Ogro Bruto", "Genio Vermelho"},    // Nível 5
        {"Gargula", "Medusa"},               // Nível 6
        {"Pantera Negra", "Pesadelo"},       // Nível 7
        {"Orc", "Verme Gigante"},            // Nível 8
        {"Elemental de Fogo", "Elemental de Agua"},  // Nível 9
        {"Elemental de Terra", "Elemental de Ar"}     // Nível 10
    };

    public Inimigo(int nivel, int id) {
        // Setando o nome do monstro baseado no nível e id (1 ou 2 para cada nível)
        this.nome = NOME_INIMIGOS[nivel - 1][id - 1]; // -1 porque o array é 0-based
        this.nivel = nivel;

        // Gerar drops
        gerarDrop();
    }

    private void gerarDrop() {
        Random random = new Random();
        
        // A chance de drops para a arma e armadura
        if (random.nextInt(100) < 70) {  // 70% chance de dropar algum item
            // Gerando armas
            if (random.nextInt(100) < 50) { // 50% chance de dropar arma
                arma = new newWeapon(nivel, random.nextInt(6) + 1);  // Gerar uma arma de tipo 1 a 6 com base no nível
            }
            // Gerando armaduras
            if (random.nextInt(100) < 50) { // 50% chance de dropar armadura
                armadura = new newArmor(nivel, random.nextInt(2) + 1);  // Gerar armadura de tipo 1 ou 2
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public int getNivel() {
        return nivel;
    }

    public newWeapon getArma() {
        return arma;
    }

    public newArmor getArmadura() {
        return armadura;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(nome).append(" | Nível: ").append(nivel).append("\n");
        
        if (arma != null) {
            sb.append("Arma: ").append(arma).append("\n");
        } else {
            sb.append("Arma: Nenhuma\n");
        }
        
        if (armadura != null) {
            sb.append("Armadura: ").append(armadura).append("\n");
        } else {
            sb.append("Armadura: Nenhuma\n");
        }
        
        return sb.toString();
    }
}
