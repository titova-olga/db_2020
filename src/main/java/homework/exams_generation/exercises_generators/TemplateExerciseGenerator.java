package homework.exams_generation.exercises_generators;

import heroes.RandomUtil;
import homework.exams_generation.operators.Operator;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class TemplateExerciseGenerator implements ExerciseGenerator {

    private int min = 0;
    private int max = 100;
    private List<Operator> validOperators = Arrays.asList(Operator.values());
    private boolean isSimple = false;

    public TemplateExerciseGenerator() {
    }

    public TemplateExerciseGenerator(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public Exercise generate() {

        Operator operator = RandomUtil.randomItem(validOperators);
        int a = RandomUtil.getIntBetween(min, max);
        int b = isSimple ? RandomUtil.getIntBetween(min, a) : RandomUtil.getIntBetween(min, max);

        return Exercise.builder()
                .a(a)
                .b(b)
                .operator(operator)
                .answer(operator.getOperation().operate(a, b))
                .build();
    }
}
