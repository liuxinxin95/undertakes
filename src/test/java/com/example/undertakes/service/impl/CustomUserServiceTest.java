package com.example.undertakes.service.impl;

import com.example.undertakes.UndertakesApplication;
import com.example.undertakes.service.Converter;
import com.example.undertakes.service.Formula;
import com.google.common.base.Supplier;
import net.minidev.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {UndertakesApplication.class})
public class CustomUserServiceTest {

    @Autowired
    private CustomUserServiceImpl customUserServiceimpl;

    private static double calculate(int a) {
        return((double)(a));
    }


    @Test
    public void findList() {
//        LocalDate today = LocalDate.of(2019,2,22);
//        System.out.println("今天的日期:"+today);

        LocalDate date1 = LocalDate.now();

//        LocalDate date2 = LocalDate.of(2018, 2, 6);
//        MonthDay birthday = MonthDay.of(date2.getMonth(), date2.getDayOfMonth());
//        MonthDay currentMonthDay = MonthDay.from(date1);
//
//        if (currentMonthDay.equals(birthday)) {
//            System.out.println("是你的生日");
//        } else {
//            System.out.println("你的生日还没有到");
//        }
        long l1 = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        System.out.println(l1);
        long l2 = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(l2);
        Clock clock = Clock.systemUTC();
        System.out.println("Clock : " + clock.millis());
        Clock defaultClock = Clock.systemDefaultZone();
        System.out.println("Clock : " + defaultClock.millis());



        LocalDate java8Release = LocalDate.of(2018, 12, 14);

        Period periodToNextJavaRelease = Period.between(date1, java8Release);
        System.out.println("Months left between today and Java 8 release : "
                + periodToNextJavaRelease.getMonths() );


        String dayAfterTommorrow = "20180205";
        LocalDate formatted = LocalDate.parse(dayAfterTommorrow,
                DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(dayAfterTommorrow+"  格式化后的日期为:  "+formatted);


        LocalDateTime date = LocalDateTime.now();

        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        //日期转字符串
        String str = date.format(format1);

        System.out.println("日期转换为字符串:"+str);

        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        //字符串转日期
        LocalDate date2 = LocalDate.parse(str,format2);
        System.out.println("日期类型:"+date2);

    }

    @Test
    public void test1(){
//        Converter<String, Integer> converter = Integer::valueOf;
//        Integer converted = converter.convert("123");
//        System.out.println(converted);    // 123
//        Converter<String, UserDetails> stringIntegerConverter = customUserServiceimpl::loadUserByUsername;
//        UserDetails user = stringIntegerConverter.convert("admin");
//        System.out.println(converted);

        List<String> list =  new ArrayList<>(Arrays.asList("peter", "anna", "mike", "xenia"));
        list.stream().count();
        list.stream().limit(10).forEach(System.out::println);
        List<String> collect = list.stream().sorted(Comparator.comparing(x->x)).collect(Collectors.toList());
        List<String> collect1 = list.stream().limit(3).collect(Collectors.toList());
        System.out.println(collect1.size());
        list.removeAll(collect1);
        System.out.println(list.size());
        int num = 1;
        collect1.stream().forEach(x->{
            list.add("1");
        });
    }

    @Test
    public void test2(){
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        formula.calculate(100);     // 100.0
        formula.sqrt(16);           // 4.0

        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });
        Formula formula1 = CustomUserServiceTest::calculate;
    }

    @Test
    public void test3(){
//        Supplier<Person> personSupplier = Person::new;
//        Person person = personSupplier.get();// new Person
//        System.out.println(person.toString());
//
        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
//        greeter.accept(new Person("Luke", "Skywalker"));
//
//        String url = String.format(
//
//                "http://maps.google.cn/maps/api/geocode/json?latlng=%s,%s&language=CN",
//
//                "121.3466440","31.2990170");
//        System.out.println(url);

//        Formula formula = new Formula() {
//            @Override
//            public double calculate(int a) {
//                return sqrt(a);
//            }
//        };
//        double calculate1 = formula.calculate(100);
//        double calculate = formula.calculate(16);
//        System.out.println(calculate1);
//        System.out.println(calculate);

        Formula formula1 = mas-> mas;
        double calculate = formula1.calculate(16);
        double sqrt = formula1.sqrt(16);

        System.out.println(calculate);
        System.out.println(sqrt);
        Supplier<Person> personSupplier = Person::new;
//        http://api.map.baidu.com/geocoder?location=30.185026,120.226765&output=json&key=sWQWEkqp8XBLKxoxgRybbSKkEeeaHys1
//        根据经纬度查询当前城市
    }


    class Person {
        String firstName;
        String lastName;

        Person() {}

        Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }

}