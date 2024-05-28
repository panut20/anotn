package com.anotn.antstock.android.presentation.ui.fragment.chart;

import android.content.Context;
import android.graphics.Color;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class MyLineChart extends LineChart {
    public MyLineChart(Context context) {
        super(context);
    }
    public void setData(LineChart lineChart){

        // Zoom In / Out 가능 여부 설정
        lineChart.setScaleEnabled(false);
        lineChart.setDrawGridBackground(false);

         List<Entry> entryList = new ArrayList<Entry>();
        String title = "현재가";

        float[] prices = {81200, 80700, 80500, 80300, 80200, 80150, 80000, 80300};
        // 임의 데이터
        for (int i = 0; i < prices.length; i++) {
            entryList.add(new Entry((float)i, prices[i]));
        }

        LineDataSet lineDataSet = new LineDataSet(entryList, title);
        // 바 색상 설정 (ColorTemplate.LIBERTY_COLORS)
        lineDataSet.setColors(
                Color.rgb(207, 248, 246), Color.rgb(148, 212, 212), Color.rgb(136, 180, 187),
                Color.rgb(118, 174, 175), Color.rgb(42, 109, 130));

        LineData data = new LineData(lineDataSet);
        lineChart.setData(data);
        lineChart.invalidate();
    }
}
