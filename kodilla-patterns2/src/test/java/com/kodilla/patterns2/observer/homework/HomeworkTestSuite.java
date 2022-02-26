package com.kodilla.patterns2.observer.homework;

import com.kodilla.patterns2.observer.homework.mentors.JohnSmithMentor;
import com.kodilla.patterns2.observer.homework.mentors.Mentor;
import com.kodilla.patterns2.observer.homework.mentors.RobertEvansMentor;
import com.kodilla.patterns2.observer.homework.students.AliciaPotterStudentHomework;
import com.kodilla.patterns2.observer.homework.students.Homework;
import com.kodilla.patterns2.observer.homework.students.KylieScottStudentHomework;
import com.kodilla.patterns2.observer.homework.students.TomHudsonStudentHomework;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class HomeworkTestSuite {
    @Test
    public void testHomeworkUpdate(){
        //Given
        Homework aliciaPotterHomework = new AliciaPotterStudentHomework();
        Homework kylieScottHomework = new KylieScottStudentHomework();
        Homework tomHudsonHomework = new TomHudsonStudentHomework();

        Mentor johnSmithMentor = new JohnSmithMentor();
        Mentor robertEvansMentor = new RobertEvansMentor();

        aliciaPotterHomework.registerMentor(johnSmithMentor);
        kylieScottHomework.registerMentor(robertEvansMentor);
        tomHudsonHomework.registerMentor(robertEvansMentor);

        //When
        aliciaPotterHomework.addModule(12.2);
        aliciaPotterHomework.addModule(12.3);
        kylieScottHomework.addModule(6.1);
        kylieScottHomework.addModule(6.2);
        tomHudsonHomework.addModule(18.3);
        tomHudsonHomework.addModule(18.4);
        tomHudsonHomework.addModule(19.1);

        //Then
        assertEquals(2, johnSmithMentor.getUpdateCount());
        assertEquals(5, robertEvansMentor.getUpdateCount());
    }
}
