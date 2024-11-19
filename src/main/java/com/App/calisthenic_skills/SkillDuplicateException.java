package com.App.calisthenic_skills;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SkillDuplicateException extends RuntimeException {
    public SkillDuplicateException(int id) {

      super("Skill with this id already already exists. id: "+ id);
    }
}
