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

    //private final SkillRepositoryData skillRepository;
    private final SkillRepository skillRepo;


    @Autowired
    public SkillController(SkillRepository skillRepo){
        this.skillRepo = skillRepo;
    }

    //GET
    @GetMapping("")
    public List<Skill> getSkills(){
        List<Skill> list = skillRepo.findAll();
        return list;
    }

    @GetMapping("/id/{id}")
    public Skill getSkillByID(@PathVariable Integer id){

        Optional<Skill> skill = skillRepo.findById(id);
        if (skill.isEmpty()){
            throw new SkillNotFoundException();
        }
        return skill.get();

    }

    @GetMapping("/name/{name}")
    public Optional<Skill> getSkillByName(@PathVariable String name){return skillRepo.findByName(name);}
    @GetMapping("/difficulty/{difficulty}")
    public List<Skill> getSkillByDifficulty(@PathVariable String difficulty){return skillRepo.findByDifficulty(difficulty);}
    @GetMapping("/progress/{progress}")
    public List<Skill> getSkillByPorgress(@PathVariable String progress){return skillRepo.findByProgress(progress);}

    //POST(CREATE)
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void createSkill(@Valid @RequestBody Skill skill){
        if (skillRepo.existsById(skill.getId())) {
            throw new SkillDuplicateException(skill.getId());
        }
        skillRepo.save(skill);

    }

    //PUT(UPDATE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void updateSkill(@Valid @RequestBody Skill updatedSkill, @PathVariable Integer id){
        Skill existingSkill = skillRepo.findById(id).orElseThrow(() -> new SkillNotFoundException());

        existingSkill.setName(updatedSkill.getName());
        existingSkill.setDescription(updatedSkill.getDescription());
        existingSkill.setDifficulty(updatedSkill.getDifficulty());
        existingSkill.setProgress(updatedSkill.getProgress());

        skillRepo.save(existingSkill);

    }

    //DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void deleteSkill(@PathVariable Integer id){
        skillRepo.deleteById(id);

    }
    //DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("deleteAll")
    void deleteAll(){
        skillRepo.deleteAll();

    }

}
