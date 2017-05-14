/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier.PrestaZone;

import Entites.PrestaZone.Commande;
import javax.ejb.Local;

/**
 *
 * @author PC-FAUSTIN
 */
@Local
public interface ServiceLivraisonLocal 
        /* Gestion Livraison 
        - Livrer commande (si commande complete)
        */
{
    void LancerLivraison (Commande uneCommande);
}
