/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.entity.facades;

import apc.proy.entity.IngxRec;
import apc.proy.entity.Receta;
import apc.proy.model.dto.IRNombres;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author desa
 */
@Local
public interface IngxRecFacadeLocal {

    void create(IngxRec ingxRec);

    void edit(IngxRec ingxRec);

    void remove(IngxRec ingxRec);

    IngxRec find(Object id);

    List<IngxRec> findAll();

    List<IngxRec> findRange(int[] range);

    int count();
    
    public List<IngxRec> findIRByReceta(int recid);
    
    public List<IRNombres> findIRNamesByReceta(int recid);
    
    public List<Receta> findRecetasByIng(int ingid);
    
}
