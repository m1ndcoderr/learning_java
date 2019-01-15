package ru.evgenyhodz;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 10.05.2017
 */
public class PageGetter {
    /**
     * Counter.
     */
    private AtomicInteger i = new AtomicInteger(1);

    /**
     * List with advertisements.
     */
    private ArrayDeque<Advertisement> list = new ArrayDeque<>();

    /**
     * Formatter.
     */
    private SimpleDateFormat format = new SimpleDateFormat("dd MMMM yy", Locale.ENGLISH);

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PageGetter.class);

    /**
     * Getter.
     *
     * @return list.
     */
    public ArrayDeque<Advertisement> getList() {
        return list;
    }

    /**
     * Метод просматривает объявления и создает новые Advertisement, добавляет их в очередь.
     */
    public void readPages() {
        Document doc;
        Date temp = new Date();
        while (getFirstDayOfYear().before(temp)) {
            try {
                String url = "http://www.sql.ru/forum/job-offers/" + i.getAndIncrement();
                doc = Jsoup.connect(url).get();
                Elements links = doc.select("a[href]");
                for (Element link : links) {
                    String text = link.text();
                    if (text.toLowerCase().contains("java") && !text.toLowerCase().contains("javascript")) {
                        String ref = link.attr("href");
                        String title = getTitle(ref);
                        String desc = getDescription(ref);
                        temp = getDate(ref);
                        Advertisement advertisement = new Advertisement(title, desc, temp);
                        list.addLast(advertisement);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Получаем заголовок по ссылке.
     *
     * @param url ссылкаю
     * @return заголовок.
     */
    private String getTitle(String url) {
        String result = null;
        Document doc;
        try {
            doc = Jsoup.connect(url).get();
            result = doc.title();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * Получаем описание по ссылке.
     *
     * @param url ссылка.
     * @return описание.
     */
    private String getDescription(String url) {
        String result = null;
        Document doc;
        try {
            doc = Jsoup.connect(url).get();
            result = doc.getElementsByClass("msgBody").get(1).ownText();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * Получение даты создания объявления по ссылке.
     *
     * @param url ссылка на объявление.
     * @return date.
     */
    private Date getDate(String url) {
        Document doc;
        Date temp = null;
        try {
            doc = Jsoup.connect(url).get();
            String date = doc.getElementsByClass("msgFooter").get(0).ownText();
            if (date.contains("сегодня")) {
                temp = new Date();
            } else if (date.contains("вчера")) {
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DATE, -1);
                temp = cal.getTime();
            } else {
                temp = format.parse(replaceMonth(date));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    /**
     * Меняем русскоязычное название месяца на англоязычное.
     *
     * @param string строка.
     * @return измененная строка.
     */
    private String replaceMonth(String string) {
        String result = null;
        String[] rus = {"янв", "фев", "мар", "апр", "май", "июн", "июл", "авг", "сен", "окт", "ноя", "дек"};
        String[] eng = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        for (int j = 0; j < rus.length; j++) {
            if (string.toLowerCase().contains(rus[j])) {
                result = string.replace(rus[j], eng[j]);
            }
        }
        return result;
    }

    /**
     * Получение даты начала года.
     *
     * @return дата начала года.
     */
    private Date getFirstDayOfYear() {
        Date result = null;
        String currentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        try {
            result = format.parse("1 January " + currentYear);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
