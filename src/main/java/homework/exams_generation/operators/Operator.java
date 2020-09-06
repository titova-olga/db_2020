package homework.exams_generation.operators;

import homework.exams_generation.operators.BinaryOperation;
import homework.exams_generation.operators.DivideBinaryOperation;
import homework.exams_generation.operators.MinusBinaryOperation;
import homework.exams_generation.operators.PlusBinaryOperation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Evgeny Borisov
 */
@RequiredArgsConstructor
@Getter
public enum Operator {
    PLUS("+", new PlusBinaryOperation()),
    MINUS("-", new MinusBinaryOperation()),
    MULTIPLY("*", new MinusBinaryOperation()),
    DIVIDE("/", new DivideBinaryOperation());

    private final String sign;
    private final BinaryOperation operation;
}
