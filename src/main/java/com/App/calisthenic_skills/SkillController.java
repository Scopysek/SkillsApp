package com.App.calisthenic_skills;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/skills")
public class SkillController {

    private final SkillRepository skillRepository;

    @Autowired
    public SkillController(SkillRepository skillRepository){
        this.skillRepository = skillRepository;
    }

    //GET
    @GetMapping("")
    public List<Skill> getSkills(){
        return skillRepository.getSkills();
    }

    @GetMapping("/skillId/{id}")
    public Skill getSkillByID(@PathVariable Integer id){

        Optional<Skill> skill = skillRepository.getSkillByID(id);
        if (skill.isEmpty()){
            throw new SkillNotFoundException();
        }
        return skill.get();

    }

    @GetMapping("/skillName/{name}")
    public Skill getSkillByName(@PathVariable String name){return skillRepository.getSkillByName(name);}

    //POST(CREATE)
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void createSkill(@Valid @RequestBody Skill skill){ skillRepository.createSkill(skill);}

    //PUT(UPDATE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void updateSkill(@Valid @RequestBody Skill skill, @PathVariable Integer id){
        skillRepository.updateSkill(skill,id);
    }

    //DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void deleteSkill(@PathVariable Integer id){
        skillRepository.deleteSkill(id);

    }
}
