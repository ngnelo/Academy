package x_academy;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

@ManagedBean
public class chartBean
{
   private LineChartModel model;

   public chartBean()
   {
      model = new LineChartModel();
      LineChartSeries series1 = new LineChartSeries();
      series1.setLabel("Preis");
      series1.set("2001", 2);
      series1.set("2002", 1);
      series1.set("2003", 3);
      series1.set("2004", 6);
      series1.set("2005", 8);
      LineChartSeries series2 = new LineChartSeries();
      series2.setLabel("Verbrauch");
      series2.set("2001", 6);
      series2.set("2002", 3);
      series2.set("2003", 2);
      series2.set("2004", 7);
      series2.set("2005", 9);
      model.addSeries(series1);
      model.addSeries(series2);
      model.setTitle("Preis / Verbrauch Chart");
      model.setLegendPosition("e");
      model.setShowPointLabels(true);
      model.getAxes().put(AxisType.X, new CategoryAxis("Years"));
      Axis yAxis = model.getAxis(AxisType.Y);
      yAxis.setLabel("Verbrauch");
      yAxis.setMin(0);
      yAxis.setMax(10);
   }

   public LineChartModel getModel()
   {
      return model;
   }
}
