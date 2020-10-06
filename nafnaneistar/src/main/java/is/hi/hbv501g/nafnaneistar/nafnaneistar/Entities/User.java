package is.hi.hbv501g.nafnaneistar.nafnaneistar.Entities;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String email;
    private String password;
    @Lob
    private ArrayList<Integer> availableNames;
    private ArrayList<Integer> approvedNames;
    private ArrayList<Integer> linkedPartners;


    public User() {

    }

    public User(String name, String email, String password, ArrayList<Integer> availableNames){
        this.name = name;
        this.email = email;
        this.password = password;
        this.availableNames = availableNames;
        this.approvedNames = new ArrayList<Integer>();
        this.linkedPartners = new ArrayList<Integer>();
    }


    /*
    Custom Functions and Metods
    */
    
    public ArrayList<Integer> approveName(Integer id){
        int index = this.availableNames.indexOf(id);
        this.approvedNames.add(this.availableNames.remove(index));
        return this.availableNames;
    }

    public ArrayList<Integer> disapproveName(Integer id){
        int index = this.availableNames.indexOf(id);
        this.availableNames.remove(index);
        return this.availableNames;
    }

    public void addLinkedPartner(Integer id){
        this.linkedPartners.add(id);
    }

    public boolean removeLinkedPartner(Integer id){
        return this.linkedPartners.remove(id);
    }

    /*
    Getters and Setters    
    */

    public long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public ArrayList<Integer> getAvailableNames(){
        return this.availableNames;
    }
    public void setAvailableNames(ArrayList<Integer> ids){
        this.availableNames = ids;

    }
    public ArrayList<Integer> getApprovedNames(){
        return this.approvedNames;
    }
    public ArrayList<Integer> getLinkedPartners(){
        return this.linkedPartners;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
