package br.com.projuris;

import org.junit.Test;

public class FindCharacterTests {

    @Test
    public void findCharacterShouldReturnT() {
        MyFindChar myFindChar = new MyFindChar();
        assert 't' == myFindChar.findChar("stress");
    }

    @Test
    public void findCharacterShouldReturnM() {
        MyFindChar myFindChar = new MyFindChar();
        assert 'm' == myFindChar.findChar("reembolsar");
    }

    @Test
    public void findCharacterShouldReturnS() {
        MyFindChar myFindChar = new MyFindChar();
        assert 's' == myFindChar.findChar("otorrinolaringologista");
    }

    @Test
    public void findCharacterShouldReturnSpace() {
        MyFindChar myFindChar = new MyFindChar();
        assert ' ' == myFindChar.findChar("ss");
    }

    @Test
    public void findCharacterShouldReturnSpaceOnInvalidParameter() {
        MyFindChar myFindChar = new MyFindChar();
        assert ' ' == myFindChar.findChar(null);
    }

}