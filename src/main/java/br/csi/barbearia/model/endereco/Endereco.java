package br.csi.barbearia.model.endereco;


import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String complemento;
    @NotBlank
    private String bairro;
    @Size(min = 8, max =9, message = "CEP inválido")
    private String cep;
    @NotBlank
    private String numero;
    @NotBlank
    private String cidade;
    @NotBlank
    @Size(max = 2)
    private String uf;
}



//@Pattern(regexp = "\\d{5}-\\d{3}", message = "Padrão de cep deve ser 99999-999")