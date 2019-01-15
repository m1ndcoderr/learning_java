package carstore.controllers;

import carstore.models.Advertisement;
import carstore.models.Engine;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;


/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 30.08.2017
 */
public class CarStoreManagerTest {
    /**
     * Receiving Array List of advertisements test.
     */
    @Test
    public void whenAddNewAdvsToDBThenCouldGetArrayListWithThem() {
        CarStoreManager carStoreManager = new CarStoreManager();
        Advertisement f = new Advertisement();
        Advertisement s = new Advertisement();
        Advertisement t = new Advertisement();
        f.setDescription("1");
        s.setDescription("2");
        t.setDescription("3");
        carStoreManager.addAdvertisement(f);
        carStoreManager.addAdvertisement(s);
        carStoreManager.addAdvertisement(t);
        ArrayList<Advertisement> list = carStoreManager.getAllAds();
        assertThat(list.size(), is(3));
        assertThat(list.get(0).getDescription(), is("1"));
        assertThat(list.get(1).getDescription(), is("2"));
        assertThat(list.get(2).getDescription(), is("3"));
        carStoreManager.deleteAdvertisementById(carStoreManager.findByDesc("1").getId());
        carStoreManager.deleteAdvertisementById(carStoreManager.findByDesc("2").getId());
        carStoreManager.deleteAdvertisementById(carStoreManager.findByDesc("3").getId());
    }

    /**
     * Find by description test.
     */
    @Test
    public void whenFindByDescThenGetAdvertisementWithThatDesc() {
        CarStoreManager carStoreManager = new CarStoreManager();
        Advertisement adv = new Advertisement();
        adv.setDescription("search test");
        carStoreManager.addAdvertisement(adv);
        assertNotNull(carStoreManager.findByDesc("search test"));
        carStoreManager.deleteAdvertisementById(carStoreManager.findByDesc("search test").getId());
    }

    /**
     * Removing advertisement test.
     */
    @Test
    public void whenRemoveAdvFromDBThenGetNull() {
        CarStoreManager carStoreManager = new CarStoreManager();
        Advertisement adv = new Advertisement();
        adv.setDescription("delete test");
        carStoreManager.addAdvertisement(adv);
        Advertisement result = carStoreManager.findByDesc("delete test");
        carStoreManager.deleteAdvertisementById(result.getId());
        assertNull(carStoreManager.findByDesc("delete test"));
    }

    /**
     * Should return array list with advertisements.
     */
    @Test
    public void whenAddNewAdvertisementsThenCouldReturnArrayListWithThem() {
        CarStoreManager carStoreManager = new CarStoreManager();
        Advertisement adv = new Advertisement();
        adv.setDescription("new adv");
        carStoreManager.addAdvertisement(adv);
        ArrayList<Advertisement> advertisements = carStoreManager.getAllAds();
        Advertisement result = advertisements.get(0);
        assertThat(result.getDescription(), is("new adv"));
        carStoreManager.deleteAdvertisementById(carStoreManager.findByDesc("new adv").getId());
    }

    /**
     * Should return Brand object.
     */
    @Test
    public void whenAddNewBrandThenCouldGetItFromDatabase(){

    }

    @Test
    public void whenSetStringWhenFindsEngineByDataInIt(){
        CarStoreManager carStoreManager = new CarStoreManager();
        Engine engine = new Engine();
        engine.setCapacity(1.5);
        engine.setType("diesel");
        carStoreManager.addEngine(engine);
        String value = "diesel, 1.5";
        assertThat(carStoreManager.findEngineByNameAndCapacity(value).getCapacity(), is(1.5));
        assertThat(carStoreManager.findEngineByNameAndCapacity(value).getType(), is("diesel"));
    }

}