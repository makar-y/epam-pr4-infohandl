package test.by.malinouski.infohandling.parser;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import by.malinouski.infohandling.composite.Letter;
import by.malinouski.infohandling.composite.Punctuation;
import by.malinouski.infohandling.composite.TextComponent;
import by.malinouski.infohandling.composite.TextComposite;
import by.malinouski.infohandling.parser.SentenceParser;

public class SentenceParserTest {

    private static final String SENTENCE = "I is.";
    private static final String SIMPLE_TEXT = "S.";
    private SentenceParser parser;
    
        
    @Before
    public void initParser() {
        parser = new SentenceParser();
    }
    
    @Test
    public void parserTestSimple() {
        Letter letter = new Letter('S');
        Punctuation dot = new Punctuation('.');

        TextComposite word = new TextComposite();
        word.add(letter);
        word.add(dot);
        
        TextComposite expectedSentence = new TextComposite();
        expectedSentence.add(word);
        
        assertEquals(expectedSentence, parser.parse(SIMPLE_TEXT));
    }
    
    @Test
    public void parseTest() {
        Letter capI = new Letter('I');
        Letter i = new Letter('i');
        Letter s = new Letter('s');
        Punctuation dot = new Punctuation('.');
        
        // I
        TextComposite wordCapI = new TextComposite();
        wordCapI.add(capI);
        
        // is.
        TextComposite wordIsDot = new TextComposite();
        wordIsDot.add(i);
        wordIsDot.add(s);
        wordIsDot.add(dot);
        
     // I is.
        TextComposite sentence = new TextComposite();
        sentence.add(wordCapI);
        sentence.add(wordIsDot);
        
        assertEquals(sentence, parser.parse(SENTENCE));
    }

}
