package com.App.calisthenic_skills;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SkillRepository extends JpaRepository<Skill, Integer> {

    Optional<Skill> findByName(String name);
    List<Skill> findByDifficulty(String difficulty);
    List<Skill> findByProgress(String progress);
}
