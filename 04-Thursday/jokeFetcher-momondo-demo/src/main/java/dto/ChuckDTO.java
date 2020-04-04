/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Frederik
 */
public class ChuckDTO {
    
    String value;
    String url = "https://api.chucknorris.io/jokes";

    public ChuckDTO(String value) {
        this.value = value;
        //this.url = "https://api.chucknorris.io/jokes";
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
    
}
