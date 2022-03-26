/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package atomicbio.interfaces;

/**
 *
 * @author SPron
 */
public interface Prestador extends BaseCrud {    
    public Long getId();
    public String getNome();
    public String getConselho();
    public String getCpf();
    public String getRg();
    public String getEspecialidade();
    public String getHoraTrabalhada();
    public void setId(Long Id);
    public void setNome(String Nome);
    public void setConselho(String Conselho);
    public void setCpf(String Cpf);
    public void setRg(String Rg);
    public void setEspecialidade(String Especialidade);
    public void setHoraTrabalhada(String HoraTrabalhada);
}
