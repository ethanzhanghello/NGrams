package main;

import browser.NgordnetQuery;
import browser.NgordnetQueryHandler;
import ngrams.NGramMap;
import ngrams.TimeSeries;
import org.knowm.xchart.XYChart;
import plotting.Plotter;

import java.util.ArrayList;
import java.util.List;

public class HistoryHandler extends NgordnetQueryHandler {
    private NGramMap map;
    private List<String> labels;
    private List<TimeSeries> data;

    public HistoryHandler(NGramMap map) {
        this.map = map;
    }

    @Override
    public String handle(NgordnetQuery q) {
        List<String> words = q.words();
        int startYear = q.startYear();
        int endYear = q.endYear();
        labels = new ArrayList<>();
        data = new ArrayList<>();
        for (String word : words) {
            data.add(map.weightHistory(word, startYear, endYear));
            labels.add(word);
        }
        XYChart chart = Plotter.generateTimeSeriesChart(labels, data);
        String encodedImage = Plotter.encodeChartAsString(chart);
        return encodedImage;
    }
}
