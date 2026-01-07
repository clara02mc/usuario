package com.studie.usuario.business.converter;

import com.studie.usuario.business.dto.EnderecoDTO;
import com.studie.usuario.business.dto.TelefoneDTO;
import com.studie.usuario.business.dto.UsuarioDTO;
import com.studie.usuario.infrastructure.entity.Endereco;
import com.studie.usuario.infrastructure.entity.Telefone;
import com.studie.usuario.infrastructure.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UsuarioConverter {

    public Usuario paraUsuario(UsuarioDTO usuarioDTO){
        return Usuario.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .enderecos(paraListaEnderecos(usuarioDTO.getEnderecos()))
                .telefones(paraListaTelefones(usuarioDTO.getTelefones()))
                .build();
    }

    public List<Endereco> paraListaEnderecos(List<EnderecoDTO> enderecoDTO){
        return enderecoDTO.stream().map(this::paraEndereco).toList();
    }

    public Endereco paraEndereco(EnderecoDTO enderecoDTO){
        return Endereco.builder()
                .rua(enderecoDTO.getRua())
                .numero(enderecoDTO.getNumero())
                .cidade(enderecoDTO.getCidade())
                .complemento(enderecoDTO.getComplemento())
                .cep(enderecoDTO.getCep())
                .estado(enderecoDTO.getEstado())
                .build();
    }

    public List<Telefone> paraListaTelefones(List<TelefoneDTO> telefoneDTO){
        return telefoneDTO.stream().map(this::paraTelefone).toList();
    }

    public Telefone paraTelefone(TelefoneDTO telefoneDTO){
        return Telefone.builder()
                .numero(telefoneDTO.getNumero())
                .ddd(telefoneDTO.getDdd())
                .build();
    }


     /* ======================
       ENTITY → DTO
       ====================== */

    public UsuarioDTO paraUsuarioDTO(Usuario entity) {
        return UsuarioDTO.builder()
                .nome(entity.getNome())
                .email(entity.getEmail())
                .enderecos(entity.getEnderecos().stream()
                        .map(this::enderecoEntityParaDto)
                        .toList())
                .telefones(entity.getTelefones().stream()
                        .map(this::telefoneEntityParaDto)
                        .toList())
                .build();
    }

    private EnderecoDTO enderecoEntityParaDto(Endereco entity) {
        return EnderecoDTO.builder()
                .rua(entity.getRua())
                .numero(entity.getNumero())
                .cidade(entity.getCidade())
                .estado(entity.getEstado())
                .cep(entity.getCep())
                .complemento(entity.getComplemento())
                .build();
    }

    private TelefoneDTO telefoneEntityParaDto(Telefone entity) {
        return TelefoneDTO.builder()
                .ddd(entity.getDdd())
                .numero(entity.getNumero())
                .build();


    }
}
