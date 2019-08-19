package com.kingaspx.util;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleEdge;

public class ChartDaily extends JFrame {

    public ChartDaily(JPanel panel) {
        initUI(panel);
    }

    private void initUI(JPanel panel) {
        XYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(new Color(247, 247, 247));
        chart.setBackgroundPaint(new Color(247, 247, 247));
        panel.add(chartPanel, BorderLayout.CENTER);
        panel.setBounds(10, 10, 10, 10);
    }

    private XYDataset createDataset() {
        XYSeriesCollection dataset = null;
        try {
            ConectaBanco conecta = new ConectaBanco();
            conecta.conexao();
            conecta.executaSQL("SELECT DATE_FORMAT(STR_TO_DATE(person.register_date, '%d/%m/%Y'), '%Y-%m-%d') AS register_date, COUNT(first_name) AS visita\n"
                    + "FROM person \n"
                    + "WHERE DATE_FORMAT(STR_TO_DATE(person.register_date, '%d/%m/%Y'), '%Y-%m-%d') > SUBDATE(CURDATE(),30)\n"
                    + "AND DATE_FORMAT(STR_TO_DATE(person.register_date, '%d/%m/%Y'), '%Y-%m-%d') <= CURDATE()\n"
                    + "GROUP BY register_date\n"
                    + "ORDER BY DATE_FORMAT(STR_TO_DATE(person.register_date, '%d/%m/%Y'), '%Y-%m-%d') DESC");

            XYSeries series = new XYSeries("");
            while (conecta.rs.next()) {
                int total = conecta.rs.getInt("visita");
                Date data = conecta.rs.getDate("register_date");
                series.add(data.getDate(), total);
            }

            dataset = new XYSeriesCollection();
            dataset.addSeries(series);
        } catch (SQLException ex) {
            Logger.getLogger(ChartDaily.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataset;
    }

    private JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                "",
                "",
                "",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, new Color(77, 71, 221));
        renderer.setSeriesStroke(0, new BasicStroke(3.0f));
        plot.setRenderer(renderer);

        //Mudar fonte das informações laterais e rodapé
        Font font3 = new Font("Montserrat Medium", 0, 14);
        plot.getDomainAxis().setAutoRangeMinimumSize(20);
        plot.getDomainAxis().setLabelFont(font3);
        plot.getRangeAxis().setLabelFont(font3);

        //Setando intervalo
//        plot.getDomainAxis().setAutoRangeMinimumSize(1);
//        plot.getDomainAxis().setAutoRange(false);
        NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
        xAxis.setTickUnit(new NumberTickUnit(1));
        //

        //Valor inteiro ao invés de float
        plot.getDomainAxis().setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        plot.getRangeAxis().setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        //

        //Trocar cor do bg e detalhes...
        plot.setBackgroundPaint(new Color(247, 247, 247));
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(new Color(230, 230, 230));

        plot.setDomainGridlinesVisible(false);
        plot.setDomainGridlinePaint(new Color(230, 230, 230));
        plot.setOutlinePaint(null);
        //

        //configurações da legenda
        chart.getLegend().setFrame(BlockBorder.NONE);
        chart.setBorderVisible(false);
        chart.getLegend().setPosition(RectangleEdge.TOP);
        //

        return chart;
    }

}
