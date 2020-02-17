package br.com.tutorial.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.tutorial.domain.entities.Usuario;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByCodLogin(final String codLogin);

	boolean existsByCodLogin(final String codLogin);

	@Transactional
	@Modifying
	@Query("update Usuario u set u.senha = :novaSenha where u.codLogin = :codLogin")
	int atualizarSenha(@Param("novaSenha") String novaSenha, @Param("codLogin") String codLogin);

}
