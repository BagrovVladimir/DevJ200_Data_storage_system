/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Владимир
 */
@Entity
@Table(name = "CLIENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")
    , @NamedQuery(name = "Client.findByIdclient", query = "SELECT c FROM Client c WHERE c.idclient = :idclient")
    , @NamedQuery(name = "Client.findByType", query = "SELECT c FROM Client c WHERE c.type = :type")
    , @NamedQuery(name = "Client.findByModel", query = "SELECT c FROM Client c WHERE c.model = :model")
    , @NamedQuery(name = "Client.findByIp", query = "SELECT c FROM Client c WHERE c.ip = :ip")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCLIENT")
    private Integer idclient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "TYPE")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "MODEL")
    private String model;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "IP")
    private String ip;
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private Collection<Address> addressCollection;

    public Client() {
    }

//    public Client(Integer idclient) {
//        this.idclient = idclient;
//    }

    public Client(Integer idclient, String type, String model, String ip) {
        this.idclient = idclient;
        this.type = type;
        this.model = model;
        this.ip = ip;
    }
    
    public Client(String type, String model, String ip) {
        this.idclient = idclient;
        this.type = type;
        this.model = model;
        this.ip = ip;
    }

    public Integer getIdclient() {
        return idclient;
    }

    public void setIdclient(Integer idclient) {
        this.idclient = idclient;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @XmlTransient
    public Collection<Address> getAddressCollection() {
        return addressCollection;
    }

    public void setAddressCollection(Collection<Address> addressCollection) {
        this.addressCollection = addressCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclient != null ? idclient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.idclient == null && other.idclient != null) || (this.idclient != null && !this.idclient.equals(other.idclient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Client[ idclient=" + idclient + " ]";
    }
    
}
