package homework.exams_generation.examinator_configuration;

import homework.exams_generation.exercises_generators.ExerciseGenerator;

import java.util.List;

public interface ExaminatorConfig {
    List<ExerciseGenerator> getExerciseGenerators();
}
