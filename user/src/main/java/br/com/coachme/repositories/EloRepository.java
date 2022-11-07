package br.com.coachme.repositories;

import br.com.coachme.models.Elo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EloRepository extends JpaRepository<Elo, Long> {
}
