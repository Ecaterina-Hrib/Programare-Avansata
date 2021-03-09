package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <p>Using streams I ve created the objects</p>
 */
public class App {
    var students = IntStream.rangeClosed(0, 3)
            .mapToObj(i -> new Student("S" + i))
            .toArray(Student[]::new);
    var schools = IntStream.rangeClosed(0, 3)
            .mapToObj(i -> new School("H" + i))
            .toArray(School[]::new);
    /**
     * <p>Created the list for the students and aslo for the school I ve use a TreeSet</p>
     */
    List<Student> studentList = new ArrayList<>();
    for(
    Student s :students)

    {
        studentList.add(s);
    }

    TreeSet<School> schoolSet = new TreeSet<>();

    for(
    School h :schools)

    {
        schoolSet.add(h);

    }

    /**
     * <p>Sorted the students</p>
     */

    List<Student> newSortedList = studentList.stream()
            .sorted(Comparator.comparing(Student::getName))
            .collect(Collectors.toList());
    /**
     * <p>Created the maps and the lists for thr maps</p>
     */
    Map<Student, List<School>> stdPrefMap = new HashMap<>();

    List<School> prefList = new ArrayList<>();
   stdPrefMap.put(students[0],Arrays.asList(h[0],h[1],h[2]));

    Map<School, List<Student>> addmisionSch = new HashMap<>();
    addmisionSch.put(schools[0],Arrays.asList(s[0],s[1],s[2]));
    /**
     * <p>The result list with the students and their preference</p>
     */
    List<Student> result = studentList.stream()
            .filter(std -> stdPrefMap.get(std).containsAll(target))
            .collect(Collectors.toList < >);
    System.out.println(result);
}
