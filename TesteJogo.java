package MODEL;
import java.util.Random;

public class TesteJogo {

    public static void main(String[] args) {
        
        // Criando inimigos de diferentes níveis
        Inimigo inimigo1 = new Inimigo(1, 1);  // Demonio, Nível 1
        Inimigo inimigo2 = new Inimigo(1, 2);  // Destruidor, Nível 1
        Inimigo inimigo3 = new Inimigo(2, 1);  // Furia, Nível 2
        Inimigo inimigo4 = new Inimigo(2, 2);  // Dragao, Nível 2
        Inimigo inimigo5 = new Inimigo(3, 1);  // Dragao de Gelo, Nível 3
        Inimigo inimigo6 = new Inimigo(3, 2);  // Hidra, Nível 3
        
        // Lista de inimigos para simular uma batalha
        Inimigo[] inimigos = {inimigo1, inimigo2, inimigo3, inimigo4, inimigo5, inimigo6};
        
        // Rodadas de batalha
        System.out.println("=== Início do Jogo ===\n");
        
        // Simulando batalhas
        for (int i = 0; i < inimigos.length; i++) {
            Inimigo inimigo = inimigos[i];
            System.out.println("Batalha contra o Inimigo: " + inimigo.getNome());
            System.out.println(inimigo);  // Chama o toString() para mostrar os detalhes do inimigo
            System.out.println("------------------------\n");
        }

        // Simulando inimigos aleatórios de diferentes níveis com chances de drops
        System.out.println("=== Teste de Drops Aleatórios ===\n");
        for (int i = 0; i < 5; i++) {
            int nivelRandomico = new Random().nextInt(10) + 1;  // Nível aleatório entre 1 e 10
            int idRandomico = new Random().nextInt(2) + 1;  // ID aleatório entre 1 e 2 (dois inimigos por nível)
            Inimigo inimigoAleatorio = new Inimigo(nivelRandomico, idRandomico);
            System.out.println("Batalha contra o Inimigo: " + inimigoAleatorio.getNome());
            System.out.println(inimigoAleatorio);  // Exibe os detalhes do inimigo com drops
            System.out.println("------------------------\n");
        }
    }
}

class Inimigo {
    private String nome;
    private int nivel;
    private Arma arma;
    private Armadura armadura;

    // Lista de inimigos para cada nível
    private static final String[][] NOME_INIMIGOS = {
        {"Demonio", "Destruidor"},           
        {"Furia", "Dragao"},                 
        {"Dragao de Gelo", "Hidra"},         
        {"Ciclope", "Gigante de Gelo"},     
        {"Ogro Bruto", "Genio Vermelho"},   
        {"Gargula", "Medusa"},              
        {"Pantera Negra", "Pesadelo"},      
        {"Orc", "Verme Gigante"},            
        {"Elemental de Fogo", "Elemental de Agua"},  
        {"Elemental de Terra", "Elemental de Ar"}    
    };

    public Inimigo(int nivel, int id) {
        this.nome = NOME_INIMIGOS[nivel - 1][id - 1];
        this.nivel = nivel;
        gerarDrop();  
    }

    private void gerarDrop() {
        Random random = new Random();
        // A chance de drops para a arma e armadura 70% / 50%
        if (random.nextInt(100) < 70) { 
            // Gerando armas
            if (random.nextInt(100) < 50) { 
                arma = new Arma(nivel, random.nextInt(6) + 1);  
            }
            // Gerando armaduras
            if (random.nextInt(100) < 50) { 
                armadura = new Armadura(nivel, random.nextInt(2) + 1);  
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public int getNivel() {
        return nivel;
    }

    public Arma getArma() {
        return arma;
    }

    public Armadura getArmadura() {
        return armadura;
    }

    @Override
    public String toString() {
        String result = "Nome: " + nome + " | Nível: " + nivel + "\n";
        
        if (arma != null) {
            result += "Arma: " + arma + "\n";  
            result += "Arma: Nenhuma\n";  
        }
        
        if (armadura != null) {
            result += "Armadura: " + armadura + "\n";  
        } else {
            result += "Armadura: Nenhuma\n";  
        }
        
        return result;
    }
}

class Arma {
    private String nome;
    private int dano;
    private int nivel;
    private int tipo;

    public Arma(int nivel, int tipo) {
        this.nivel = nivel;
        this.tipo = tipo;

      
        switch (nivel) {
            case 1:
                nome = tipo == 1 ? "Espada Curta" : "Adaga";
                dano = tipo == 1 ? 10 : 8;
                break;
            case 2:
                nome = tipo == 1 ? "Espada Longa" : "Maça";
                dano = tipo == 1 ? 15 : 12;
                break;
            case 3:
                nome = tipo == 1 ? "Espada de Duas Mãos" : "Machado";
                dano = tipo == 1 ? 20 : 18;
                break;
            default:
                nome = "Arma Desconhecida";
                dano = 0;
        }
    }

    @Override
    public String toString() {
        return nome + " | Dano: " + dano + " | Tipo: " + (tipo == 1 ? "Corte" : "Impacto");
    }
}

class Armadura {
    private String nome;
    private int defesa;
    private int nivel;
    private int tipo;

    public Armadura(int nivel, int tipo) {
        this.nivel = nivel;
        this.tipo = tipo;

        
        switch (nivel) {
            case 1:
                nome = tipo == 1 ? "Armadura de Algodão" : "Capa";
                defesa = tipo == 1 ? 10 : 13;
                break;
            case 2:
                nome = tipo == 1 ? "Armadura de Tecido" : "Armadura de Lã";
                defesa = tipo == 1 ? 15 : 18;
                break;
            case 3:
                nome = tipo == 1 ? "Armadura de Pele" : "Armadura de Couro";
                defesa = tipo == 1 ? 20 : 25;
                break;
            default:
                nome = "Armadura Desconhecida";
                defesa = 0;
        }
    }

    @Override
    public String toString() {
        return nome + " | Defesa: " + defesa;
    }
}
