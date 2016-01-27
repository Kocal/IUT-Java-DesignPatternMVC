/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.panel;

import app.controller.Controller;
import app.controller.ControllerCamembert;
import app.model.Model;
import app.model.ModelCamembert;
import app.model.Promotion;
import app.view.ViewCamembert;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

import java.util.Map;

/**
 *
 * @author p1402118
 */
public class PanelCamembert extends ChartPanel {

    /**
     * Controller lié à la View contenant ce panel
     */
    private ControllerCamembert controller;

    /**
     * View contenant ce panel
     */
    private ViewCamembert view;

    /**
     * Initialise la classe PanelCamembert en lui associant une View
     *
     * @param view View à associer
     */
    public PanelCamembert(ViewCamembert view) {
        super(null);

        this.view = view;
        this.controller = (ControllerCamembert) this.view.getController();
    }

    /**
     * Met à jour le contenu de la classe PanelCamembert
     */
    public void update() {
        PieDataset dataset = this.controller.createSampleDataset();
        JFreeChart chart = this.createChart(dataset);
        this.setChart(chart);
    }

    /**
     * Crée le graphique
     *
     * @param dataset Echantillon de données
     * @return Graphique
     */
    private JFreeChart createChart(PieDataset dataset) {
        final JFreeChart chart = ChartFactory.createPieChart3D(
                "Répartition géographique",  // chart title
                dataset,                // data
                true,                   // include legend
                true,
                false
        );

        final PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.9f);
        plot.setNoDataMessage("Unlucky données ://// gg rito");
        return chart;
    }
}