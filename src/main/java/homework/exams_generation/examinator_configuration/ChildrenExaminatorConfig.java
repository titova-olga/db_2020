package homework.exams_generation.examinator_configuration;

import homework.exams_generation.exercises_generators.ExerciseGenerator;
import homework.exams_generation.operators.Operator;
import homework.exams_generation.exercises_generators.TemplateExerciseGenerator;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class ChildrenExaminatorConfig implements ExaminatorConfig {
    private final List<ExerciseGenerator> exerciseGenerators =

            Arrays.asList(new TemplateExerciseGenerator(0, 50,
                                  List.of(Operator.PLUS), true),

                          new TemplateExerciseGenerator(0, 30,
                                  List.of(Operator.MINUS), true));
}
