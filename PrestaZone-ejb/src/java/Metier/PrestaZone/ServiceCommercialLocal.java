/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier.PrestaZone;

import Entites.PrestaZone.Client;
import Entites.PrestaZone.Commande;
import Entites.PrestaZone.Produit;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author PC-FAUSTIN
 */
@Local
public interface ServiceCommercialLocal 
        /* Gestion des utilisateurs 
            - Authentification 
            - Profil des utilisateurs 
        */
        
        /* Gestion Vitrine 
            -Affichage des produits 
            -Liste des produits 
        */
        
        /* Gestion suivis des commandes 
        
        */

      
{
    Produit ajouterProduit (int qteStock, String libele, String description, float pxUnit, Produit.Type leType);
    
    Produit modifierProduit (Produit p_prod, int qteStock, String libele, String description, float pxUnit, Produit.Type leType);
    
    void afficherLesProduits ();
    
    void supprimerProduit (Produit prod);

     void authentification (String p_login, String p_mp) throws Exceptions.ClientInconnuException;
     
     Client creer (String nom ,String prenom, String adresse, String mail, String login, String mp);
     
     Client modifier (Client p_cli, String nom ,String prenom, String adresse, String mail, String login, String mp);
     
     Commande creer (Client leCli, ArrayList<Produit> lesProduits, float montantTot, String etat);
     
     Commande modifier (Commande laCommande,Client leCli, ArrayList<Produit> lesProduits, float montantTot, String etat);
     
     void supprimer (Commande p_commande);

    Commande AjouterPanier (Client p_cli, Produit p_produit);     
}   
