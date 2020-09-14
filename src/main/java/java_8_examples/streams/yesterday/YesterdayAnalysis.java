package java_8_examples.streams.yesterday;

import lombok.SneakyThrows;

import javax.print.attribute.IntegerSyntax;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class YesterdayAnalysis {

    @SneakyThrows
    public static long countWordsInText(String fileName) {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        return bufferedReader.lines()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .count();
    }

    @SneakyThrows
    public static String getMostFrequentWordInText(String fileName) {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        return bufferedReader.lines()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet()
                .stream()
                .min(Comparator.comparingLong(Map.Entry::getValue))
                .get()
                .getKey();
    }

    @SneakyThrows
    public static void main(String[] args) {
        String fileName = "C:\\Users\\Olga\\IdeaProjects\\db_2020\\data\\yest.txt";
        System.out.println(YesterdayAnalysis.countWordsInText(fileName));
        System.out.println(getMostFrequentWordInText(fileName));
    }
}
