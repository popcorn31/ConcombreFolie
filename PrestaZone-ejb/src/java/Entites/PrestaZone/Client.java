/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites.PrestaZone;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author 21509311
 */
@Entity
public class Client implements Serializable {

    //Propriétés Privées
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     private String nom;
    private String prenom;
    private String adresse;
    private String mail;
    private String login;
    private String mp;
    
    @OneToMany
    private ArrayList<Commande> lesCommandes;
    
    //Attributs Publics
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public ArrayList<Commande> getlesCommandes() {
        return lesCommandes;
    }
    public void setlesCommandes(Commande uneCommande) {
        this.lesCommandes.add(uneCommande);
    }

    //Constructeur(s)
    public Client(){};
    public Client(String p_nom, String p_prenom, String p_adresse, String p_mail, String p_login, String p_mp ){
        nom = p_nom;
        prenom = p_prenom;
        adresse = p_adresse;
        mail = p_mail;
        login = p_login;
        mp = p_mp;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMp() {
        return mp;
    }

    public void setMp(String mp) {
        this.mp = mp;
    }

    public ArrayList<Commande> getLesCommandes() {
        return lesCommandes;
    }

 
    
    //Méthodes et fonctions
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.PrestaZone.Client[ id=" + id + " ]";
    }
    
}
