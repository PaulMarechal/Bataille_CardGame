package batailleFinal;

public class Carte {
	private int classement; //initialise le classement (2,3,4...dame, roi, as)
    private int familles; // initialise les familles (Piques, Coeur...)
    
    //constructeur 
    public Carte(int famille, int classement){
        this.classement = classement;
        this.familles = famille;
    }//fin constructeur 
    
    //getter 
    public int getCarte(){
        return classement; 
    }//fin getCard
    
    
    @Override
    public String toString(){
    //Combine familles et classement dans une seule String  (ex: Roi de coeur)

        // StringBuilder pour les modifier apres 
        StringBuilder displayCard = new StringBuilder();
        
        //Utilisation du switch mais peutêtre fait avec des if 
        switch(classement){
            // faire correspondre int et String (ex: int 11 avec Valet) 
            case 11:
                displayCard.append("Valet");
                break;
            case 12:
                displayCard.append("Dame");
                break;
            case 13:
                displayCard.append("Roi");
                break;
            case 14:
                displayCard.append("As");
                break;    
            default:
                displayCard.append(classement); //pas besoin de modifier les nomnres de 2 à 10 
                break;
        }//fin switch
        
        displayCard.append(" de "); 
        
        switch(familles){
            case 0:
                displayCard.append("Piques");
                break;
            case 1:
                displayCard.append("Coeur");
                break;
            case 2:
                displayCard.append("Trèfle");
                break;
            case 3:
                displayCard.append("Carreaux");
                break;
            default: //si autre chose ne rien faire 
                break;
        }//fin switch
        
        return displayCard.toString();
    }//fin toString
}
