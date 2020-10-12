package projetoSpringdata;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.projetoSpringdata.dao.UsuarioRepository;
import com.projetoSpringdata.model.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:META-INF/spring-config.xml"})
public class TestSpring {
	
	@Autowired
	private UsuarioRepository repo;
	
	@Test
	public void initCadastro() {
		Usuario user = new Usuario("ThaisR", "123", "Thais", "thais@gmail.com", 28);
		repo.save(user);
		System.out.println("foi");
	}
	
	@Test
	public void initPesquisaId() {
		Optional<Usuario> user = repo.findById(1L);
		System.out.println("Id:" + user.get().getId());
		System.out.println(user.get().getLogin());
		System.out.println(user.get().getSenha());
		System.out.println(user.get().getNome());
		System.out.println(user.get().getEmail());
		System.out.println(user.get().getIdade());
		
	}
	
	@Test
	public void initPesquisaTodos() {
		Iterable<Usuario> user = repo.findAll();
		
		for (Usuario usuario : user) {
			System.out.println("Id:" + usuario.getId());
			System.out.println(usuario.getLogin());
			System.out.println(usuario.getSenha());
			System.out.println(usuario.getNome());
			System.out.println(usuario.getEmail());
			System.out.println(usuario.getIdade());
			System.out.println("---------------------------------");
		}
	}
	
	@Test
	public void initUpdate() {
		Optional<Usuario> user = repo.findById(1L);
		Usuario userUpdate = user.get();
		userUpdate.setNome("Lucas Fernando Pontes");
		repo.save(userUpdate);
	}
	
}
