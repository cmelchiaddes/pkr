package br.com.mavenpoker.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CAD_CLUBE")
@NamedQueries({
        @NamedQuery(name = "Clube.findAll", query = "FROM Clube"),
        @NamedQuery(name = "Clube.findById", query = "FROM Clube AS cb WHERE cb.id = :id"),
        @NamedQuery(name = "Clube.findByNome", query = "FROM Clube AS cb WHERE cb.nome = :nome"),
        @NamedQuery(name = "Clube.findByPorcentagemRake", query = "FROM Clube AS cb WHERE cb.porcentagemRake = :porcentagemRake")
})
public class Clube implements Serializable {

    private static final long serialVersionUID = -699183873528457824L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private Double porcentagemRake;
    @OneToMany(mappedBy = "clube", fetch = FetchType.LAZY)
    private List<GanhosSemanal> listaGanhosSemanais;
    @OneToMany(mappedBy = "clube", fetch = FetchType.LAZY)
    private List<Ppst> listaPpst;

}
