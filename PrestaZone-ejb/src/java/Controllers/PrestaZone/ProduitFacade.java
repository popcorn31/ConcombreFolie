/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.PrestaZone;

import Controllers.AbstractFacade;
import Controllers.PrestaZone.ProduitFacadeLocal;
import Entites.PrestaZone.Produit;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import Exceptions.ProduitInconnuException;

/**
 *
 * @author PJES465
 */
@Stateless
public class ProduitFacade extends AbstractFacade<Produit> implements ProduitFacadeLocal {
    @PersistenceContext(unitName = "PrestaZone-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() 
    {
        return em;
    }

    public ProduitFacade() 
    {
        super(Produit.class);
    }

    @Override
    public Produit chercherUnProduit(long p_ref_produit)throws Exceptions.ProduitInconnuException
    {
        try 
        {
            Query q = em.createQuery(
              "select p from Produit p where p.id = :p_ref_produit ");
            q.setParameter("id", p_ref_produit);
            Produit p = (Produit) q.getSingleResult();
            return p;
        } 
       catch(NoResultException e) 
        {
            throw new Exceptions.ProduitInconnuException();
        }
    }

    @Override
    public Produit chercherUnProduit(String p_nom_produit) throws Exceptions.ProduitInconnuException
    {
       try 
        {
            Query q = em.createQuery(
              "select p from Produit p where p.libele = :p_nom_produit ");
            q.setParameter("nom", p_nom_produit);
            Produit p = (Produit) q.getSingleResult();
            return p;
        } 
       catch(NoResultException e) 
        {
            throw new Exceptions.ProduitInconnuException();
        }
    }

    @Override
    public void afficherLesProduits(List<Produit> p_liste_prod)
    {
       
        for (int i=0;i<p_liste_prod.size(); i++)
    {
        System.out.println("produit "+ i + " : " + p_liste_prod.get(i));
        
    }
        
    }
    
    @Override
    public void ajouterStock(long p_id_prod, int p_quantite)throws Exceptions.ProduitInconnuException
    {
       try 
        {
            Query q = em.createQuery(
              "select p from Produit p where p.id = :p_id_prod ");
            q.setParameter("id", p_id_prod);
            Produit p = (Produit) q.getSingleResult();
           p.setQteStock(p.getQteStock()+ p_quantite);
        } 
       catch(NoResultException e) 
        {
            throw new Exceptions.ProduitInconnuException();
        }
    }
    
    
}
