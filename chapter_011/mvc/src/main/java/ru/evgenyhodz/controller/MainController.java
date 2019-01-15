package ru.evgenyhodz.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.evgenyhodz.models.Advertisement;
import ru.evgenyhodz.service.AdvertisementService;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 04.10.2017
 */

@Controller
public class MainController {
    /**
     * Advertisement service.
     */
    private AdvertisementService advertisementService;

    /**
     * Setter for spring autowire.
     *
     * @param as advertisement service.
     */
    @Autowired
    @Qualifier(value = "advertisementService")
    public void setPersonService(AdvertisementService as) {
        this.advertisementService = as;
    }

    /**
     * Shows basic page. // Здесь немного костыльнул, т.к. использовал БД с предыдущего задания. //
     *
     * @return basic page.
     */
    @RequestMapping(value = "/basic", method = RequestMethod.GET)
    public String showBasicPage(Model model) {
        String htmlResponse = " <div class=\"row\">";
        int count = 0;
        for (Advertisement adv : this.advertisementService.getAllAds()) {
            htmlResponse = htmlResponse + "<div class=\"col-md-4 center-block\">\n"
                    + "<h2>" + adv.getCar().getBrand().getName() + " "
                    + adv.getCar().getModel().getModel() + "</h2>\n"
                    + "<p><img src=\"/carstore/resources/" + adv.getImage().getUrl().substring(3) + "\"/></p>\n"
                    + "<p><a class=\"btn btn-secondary\"  "
                    + "role=\"button\" id=\"" + adv.getId()
                    + "\" onclick=\"redirect_by_id()\">View details</a></p>\n" + "</div>";
            count++;
            if (count == 3) {
                htmlResponse = htmlResponse + "</div><div class=\"row\">";
                count = 0;
            }
        }
        htmlResponse = htmlResponse + "</div>";
        model.addAttribute("advertisements", htmlResponse);
        return "basic";
    }

    /**
     * Shows car details page.
     *
     * @return car details page.
     */
    @RequestMapping(value = "/car", method = RequestMethod.GET)
    public String showCarDetailsPage(Model model) {
        int id = 1;
        Advertisement advertisement = advertisementService.findById(id);
        model.addAttribute("advertisement", advertisement);
        return "car";
    }

    /**
     * Shows sign in page.
     *
     * @return sign in page.
     */
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String showSignInPage() {
        return "sign_in";
    }

    /**
     * Shows sign up page.
     *
     * @return sign up page.
     */
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String showSignUpPage() {
        return "sign_up";
    }

    /**
     * Shows add_new_adv page.
     *
     * @return advertisement's creation page.
     */
    @RequestMapping(value = "/add_new_adv", method = RequestMethod.GET)
    public String showAddAdvPage() {
        return "add_new_adv";
    }

}
