package batailleFinal;


import java.util.ArrayList;     //import ArrayList  
import java.util.Random;        //import Random
import java.util.List;          //import List
import java.util.Collections;   //import Collections
import java.util.LinkedList;    //import LinkList

public class Bataille {

	public static void main(String[] args) {
List<Carte> jeuCarte = new ArrayList<Carte>(); // creation ArrayList "jeuCarte" 
        
        for(int x=0; x<4; x++){          //0-3 pour les différentes familles (4 familles)
            for(int y=2; y<15; y++){     //2-14 pour le classement (13 carte)
                jeuCarte.add(new Carte(x,y)); //crée une carte et l'ajoute dans le jeu 
            } //fin boucle classement 
        }//fin boucle familles
        
        Collections.shuffle(jeuCarte, new Random()); //mélange le jeu avec Random() 
        
        //Création de deux jeu : joueur 1 / joueur 2 
        LinkedList<Carte> jeu1 = new LinkedList<Carte>();
        LinkedList<Carte> jeu2 = new LinkedList<Carte>();
        
        jeu1.addAll(jeuCarte.subList(0, 25));              //26 cartes pour p1 
        jeu2.addAll(jeuCarte.subList(26, jeuCarte.size()));//26 cartes pour p2
        
        while(true){
        	Carte cartesP1 = jeu1.pop();  // chaque joueur place une carte découverte
        	Carte cartesP2 = jeu2.pop();
            
            //Affiche la carte de chaque joueur 
            System.out.println("La carte du joueur A est : " + cartesP1.toString());
            System.out.println("La carte du joueur B est : " + cartesP2.toString());
            
            //compare le classement des deux cartes 
            if(cartesP1.getCarte() > cartesP2.getCarte()){//si le joueur 1 gagne 
                jeu1.addLast(cartesP1);  // le classement le plus haut ajoute les cartes 
                jeu1.addLast(cartesP2);  //en dessous de son deck 
                System.out.println("----- Le joueur A gagne la manche ! ----- \n");
            }//fin if 
 
            else if(cartesP1.getCarte() < cartesP2.getCarte()){//si le joueur 2 gagne 
                jeu2.addLast(cartesP1);   
                jeu2.addLast(cartesP2);  
                System.out.println("----- Le joueur B gagne la manche ! ----- \n");
            }//fin else if 
            
            else { // bataille quand les deux cartes sont identiques
                System.out.println("----------    Bataille    ---------- \n\n"); 
                
                //création cartes Bataille
                List<Carte> war1 = new ArrayList<Carte>(); 
                List<Carte> war2 = new ArrayList<Carte>();
                
                // vérifie si les joueurs ont assez de cartes pour rester dans le jeu (4) 
                for(int x=0; x<3; x++){ 
                    //si un joueur n'a plus de crates la partie est fini 
                    if(jeu1.size() == 0 || jeu2.size() == 0 ){                      
                        break;
                    }//end if
                    
                    System.out.println("Les cartes de jeu pour le joueur A sont xx\nLes cartes de jeu pour le joueur B sont xx\n");

                    war1.add(jeu1.pop());  //ajoute une carte en plus pour la Bataille
                    war2.add(jeu2.pop());                  
                }//end for
                
                //compare le resultat que si les deux joueurs ont assez de cartes pour la Bataille 
                if(war1.size() == 3 && war2.size() == 3 ){
                    //Affiche les cartes de Bataille pour chaque joueur
                    System.out.println("La carte pour le joueur A est : " + war1.get(0).toString());
                    System.out.println("La carte pour le joueur B est : " + war2.get(0).toString());
                    
                    //Si le joueur 1 gagne la bataille
                    if(war1.get(2).getCarte() > war2.get(2).getCarte()){
                        jeu1.addAll(war1); //joueur 1 gagne les 10 cartes 
                        jeu1.addAll(war2);
                        System.out.println("\n \n ----- Le joueur A gagne la manche ! ----- \n \n");
                    }//end if
                    //Si le joueur 2 gagne la bataille 
                    else{
                        jeu2.addAll(war1); //joueur 2 gagne les 10 cartes 
                        jeu2.addAll(war2);
                        System.out.println("\n \n ----- Le joueur B gagne la manche ! ----- \n \n");
                    }//fin else                      
                }//end if
                
            }//end war round else
            
            //fin du jeu si l'un des joueurs n'a plus de cartes 
            if(jeu1.size() == 0 ){
                System.out.println("Le joueur A gagne la partie!!! \nIl reste " + jeu2.size() + " cartes au joueur B");
                break;
            }
            else if(jeu2.size() == 0){
                System.out.println("Le joueur B gagne la partie!!! \nIl reste " + jeu1.size() + " cartes au joueur A");
                break;
            }
        }//fin while  

	}

}
