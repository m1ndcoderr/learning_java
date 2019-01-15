package ru.evgenyhodz;

import org.junit.Before;
import org.junit.Test;
import ru.evgenyhodz.models.Application;
import ru.evgenyhodz.start.Input;
import ru.evgenyhodz.start.StartUI;
import ru.evgenyhodz.start.StubInput;
import ru.evgenyhodz.start.Tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class to emulate user's behavior.
 */
public class StubInputTest {
    /**
     * Reference to application.
     */
    private Application appForTests;

    /**
     * Set start parameters to new application object before tests.
     */
    @Before
    public void setStartApp() {
        appForTests = new Application(null, null, null, null, null);

    }

    /**
     * User select "Add application", text name and exit.
     */
    @Test
    public void whenUserChoose0ThenNewApplicationIsAddingToApplicationsRepositoryTest() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{
                "0", //Select Add.
                "Frodo", //Text name of application.
                "9", "y", //Exit.
        });
        new StartUI(input, tracker).init();
        assertThat(tracker.showByName("Frodo").getName(), is("Frodo"));
    }

    /**
     * User select "Edit application", type name, description, creation date and exit.
     */
    @Test
    public void whenUserChoose1ToEditThenWeWillHaveTheEditedApplicationTest() {
        Tracker tracker = new Tracker();
        tracker.addApp(appForTests);
        Input input = new StubInput(new String[]{"1", appForTests.getId(),
                "name", "desc", "1999", "1", "31", "9", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.showByName("name").getComment(), is("31/1/1999"));

    }

    /**
     * User select "Create comment", type some phrase, and exit.
     */
    @Test
    public void whenUserChoose2ThenWeWillHaveNewCommentForApplicationTest() {
        Tracker tracker = new Tracker();
        tracker.addApp(appForTests);
        Input input = new StubInput(new String[]{"2", appForTests.getId(), "Comment for test", "9", "y"});
        new StartUI(input, tracker).init();
        assertThat(appForTests.getComment(), is("Comment for test"));
    }

    /**
     * User select 3 - delete application.
     */
    @Test
    public void whenUserChoose3ThenWeShouldHaveDeletedApplicationTest() {
        Tracker tracker = new Tracker();
        tracker.addApp(appForTests);
        Application[] forTest = {};
        Input input = new StubInput(new String[]{"3", appForTests.getId(), "9", "y"});
        new StartUI(input, tracker).init();
     //   assertThat(tracker.showApps(), is(forTest));
    }

    /**
     * User choose "Show ALL Applications".
     */
    @Test
    public void whenUserChoose4ThenWeWillGetAllApplicationTest() {
        Tracker tracker = new Tracker();
        tracker.addApp(appForTests);
        Application[] forShowTest = {appForTests};
        Input input = new StubInput(new String[]{"4", "9", "y"});
        new StartUI(input, tracker).init();
     //   assertThat(tracker.showApps(), is(forShowTest));
    }

    /**
     * Show application by id and exit.
     */
    @Test
    public void whenUserChoose5ThenWeWillGetApplicationByIdTest() {
        Tracker tracker = new Tracker();
        tracker.addApp(appForTests);
        appForTests.setId("id");
        Input input = new StubInput(new String[]{"5", "id", "9", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.showById("id"), is(appForTests));
    }

    /**
     * User removes application by entering app's name.
     */
    @Test
    public void whenUserChoose6ThenHeWillDeleteAppByNameTest() {
        Tracker tracker = new Tracker();
        tracker.addApp(appForTests);
        appForTests.setName("name");
        Application[] test = {};
        Input input = new StubInput(new String[]{"6", "name", "9", "y"});
        new StartUI(input, tracker).init();
      //  assertThat(tracker.showApps(), is(test));
    }

    /**
     * User choose to show application by name.
     */
    @Test
    public void whenUserChoose7ThenHeWillGetAppByNameTest() {
        Tracker tracker = new Tracker();
        tracker.addApp(appForTests);
        appForTests.setName("Frodo");
        Input input = new StubInput(new String[]{"7", "Frodo", "9", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.showByName("Frodo"), is(appForTests));
    }
}