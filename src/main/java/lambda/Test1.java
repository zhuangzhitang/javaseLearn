package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 匿名类
 */
public class Test1 {
    public static void main(String[] args) {
        /**
         * 1.匿名内部类
         */
        new Thread(new Runnable() {
            public void run() {
                System.out.println("Before java8,too much code for too little to do");
            }
        }).start();

        new Thread(()-> System.out.println("In Java8,Lamda expression rocks!!")).start();

        /**
         * 2.对列表迭代
         */
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (String feature : features) {
            System.out.println(feature);
        }
        //使用Java8
        features.forEach(n-> System.out.println(n));
        features.forEach(System.out::println);

        /**
         * 3.使用lambda表达式和函数式接口Predicate
         */
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        System.out.println("Languages which starts with J :");
        filter(languages, (str)->str.startsWith("J"));

        System.out.println("Languages which ends with a ");
        filter(languages, (str)->str.endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, (str)->true);

        System.out.println("Print no language : ");
        filter(languages, (str)->false);

        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str)->str.length() > 4);

        /**
         *4. Java 8中使用lambda表达式的Map和Reduce示例
         */
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        /*for (Integer cost : costBeforeTax) {
            double price = cost + .12*cost;
            System.out.println(price);
        }*/
        // 使用lambda表达式
      //  costBeforeTax.stream().map((cost) -> cost + .12*cost).forEach(System.out::println);
        double bill = costBeforeTax.stream().map((cost) -> cost + .12*cost).reduce((sum, cost) -> sum + cost).get();
        System.out.println("Total : " + bill);

        // 创建一个字符串列表，每个字符串长度大于2
        List<String> strList= Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Ca");
        List<String> filtered = strList.stream().filter(x -> x.length()> 2).collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);

        // 将字符串换成大写并用逗号链接起来
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(G7Countries);

        // 用所有不同的数字创建一个正方形列表
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);

    }

    public static void filter(List<String> names, Predicate<String> condition){
      /*  for(String name : names){
            if(condition.test(name)){
                System.out.println(name + " ");
            }
        }*/
        names.stream().filter((name) -> (condition.test(name))).forEach((name)->System.out.println(name + " "));

    }
}
