package todolist;

import org.junit.Test;
import todolist.models.Item;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;


/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 22.08.2017
 */
public class ControllerTest {
    /**
     * Adding new Item to DB test.
     */
    @Test
    public void whenAddNewDescThenNewItemAppearsInDataBase() {
        Controller controller = new Controller();
        controller.add("new test value");

        Item item = controller.findByDesc("new test value");

        assertThat(controller.findById(item.getId()).getDesc(), is("new test value"));

        controller.delete(item.getId());
        assertNull(controller.findByDesc("new test value"));
    }

    /**
     * Searching by desc test.
     */
    @Test
    public void whenSearchByStringWhenReceiveItem() {
        Controller controller = new Controller();
        controller.add("fuu");
        Item item = controller.findByDesc("fuu");
        assertNotNull(item);
        assertThat(item.getDesc(), is("fuu"));

        controller.delete(item.getId());
    }

    /**
     * Update desc test.
     */
    @Test
    public void whenSetNewDataToItemThenGetItUpdatedInDatabase() {
        Controller controller = new Controller();
        controller.add("super");

        Item item = controller.findByDesc("super");
        controller.updateDesc(item.getId(), "mega");

        assertNotNull(controller.findByDesc("mega"));

        controller.delete(item.getId());
    }

    /**
     * Delete item from DB test.
     */
    @Test
    public void whenDeleteItemFromDbByIdThenGetNull() {
        Controller controller = new Controller();
        controller.add("some value");

        Item item = controller.findByDesc("some value");
        int id = item.getId();

        controller.delete(id);
        assertNull(controller.findById(id));
    }

    /**
     * Update boolean test.
     */
    @Test
    public void whenSetNewBooleanToItemThenGetItUpdatedBooleanInDatabase() {
        Controller controller = new Controller();
        controller.add("new val");

        Item item = controller.findByDesc("new val");
        controller.updateDone(item.getId());
        int id = item.getId();

        assertThat(controller.findById(id).isDone(), is(true));

        controller.delete(id);
        assertNull(controller.findById(id));
    }

    /**
     * Receiving an Array List of Items from Database.
     */
    @Test
    public void whenAddNewItemsToDbThenCouldReceiveAListOfThem() {
        Controller controller = new Controller();
        ArrayList<Item> empty = controller.getAllItems();
        assertNull(empty);

        controller.add("super test");

        ArrayList<Item> result = controller.getAllItems();
        assertNotNull(result);

        Item item = result.get(0);
        int id = item.getId();

        assertThat(item.getDesc(), is("super test"));

        controller.delete(id);
        assertNull(controller.findById(id));
    }

    /**
     * Receiving only not done items list.
     */
    @Test
    public void whenThereAreNotDoneItemsThenReceiveOnlyNotDoneItemsList() {
        Controller controller = new Controller();
        controller.add("first");
        controller.add("second");

        Item f = controller.findByDesc("first");
        Item s = controller.findByDesc("second");

        controller.updateDone(s.getId());

        ArrayList<Item> result = controller.getUnfulfilledItems();

        assertThat(result.size(), is(1));
        assertThat(result.get(0).isDone(), is(false));

        controller.delete(f.getId());
        controller.delete(s.getId());
    }

}