package com.App.calisthenic_skills;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;


@Repository
public class SkillRepositoryData {

//    private static final Logger log = LoggerFactory.getLogger(SkillRepositoryData.class);
//    private final JdbcClient jdbcClient;
//
//    public SkillRepositoryData(JdbcClient jdbcClient) {
//        this.jdbcClient = jdbcClient;
//    }
//
//    public List<Skill> getSkills(){
//        return jdbcClient.sql("SELECT * FROM Skill")
//                .query(Skill.class)//maping to data class model
//                .list();//returning list
//    }
//
//    public Optional<Skill> getSkillByID(Integer id){
//        return jdbcClient.sql("SELECT * FROM Skill WHERE id= :id")
//                .param("id",id)
//                .query(Skill.class)
//                .optional();
//
//    }
//
//    public Skill getSkillByName(String name) {
//        return jdbcClient.sql("SELECT * FROM Skill WHERE name = :name")
//                .param("name",name)
//                .query(Skill.class)
//                .single();
//    }
//
//    public void createSkill(@Valid Skill skill) {
//        var updated = jdbcClient.sql("INSERT INTO Skill(id,name,description,difficulty,progress) VALUES(?,?,?,?,?)")
//                .params(List.of(skill.id,skill.getName(),skill.getDescription(),skill.getDifficulty(),skill.getProgress()))
//                .update();
//
//        Assert.state(updated == 1,"Failed to create skill"  + skill.getName());
//
//    }
//
//    public void updateSkill(@Valid Skill skill, Integer id) {
//        var updated = jdbcClient.sql("UPDATE Skill SET name = ?, description = ?, difficulty = ?, progress = ? WHERE id = ?")
//                .params(List.of(skill.getName(),skill.getDescription(),skill.getDifficulty(), skill.getProgress(),id))
//                .update();
//
//        Assert.state(updated == 1,"Failed to update skill"  + skill.getName());
//
//
//    }
//
//    public void deleteSkill(Integer id) {
//        var updated = jdbcClient.sql("DELETE FROM Skill WHERE id = :id")
//                .param("id",id)
//                .update();
//
//        Assert.state(updated == 1,"Failed to delete skill.. skill id: "  + id);
//
//    }
//    public int count(){
//        return jdbcClient.sql("SELECT * FROM Skill").query().listOfRows().size();
//    }
//    public void saveAll(List<Skill> list){
//        list.stream().forEach(this::createSkill);
//    }
}
