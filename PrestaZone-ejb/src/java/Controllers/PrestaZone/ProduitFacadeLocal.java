/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.PrestaZone;

import Entites.PrestaZone.Produit;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PJES465
 */
@Local
public interface ProduitFacadeLocal {

    void create(Produit produit);

    void edit(Produit produit);

    void remove(Produit produit);

    Produit find(Object id);

    List<Produit> findAll();

    List<Produit> findRange(int[] range);

    int count();
    
    Produit chercherUnProduit (long ref) throws Exceptions.ProduitInconnuException; 
    
    Produit chercherUnProduit (String nom_produit) throws Exceptions.ProduitInconnuException;
    
    void afficherLesProduits (List<Produit> liste_prod); 
    
    void ajouterStock(long p_id_prod, int p_quantite) throws Exceptions.ProduitInconnuException;
    
}
