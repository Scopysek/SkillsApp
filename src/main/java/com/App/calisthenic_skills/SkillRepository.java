package com.App.calisthenic_skills;

import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class SkillRepository {

    public List<Skill> skills = new ArrayList<>();

    public List<Skill> getSkills(){
        return skills;
    }

    public Optional<Skill> getSkillByID(Integer id){
        return skills.stream()
                .filter(skill -> skill.id == id)
                .findFirst();
    }
    public Skill getSkillByName(String name){
        return skills.stream()
                .filter(skill -> skill.getName().equalsIgnoreCase(name))  // Case-insensitive matching
                .findFirst()
                .orElse(null);
    }
    public void updateSkill(Skill skill,Integer id){
        Optional<Skill> existingSkill = getSkillByID(id);
        if (existingSkill.isPresent()){
            skills.set(skills.indexOf(existingSkill.get()),skill);
        }
    }
    public void deleteSkill(Integer id){
        skills.removeIf(skill -> skill.getId().equals(id));

    }
    public void createSkill(Skill skill){
        //checking for skill with existing id
        for (int i=0;i<skills.size();i++){
            if (skills.get(i).getId()==skill.getId()) {
                throw new ResponseStatusException(HttpStatus.MULTI_STATUS,"already created");
            }
        }
        skills.add(skill);
    }


    @PostConstruct
    private void init() {
        skills.add(new Skill(1, "Planche", "An advanced balance on hands with the body parallel to the ground", "Advanced", "In Progress"));
        skills.add(new Skill(2, "Handstand", "Balancing upside down on hands with straight arms", "Intermediate", "Not Started"));
        skills.add(new Skill(3, "Pull-Up", "A pulling exercise lifting the body up to a bar", "Beginner", "Completed"));
        skills.add(new Skill(4, "Muscle-Up", "A pull-up with a transition into a dip on top of the bar", "Advanced", "In Progress"));
        skills.add(new Skill(5, "L-Sit", "Holding a seated position with legs extended while supporting with arms", "Intermediate", "Not Started"));
        skills.add(new Skill(6, "Pistol Squat", "A one-legged squat while extending the other leg forward", "Intermediate", "Not Started"));
    }
}
