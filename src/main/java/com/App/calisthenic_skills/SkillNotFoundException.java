package com.App.calisthenic_skills;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SkillNotFoundException extends RuntimeException{

    public SkillNotFoundException(){
        super("Skill not found");
    }
}
