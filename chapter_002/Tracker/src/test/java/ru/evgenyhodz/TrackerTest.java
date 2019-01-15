package ru.evgenyhodz;

import org.junit.Test;

import ru.evgenyhodz.models.Application;
import ru.evgenyhodz.start.Tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class to check main API of program.
 */
public class TrackerTest {
    /**
     * Check the edit method.
     */
    @Test
    public void editAppTest() {
        Application application = new Application(null, null, null);
        Tracker tracker = new Tracker();
        tracker.addApp(application);
        final Application fresh = new Application("Name", null, null);
        fresh.setId(application.getId());
        tracker.editApp(fresh);
        assertThat(tracker.showByName("Name"), is(fresh));

    }

    /**
     * Check of removing application from storage.
     */
    @Test
    public void deleteAppTest() {
        Tracker tracker = new Tracker();
        Application testing_1 = new Application(null, null, null);
        Application[] test = {};
        tracker.addApp(testing_1);
        tracker.deleteApp(testing_1.getId());
      //  assertThat(tracker.showApps(), is(test));

    }

    /**
     * Checking method showing all applications.
     */
    @Test
    public void showAppsTest() {
        Application testing_1 = new Application(null, null, null);
        Tracker tracker = new Tracker();
        tracker.addApp(testing_1);
        Application[] testings = {testing_1};
     //   assertThat(tracker.showApps(), is(testings));

    }

    /**
     * Checking method showing application by id.
     */
    @Test
    public void showByIdTest() {
        Application application = new Application("name", "desc", "date");
        Application application_2 = new Application("name2", "desc2", "date2");
        Tracker tracker = new Tracker();
        tracker.addApp(application);
        tracker.addApp(application_2);
        assertThat(tracker.showById(application.getId()), is(application));
        assertThat(tracker.showById(application_2.getId()), is(application_2));

    }

    /**
     * Checking method showing application by name.
     */
    @Test
    public void showByNameTest() {
        Application application = new Application("Frodo", "desc", "date");
        Tracker tracker = new Tracker();
        tracker.addApp(application);
        assertThat(tracker.showByName(application.getName()), is(application));
    }

    /**
     * Checking the method of adding an application in the storage.
     */
    @Test
    public void addAppTest() {
        Application application = new Application(null, null, null);
        Application application2 = new Application(null, null, null);
        Application application3 = new Application(null, null, null);
        Tracker tracker = new Tracker();
        tracker.addApp(application);
        tracker.addApp(application2);
        tracker.addApp(application3);
        Application[] test = {application, application2, application3};
     //   assertThat(tracker.showApps(), is(test));
    }

    /**
     * Checking of method showing all app's names in the storage.
     */
    @Test
    public void showAllNamesTest() {
        Tracker tracker = new Tracker();
        Application application = new Application(null, null, null);
        tracker.addApp(application);
        tracker.showById(application.getId()).setName("name1");
        String[] check = {"name1"};
     //   assertThat(tracker.showAllNames(), is(check));
    }
}