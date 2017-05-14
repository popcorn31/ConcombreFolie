/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier.PrestaZone;

import Controllers.PrestaZone.ClientFacadeLocal;
import Controllers.PrestaZone.CommandeFacadeLocal;
import Controllers.PrestaZone.ProduitFacadeLocal;
import Entites.PrestaZone.Client;
import static Entites.PrestaZone.Client_.adresse;
import Entites.PrestaZone.Commande;
import Entites.PrestaZone.Produit;
import java.util.ArrayList;
import javax.ejb.EJB;

/**
 *
 * @author PC-FAUSTIN
 */
public class ServiceCommercial implements ServiceCommercialLocal{
    
   @EJB
    ProduitFacadeLocal produitFacade;

   @EJB
    private ClientFacadeLocal ClientFacade;
   
   @EJB 
   private CommandeFacadeLocal commandeFacade;
            
//GESTION VITRINES
    @Override
    public Produit ajouterProduit(int qteStock, String libele, String description, float pxUnit, Produit.Type leType) 
    {
        Produit prod = new Produit (qteStock,  libele, description,  pxUnit, leType);
        produitFacade.create(prod);
        return prod;
    }

    @Override
    public Produit modifierProduit(Produit p_prod, int qteStock, String libele, String description, float pxUnit, Produit.Type leType) 
    {
      p_prod.setDescription(description);
      p_prod.setLeType(leType);
      p_prod.setLibele(libele);
      p_prod.setQteStock(qteStock);
      p_prod.setPxUnit(pxUnit);
      produitFacade.edit(p_prod);
        return p_prod;
    }

    @Override
    public void supprimerProduit(Produit prod) 
    {
        produitFacade.remove(prod);
    }
    
    @Override
    public void afficherLesProduits()
    {
        produitFacade.afficherLesProduits(produitFacade.findAll());
        
    }

    
//GESTION UTILISATEURS

    @Override
    public void authentification (String p_login, String p_mp) throws Exceptions.ClientInconnuException
    {
        ClientFacade.authentification(p_login, p_mp);
    }

    @Override
    public Client creer( String nom, String prenom, String adresse, String mail, String login, String mp) 
    {
       Client cli = new Client (nom, prenom, adresse, mail, login, mp);
       ClientFacade.create(cli);
       return cli;
    }

    @Override
    public Client modifier(Client p_cli, String nom, String prenom, String adresse, String mail, String login, String mp) 
    {
       p_cli.setAdresse(adresse);
       p_cli.setNom(nom);
       p_cli.setPrenom(prenom);
       p_cli.setMail(mail);
       p_cli.setLogin(login);
       p_cli.setMp(mp);
       ClientFacade.edit(p_cli);
       return p_cli;
    }
    
    
//GESTION SUIVIS COMMANDES

    @Override
    public Commande creer(Client leCli, ArrayList<Produit> lesProduits, float montantTot, String etat) 
    {
      Commande commande = new Commande (leCli, lesProduits, montantTot, etat);
       commandeFacade.create(commande);
       return commande;
        
    }

    @Override
    public Commande modifier(Commande laCommande, Client leCli, ArrayList<Produit> lesProduits, float montantTot, String etat) 
    {
        laCommande.setEtat(etat);
        laCommande.setLeCli(leCli);
        laCommande.setMontantTot(montantTot);
        laCommande.changerProd(lesProduits);
        commandeFacade.edit(laCommande);
        
        return laCommande;
    }

    @Override
    public void supprimer(Commande p_commande)
    {
     commandeFacade.remove(p_commande);
    }

    @Override
    public Commande AjouterPanier(Client p_cli, Produit p_produit) 
    {
        ArrayList<Produit> listeProd = new ArrayList<>();
        listeProd.add(p_produit);
        Commande commandePanier=null;
        boolean commandeTrouve= false;
        Commande commandeRetour=null; 
        
        
        while ( commandeTrouve =false)
        {
            
            // si le client a deja une commande a l'etat panier avec des produit dedans.
           for (int i =0; i< p_cli.getLesCommandes().size();i++)
           {
               if(p_cli.getLesCommandes().get(i).getEtat()=="panier")
               {
                   // on ajoute le produit nouveau au panier 
                 p_cli.getLesCommandes().get(i).setLesProduits(p_produit);

                 // on modifie la valeur total du panier 
                 p_cli.getLesCommandes().get(i).setMontantTot(p_cli.getLesCommandes().get(i).getMontantTot()+p_produit.getPxUnit());
                 commandeRetour=p_cli.getlesCommandes().get(i);
                 commandeTrouve= true;
               }
            }

           //sinon le panier est vide, et l'on ajoute le 1er produit en créant une nouvelle commande  
            commandePanier = new Commande( p_cli ,listeProd, p_produit.getPxUnit(), "panier" );
            commandeRetour=commandePanier;
            commandeTrouve=true; 
        
        }
            return commandeRetour;
   }
    
    
}
