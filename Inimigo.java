package MODEL;

import java.util.Random;

public class Inimigo {
    private String nome;
    private int nivel;
    private newWeapon arma;
    private newArmor armadura;

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
        {"Elemental de Terra", "Elemental de Ar"},     
    };

    public Inimigo(int nivel, int id) {
        
        this.nome = NOME_INIMIGOS[nivel - 1][id - 1]; 
        this.nivel = nivel;

    
        gerarDrop();
    }

    private void gerarDrop() {
        Random random = new Random();
        
      
        if (random.nextInt(100) < 70) { 
           
            if (random.nextInt(100) < 50) { 
                arma = new newWeapon(nivel, random.nextInt(6) + 1);  
            }
           
            if (random.nextInt(100) < 50) { 
                armadura = new newArmor(nivel, random.nextInt(2) + 1);  
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
