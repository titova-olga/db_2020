package homework.exams_generation.exercises_generators;

import homework.exams_generation.operators.Operator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Evgeny Borisov
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Exercise {
    private double a;
    private double b;
    private double answer;
    private Operator operator;

    @Override
    public String toString() {
        return a + " " + operator.getSign() + " " + b + " = " + answer + "\n";
    }
}
