package ru.evgenyhodz;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by alittlem1nd on 22.11.2016.
 */
public class PalindromeTest {
    /**
     * Тест проверяет, что слово является палиндромом.
     */
    @Test
    public void whenWordIsPalindromeThenResultIsTrueTest() {
        Palindrome palindrome = new Palindrome();
        String pal = "ROTOR";
        try (InputStream stream = new ByteArrayInputStream(pal.getBytes(StandardCharsets.UTF_8))) {
            assertThat(palindrome.checkWord(stream), is(true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Тест проверяет, что слово является палиндромом.
     */
    @Test
    public void whenWordIsNotPalindromeThenResultIsFalseTest() {
        Palindrome palindrome = new Palindrome();
        String notpal = "notROTOR";
        try (InputStream stream = new ByteArrayInputStream(notpal.getBytes(StandardCharsets.UTF_8))) {
            assertThat(palindrome.checkWord(stream), is(false));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Проверка самого длинного в мире слова-палиндрома.
     */
    @Test
    public void whenCheckFamousWordThenGetResultTest() {
        Palindrome palindrome = new Palindrome();
        String famous = "Saippuakivikauppias";
        try (InputStream stream = new ByteArrayInputStream(famous.getBytes(StandardCharsets.UTF_8))) {
            assertThat(palindrome.checkWord(stream), is(true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Проверка предложения-палиндрома.
     */
    @Test
    public void whenCheckSentenceThenGetResultTest() {
        Palindrome palindrome = new Palindrome();
        String sentence = "Аргентина манит негра";
        try (InputStream stream = new ByteArrayInputStream(sentence.getBytes(StandardCharsets.UTF_8))) {
            assertThat(palindrome.checkWord(stream), is(true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Проверка обычного предложения дает false.
     */
    @Test
    public void whenCheckUsualSentenceThenGetResultTest() {
        Palindrome palindrome = new Palindrome();
        String usual = "Самое обычное предложение";
        try (InputStream stream = new ByteArrayInputStream(usual.getBytes(StandardCharsets.UTF_8))) {
            assertThat(palindrome.checkWord(stream), is(false));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
