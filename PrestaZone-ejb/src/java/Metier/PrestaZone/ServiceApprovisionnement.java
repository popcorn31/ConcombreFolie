/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier.PrestaZone;

import Controllers.PrestaZone.CommandeFacadeLocal;
import Controllers.PrestaZone.ProduitFacadeLocal;
import Entites.PrestaZone.Commande;
import Entites.PrestaZone.Produit;
import javax.ejb.EJB;

/**
 *
 * @author PC-FAUSTIN
 */
public class ServiceApprovisionnement implements ServiceApprovisionnementLocal

{
    @EJB
    ProduitFacadeLocal produitFacade;
    
    @EJB 
    CommandeFacadeLocal commandeFacacde;
    
      @Override
    public void ajouterStock(Produit prod, int p_quantite)
    {
        prod.setQteStock(prod.getQteStock() +p_quantite);
        produitFacade.edit(prod);
    }
    @Override
    public void retirerStock(Produit prod, int p_quantite)  
    {
        if (prod.getQteStock()-p_quantite >0)
        {
        prod.setQteStock(prod.getQteStock()-p_quantite);
        produitFacade.edit(prod);
        }
    }

    @Override
    public boolean commandeComplete(Commande maCommande) 
    {
       boolean commande_complete = true;
  
       while (commande_complete = true)
       {
            for(int i =0; i<maCommande.getLesProduits().size(); i++)
            {
                if(maCommande.getLesProduits().get(i).getQteStock()-1<0)
                    commande_complete=false;
            }
       }
       
       if (commande_complete= true)
       {
           maCommande.setEtat("valide");
           commandeFacacde.edit(maCommande);
       }
       return commande_complete;
    }
    
    
}
