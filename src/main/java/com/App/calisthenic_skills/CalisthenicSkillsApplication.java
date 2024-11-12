package com.App.calisthenic_skills;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalisthenicSkillsApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(CalisthenicSkillsApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
