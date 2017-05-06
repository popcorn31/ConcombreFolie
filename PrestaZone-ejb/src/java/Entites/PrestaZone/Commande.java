/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites.PrestaZone;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 21509311
 */
@Entity
public class Commande implements Serializable {
    //Propriétés Privées
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Client leCli;
    private ArrayList<Produit> lesProduits;
    private float montantTot;

    //Attributs Publics
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Client getLeCli() {
        return leCli;
    }
    public ArrayList<Produit> getLesProduits() {
        return lesProduits;
    }
    public float getMontantTot() {
        return montantTot;
    }
    public void setLeCli(Client leCli) {
        this.leCli = leCli;
    }
    public void setLesProduits(Produit unProduit) {
        this.lesProduits.add(unProduit);
    }
    public void setMontantTot(float montantTot) {
        this.montantTot = montantTot;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.PrestaZone.Commande[ id=" + id + " ]";
    }
    
}
