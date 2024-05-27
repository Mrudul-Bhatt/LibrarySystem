package com.example.LibrarySystem.LinkedinSystem.System3.Profile_Edu_Exp_Skill_Recomm_Achiev_Analy;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Profile {
    private String headline;
    private String about;
    private String gender;
    private List<Byte> profilePicture;
    private List<Byte> coverPhoto;
    private List<Experience> experiences;
    private List<Education> educations;
    private List<Skill> skills;
    private List<Achievement> achievements;
    private List<Recommendation> recommendations;
    private Analytics analytics;

    public boolean addExperience(Experience experience) {
        return experiences.add(experience);
    }

    public boolean addEducation(Education education) {
        return educations.add(education);
    }

    public boolean addSkill(Skill skill) {
        return skills.add(skill);
    }

    public boolean addAchievement(Achievement achievement) {
        return achievements.add(achievement);
    }

    public boolean addRecommendation(Recommendation recommendation) {
        return recommendations.add(recommendation);
    }

    public boolean removeExperience(Experience experience) {
        return experiences.remove(experience);
    }

    public boolean removeEducation(Education education) {
        return educations.remove(education);
    }

    public boolean removeSkill(Skill skill) {
        return skills.remove(skill);
    }

    public boolean removeAchievement(Achievement achievement) {
        return achievements.remove(achievement);
    }

    public boolean removeRecommendation(Recommendation recommendation) {
        return recommendations.remove(recommendation);
    }

    public Experience getExperienceById(String id) {
        for (Experience exp : experiences) {
            if (Objects.equals(exp.getExperienceId(), id)) {
                return exp;
            }
        }
        return null;
    }

    public Education getEducationById(String id) {
        for (Education edu : educations) {
            if (Objects.equals(edu.getEducationId(), id)) {
                return edu;
            }
        }
        return null;
    }

    public Skill getSkillByName(String name) {
        for (Skill skill : skills) {
            if (skill.getName().equals(name)) {
                return skill;
            }
        }
        return null;
    }

    public Achievement getAchievementById(String id) {
        for (Achievement ach : achievements) {
            if (Objects.equals(ach.getAchievementId(), id)) {
                return ach;
            }
        }
        return null;
    }

    public Recommendation getRecommendationById(String id) {
        for (Recommendation rec : recommendations) {
            if (Objects.equals(rec.getRecommendationId(), id)) {
                return rec;
            }
        }
        return null;
    }
}
