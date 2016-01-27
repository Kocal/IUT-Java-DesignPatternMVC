/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.panel;

import app.controller.ControllerHistogramme;
import app.model.ModelHistogramme;
import app.view.ViewHistogramme;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;

/**
 *
 * @author p1402118
 */
public class PanelHistogramme extends ChartPanel {

    /**
     * Controller lié à la View contenant ce panel
     */
    private ControllerHistogramme controller;

    /**
     * View contenant ce panel
     */
    private ViewHistogramme view;

    /**
     * Initialise la classe PanelHistogramme en lui associant une View
     *
     * @param view View à associer
     */
    public PanelHistogramme(ViewHistogramme view) {
        super(null);

        this.view = view;
        this.controller = (ControllerHistogramme) view.getController();
    }

    /**
     * Met à jour le contenu de la classe PanelCamembert
     */
    public void update() {
        CategoryDataset dataset = this.controller.createSampleDataset();
        JFreeChart chart = this.createChart(dataset);
        this.setChart(chart);
    }

    /**
     * Crée le graphique
     *
     * @param dataset Echantillon de données
     * @return Graphique
     */
    private JFreeChart createChart(CategoryDataset dataset) {
        final JFreeChart chart = ChartFactory.createBarChart3D (
                "Séries de bac",      // chart title
                "Bacs",               // domain axis label
                "Nombre",                  // range axis label
                dataset,                  // data
                PlotOrientation.VERTICAL, // orientation
                true,                     // include legend
                true,                     // tooltips
                false                     // urls
        );

        final CategoryPlot plot = chart.getCategoryPlot();
        final CategoryAxis axis = plot.getDomainAxis();
        axis.setCategoryLabelPositions(
                CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 8.0)
        );
        final BarRenderer3D renderer = (BarRenderer3D) plot.getRenderer();
        renderer.setDrawBarOutline(false);

        return chart;
    }
}