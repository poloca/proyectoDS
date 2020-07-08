/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.backing;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author desa
 */
@Named(value = "imagenesBean")
@RequestScoped
public class ImagenesBean {

    public ImagenesBean() {
    }
    
    private List<String> images;
     
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 9; i++) {
            images.add("food" + i + ".jpg");
        }
    }
 
    public List<String> getImages() {
        return images;
    }
    
}
