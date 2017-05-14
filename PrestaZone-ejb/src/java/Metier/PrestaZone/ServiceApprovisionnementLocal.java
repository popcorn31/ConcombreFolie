/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier.PrestaZone;

import Entites.PrestaZone.Commande;
import Entites.PrestaZone.Produit;
import javax.ejb.Local;

/**
 *
 * @author PC-FAUSTIN
 */
@Local
public interface ServiceApprovisionnementLocal 
        /* Gestion des stocks 
            - Ajouter stock 
            - Diminuer stock
            - Verifier completude commande 
        */
{
     void ajouterStock (Produit prod, int p_quantite);
    
    void retirerStock (Produit prod, int p_quantite);
    
    boolean commandeComplete(Commande maCommande);
    
}
