/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atomicbio.models;

import atomicbio.interfaces.Prestador;
import java.util.List;


public class Medicos implements Prestador {

    private Long Id;
    private String Nome;
    private String Conselho;
    private String Cpf;
    private String Rg;
    private String Especialidade;
    private String HoraTrabalhada;

    /**
     *
     * @param Nome
     * @param Conselho
     * @param Cpf
     * @param Rg
     * @param Especialidade
     * @param HoraTrabalhada
     */
    public void Prestador(
        String Nome,
        String Conselho,
        String Cpf,
        String Rg,
        String Especialidade,
        String HoraTrabalhada
    ) {
        this.Nome = Nome;
        this.Conselho = Conselho;
        this.Cpf = Cpf;
        this.Rg = Rg;
        this.Especialidade = Especialidade;
        this.HoraTrabalhada = HoraTrabalhada;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Boolean saveById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Boolean updateById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Boolean deleteById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Object getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     *
     * @return
     */
    @Override
    public List<Object> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     *
     * @return
     */
    @Override
    public Long getId() {
        return this.Id;
    }

    /**
     *
     * @return
     */
    @Override
    public String getNome() {
        return this.Nome;
    }

    /**
     *
     * @return
     */
    @Override
    public String getConselho() {
        return this.Conselho;
    }

    /**
     *
     * @return
     */
    @Override
    public String getCpf() {
        return this.Cpf;
    }

    /**
     *
     * @return
     */
    @Override
    public String getRg() {
        return this.Rg;
    }

    /**
     *
     * @return
     */
    @Override
    public String getHoraTrabalhada() {
        return this.HoraTrabalhada;
    }

    /**
     *
     * @return
     */
    @Override
    public String getEspecialidade() {
        return this.Especialidade;
    }

    /**
     *
     * @param Conselho
     */
    @Override
    public void setConselho(String Conselho) {
        this.Conselho = Conselho;
    }

    /**
     *
     * @param Cpf
     */
    @Override
    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

    /**
     *
     * @param Especialidade
     */
    @Override
    public void setEspecialidade(String Especialidade) {
        this.Especialidade = Especialidade;
    }

    /**
     *
     * @param HoraTrabalhada
     */
    @Override
    public void setHoraTrabalhada(String HoraTrabalhada) {
        this.HoraTrabalhada = HoraTrabalhada;
    }

    /**
     *
     * @param Id
     */
    @Override
    public void setId(Long Id) {
        this.Id = Id;
    }

    /**
     *
     * @param Nome
     */
    @Override
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    /**
     *
     * @param Rg
     */
    @Override
    public void setRg(String Rg) {
        this.Rg = Rg;
    }
}
