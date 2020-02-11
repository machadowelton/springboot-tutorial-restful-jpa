package br.com.tutorial.domain;

import br.com.tutorial.domain.audits.AuditModel;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "livros")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Livro extends AuditModel {

	private static final long serialVersionUID = -7359271269535007899L;
	
	@Id
	@GeneratedValue(
	    strategy= GenerationType.AUTO, 
	    generator="native"
	)
	@GenericGenerator(
	    name = "native", 
	    strategy = "native"
	)
	private Long id;

}
