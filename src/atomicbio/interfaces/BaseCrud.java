/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package atomicbio.interfaces;

import java.util.List;

/**
 *
 * @author SPron
 */
public interface BaseCrud {

    /**
     *
     * @param id
     * @return boolean saved true / false
     */
    public Boolean saveById(String id);

    /**
     *
     * @param id
     * @return boolean ipdated true / false
     */
    public Boolean updateById(String id);

    /**
     *
     * @param id
     * @return boolean deleted true / false
     */
    public Boolean deleteById(String id);

    /**
     *
     * @param id
     * @return info by id
     */
    public Object getById(String id);

    /**
     *
     * @return list all records
     */
    public List<Object> getAll();
}
