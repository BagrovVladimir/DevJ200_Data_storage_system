/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Владимир
 */
@Entity
@Table(name = "ADDRESS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
    , @NamedQuery(name = "Address.findByIdaddress", query = "SELECT a FROM Address a WHERE a.idaddress = :idaddress")
    , @NamedQuery(name = "Address.findByCity", query = "SELECT a FROM Address a WHERE a.city = :city")
    , @NamedQuery(name = "Address.findByStreet", query = "SELECT a FROM Address a WHERE a.street = :street")
    , @NamedQuery(name = "Address.findByNum", query = "SELECT a FROM Address a WHERE a.num = :num")
    , @NamedQuery(name = "Address.findBySubnum", query = "SELECT a FROM Address a WHERE a.subnum = :subnum")
    , @NamedQuery(name = "Address.findByFlat", query = "SELECT a FROM Address a WHERE a.flat = :flat")
    , @NamedQuery(name = "Address.findByExtra", query = "SELECT a FROM Address a WHERE a.extra = :extra")})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDADDRESS")
    private Integer idaddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "CITY")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "STREET")
    private String street;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM")
    private int num;
    @Column(name = "SUBNUM")
    private Integer subnum;
    @Column(name = "FLAT")
    private Integer flat;
    @Size(max = 128)
    @Column(name = "EXTRA")
    private String extra;
    @JoinColumn(name = "CLIENT", referencedColumnName = "IDCLIENT")
    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;

    public Address() {
    }

//    public Address(Integer idaddress) {
//        this.idaddress = idaddress;
//    }

    public Address(Integer idaddress, String city, String street, int num) {
        this.idaddress = idaddress;
        this.city = city;
        this.street = street;
        this.num = num;
    }

    public Integer getIdaddress() {
        return idaddress;
    }

    public void setIdaddress(Integer idaddress) {
        this.idaddress = idaddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Integer getSubnum() {
        return subnum;
    }

    public void setSubnum(Integer subnum) {
        this.subnum = subnum;
    }

    public Integer getFlat() {
        return flat;
    }

    public void setFlat(Integer flat) {
        this.flat = flat;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaddress != null ? idaddress.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.idaddress == null && other.idaddress != null) || (this.idaddress != null && !this.idaddress.equals(other.idaddress))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Address[ idaddress=" + idaddress + " ]";
    }
    
}
