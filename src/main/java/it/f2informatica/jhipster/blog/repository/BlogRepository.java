package it.f2informatica.jhipster.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.f2informatica.jhipster.blog.domain.Blog;

/**
 * Spring Data repository for the Blog entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

	@Query("select blog from Blog blog where blog.user.login = ?#{principal.username}")
	List<Blog> findByUserIsCurrentUser();

}
