package br.com.coachme.repositories;

import br.com.coachme.models.MentorshipRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MentorshipRequestRepository extends JpaRepository<MentorshipRequest, Long> {

    List<MentorshipRequest> findAllByStudentId(Long id);

    List<MentorshipRequest> findAllByDisponibilityId(Long id);

}
