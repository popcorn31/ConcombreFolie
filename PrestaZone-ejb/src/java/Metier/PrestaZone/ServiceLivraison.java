/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier.PrestaZone;

import Entites.PrestaZone.Commande;
import javax.ejb.Stateless;

/**
 *
 * @author PC-FAUSTIN
 */
@Stateless
public class ServiceLivraison implements ServiceLivraisonLocal
{
    

    @Override
    public void LancerLivraison(Commande uneCommande) 
    {
        if (uneCommande.getEtat()=="valide")
        {
            System.out.println("livraison de la commande Numero :" + uneCommande.getId()+ " au client nommé " + uneCommande.getLeCli().getNom()+ " , " + uneCommande.getLeCli().getPrenom() +", situé a l'adresse " + uneCommande.getLeCli().getAdresse());
        }
    }
    
}
