package netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TasksTest {

    @Test
    public void shouldFindWordInSimpleTask() {
        SimpleTask task = new SimpleTask(5, "Позвонить родителям");

        boolean actual = task.matches("родителям");

        assertTrue(actual);
    }

    @Test
    public void shouldFindWordInEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Яйца");

        assertTrue(actual);
    }

    @Test
    public void shouldFindWordInMeetingTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка третьей версии приложения",
                "Приложение Нетобанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("Выкатка");

        assertTrue(actual);
    }

    @Test
    public void shouldFindWordInMeetingProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка третьей версии приложения",
                "Приложение Нетобанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("Нетобанка");

        assertTrue(actual);
    }

    @Test
    public void shouldNotFindWordInMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка третьей версии приложения",
                "Приложение Нетобанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("Молоко");

        assertFalse(actual);
    }
}


