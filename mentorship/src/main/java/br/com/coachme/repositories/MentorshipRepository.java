package br.com.coachme.repositories;

import br.com.coachme.models.Mentorship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorshipRepository extends JpaRepository<Mentorship, Long> {
}
