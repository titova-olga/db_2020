package homework.exams_generation.examinator_configuration;

import homework.exams_generation.exercises_generators.ExerciseGenerator;
import homework.exams_generation.operators.Operator;
import homework.exams_generation.exercises_generators.TemplateExerciseGenerator;

import java.util.Arrays;
import java.util.List;

public class AdultExaminatorConfig implements ExaminatorConfig {
    @Override
    public List<ExerciseGenerator> getExerciseGenerators() {
        return Arrays.asList(new TemplateExerciseGenerator(-1000, 1000,
                                List.of(Operator.PLUS, Operator.MINUS), false),

                            new TemplateExerciseGenerator(0, 100,
                                List.of(Operator.MULTIPLY), false),

                            new TemplateExerciseGenerator(0, 1000,
                                List.of(Operator.DIVIDE), false));
    }
}
