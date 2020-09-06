package homework.exams_generation;

import heroes.RandomUtil;
import homework.exams_generation.examinator_configuration.ChildrenExaminatorConfig;
import homework.exams_generation.examinator_configuration.ExaminatorConfig;
import homework.exams_generation.exercises_generators.Exercise;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Evgeny Borisov
 */
public class Examinator {

    private ExaminatorConfig examinatorConfig;

    public Examinator(ExaminatorConfig config) {
        this.examinatorConfig = config;
    }

    public List<Exercise> generate(int amount) {

        return Stream.generate(
                () -> RandomUtil.randomItem(examinatorConfig.getExerciseGenerators()).generate())
                .limit(amount)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        Examinator examinator = new Examinator(new ChildrenExaminatorConfig());
        List<Exercise> exercises = examinator.generate(5);
        for (Exercise exercise : exercises) {
            System.out.println(exercise);
        }
    }
}
