package com.votation.api.repository;

import com.votation.api.entity.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface VoteRepository extends JpaRepository<VoteEntity, UUID> {
    List<VoteEntity> findByIdSchedule(UUID idSchedule);

}
