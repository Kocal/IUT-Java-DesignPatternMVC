package app.controller;

import app.model.ModelCamembert;
import app.model.ModelHistogramme;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.DefaultPieDataset;

import java.util.Map;

/**
 * Created by kocal on 07/12/15.
 */
public class ControllerHistogramme extends Controller {

    /**
     * Retourne le Model associé au Controller
     *
     * @return ModelHistogramme
     */
    public ModelHistogramme getModel() {
        return (ModelHistogramme) super.getModel();
    }

    /**
     * Crée un échantillon de données
     *
     * @return Un échantillon de données
     */
    public CategoryDataset createSampleDataset() {
        Map<String, Integer> map = this.getModel().getStudentsPerBac();
        final DefaultPieDataset result = new DefaultPieDataset();
        int size = map.size();

        int i = 0;
        double[][] data =  new double[size][1];
        String[] rows = new String[size];
        String[] columns = new String[] { "" };

        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            rows[i] = entry.getKey();
            data[i++][0] = entry.getValue();
        }

        return DatasetUtilities.createCategoryDataset(rows, columns, data);
    }
}
