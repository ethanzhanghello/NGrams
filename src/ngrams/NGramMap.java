package ngrams;

import edu.princeton.cs.algs4.In;

import java.util.Collection;
import java.util.HashMap;

import static ngrams.TimeSeries.MAX_YEAR;
import static ngrams.TimeSeries.MIN_YEAR;

/**
 * An object that provides utility methods for making queries on the
 * Google NGrams dataset (or a subset thereof).
 *
 * An NGramMap stores pertinent data from a "words file" and a "counts
 * file". It is not a map in the strict sense, but it does provide additional
 * functionality.
 *
 * @author Josh Hug
 */
public class NGramMap {

    HashMap<String, TimeSeries> wordsFileMap;
    TimeSeries countsFileTs;
    String wordsFile;
    String countsFile;

    /**
     * Constructs an NGramMap from WORDSFILENAME and COUNTSFILENAME.
     */
    public NGramMap(String wordsFilename, String countsFilename) {
        wordsFile = wordsFilename;
        countsFile = countsFilename;

        wordsFileMap = new HashMap<>();
        countsFileTs = new TimeSeries();

        In inWords = new In(wordsFile);
        In inCounts = new In(countsFile);

        String prev = "";
        while (inWords.hasNextLine()) {
            String nextLine = inWords.readLine();
            String[] splitLine = nextLine.split("\t");
            String curr = splitLine[0];
            if (!curr.equals(prev)) {
                TimeSeries ts = new TimeSeries();
                ts.put(Integer.valueOf(splitLine[1]), Double.valueOf(splitLine[2]));
                wordsFileMap.put(splitLine[0], ts);
                prev = curr;
            } else {
                wordsFileMap.get(curr).put(Integer.valueOf(splitLine[1]), Double.valueOf(splitLine[2]));
            }

        }
        while (inCounts.hasNextLine()) {
            String nextLine = inCounts.readLine();
            String[] splitLine = nextLine.split(",");
            countsFileTs.put(Integer.valueOf(splitLine[0]), Double.valueOf(splitLine[1]));
        }
    }

    /**
     * Provides the history of WORD between STARTYEAR and ENDYEAR, inclusive of both ends. The
     * returned TimeSeries should be a copy, not a link to this NGramMap's TimeSeries. In other
     * words, changes made to the object returned by this function should not also affect the
     * NGramMap. This is also known as a "defensive copy". If the word is not in the data files,
     * returns an empty TimeSeries.
     */
    public TimeSeries countHistory(String word, int startYear, int endYear) {
        if (!wordsFileMap.containsKey(word)) {
            return new TimeSeries();
        }
        return new TimeSeries(wordsFileMap.get(word), startYear, endYear);
    }

    /**
     * Provides the history of WORD. The returned TimeSeries should be a copy, not a link to this
     * NGramMap's TimeSeries. In other words, changes made to the object returned by this function
     * should not also affect the NGramMap. This is also known as a "defensive copy". If the word
     * is not in the data files, returns an empty TimeSeries.
     */
    public TimeSeries countHistory(String word) {
        if (!wordsFileMap.containsKey(word)) {
            return new TimeSeries();
        }
        return new TimeSeries(wordsFileMap.get(word), MIN_YEAR, MAX_YEAR);
    }

    /**
     * Returns a defensive copy of the total number of words recorded per year in all volumes.
     */
    public TimeSeries totalCountHistory() {
        return new TimeSeries(countsFileTs, MIN_YEAR, MAX_YEAR);
    }

    /**
     * Provides a TimeSeries containing the relative frequency per year of WORD between STARTYEAR
     * and ENDYEAR, inclusive of both ends. If the word is not in the data files, returns an empty
     * TimeSeries.
     */
    public TimeSeries weightHistory(String word, int startYear, int endYear) {
        if (!wordsFileMap.containsKey(word)) {
            return new TimeSeries();
        }
        TimeSeries wordFrequency = new TimeSeries(wordsFileMap.get(word), startYear, endYear);
        TimeSeries totalWords = new TimeSeries(countsFileTs, startYear, endYear);
        return wordFrequency.dividedBy(totalWords);
    }

    /**
     * Provides a TimeSeries containing the relative frequency per year of WORD compared to all
     * words recorded in that year. If the word is not in the data files, returns an empty
     * TimeSeries.
     */
    public TimeSeries weightHistory(String word) {
        if (!wordsFileMap.containsKey(word)) {
            return new TimeSeries();
        }
        TimeSeries wordFrequency = wordsFileMap.get(word);
        return wordFrequency.dividedBy(countsFileTs);
    }

    /**
     * Provides the summed relative frequency per year of all words in WORDS between STARTYEAR and
     * ENDYEAR, inclusive of both ends. If a word does not exist in this time frame, ignore it
     * rather than throwing an exception.
     */
    public TimeSeries summedWeightHistory(Collection<String> words,
                                          int startYear, int endYear) {
        TimeSeries sum = new TimeSeries();
        for (String word : words) {
            TimeSeries ts = weightHistory(word, startYear, endYear);
            sum = sum.plus(ts);
        }
        return sum;
    }

    /**
     * Returns the summed relative frequency per year of all words in WORDS. If a word does not
     * exist in this time frame, ignore it rather than throwing an exception.
     */
    public TimeSeries summedWeightHistory(Collection<String> words) {
        TimeSeries sum = new TimeSeries();
        for (String word : words) {
            TimeSeries ts = weightHistory(word);
            sum = sum.plus(ts);
        }
        return sum;
    }
}
