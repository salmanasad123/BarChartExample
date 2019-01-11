package com.example.teamas.barchartexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnChartValueSelectedListener {

    private BarChart barChart;
    private List<BarEntry> barEntryList = new ArrayList<>();
    private String[] days = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        barChart = findViewById(R.id.bar_chart);


        barEntryList.add(new BarEntry(1, 2));
        barEntryList.add(new BarEntry(2, 4));
        barEntryList.add(new BarEntry(3, 6));
        barEntryList.add(new BarEntry(4, 8));

        BarDataSet barDataSet = new BarDataSet(barEntryList, "My Data Set");
        barDataSet.setColor(R.color.colorAccent);
        barDataSet.setValueTextColor(R.color.colorPrimaryDark);


        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);
        barChart.invalidate();

        barChart.setScaleEnabled(false);
        barChart.setDoubleTapToZoomEnabled(false);

        barChart.setMaxHighlightDistance(50);


        XAxis xAxis = barChart.getXAxis();
        xAxis.setDrawLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);

        YAxis yAxis = barChart.getAxisRight();
        YAxis yAxis1 = barChart.getAxisLeft();

        yAxis1.setDrawGridLines(false);
        yAxis.setEnabled(false);
        yAxis.setDrawGridLines(false);


       /* IAxisValueFormatter formatter = new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return days[(int) value];
            }
        };
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(formatter);
*/

        barChart.setOnChartValueSelectedListener(this);

    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {
        Toast.makeText(this, "Value Selected" + e.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected() {

    }
}
