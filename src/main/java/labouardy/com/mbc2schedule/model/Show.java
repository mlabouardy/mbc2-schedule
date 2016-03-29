package labouardy.com.mbc2schedule.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mlabouardy on 28/03/16.
 */
public class Show implements Serializable{
    private Integer id;
    private String name;
    private String image;
    private String description;
    private String ksa;
    private String eg;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKsa() {
        return ksa;
    }

    public void setKsa(String ksa) {
        this.ksa = ksa;
    }

    public String getEg() {
        return eg;
    }

    public void setEg(String eg) {
        this.eg = eg;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
