package app.controller;

import app.model.ModelCamembert;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import java.util.Map;

/**
 * Created by kocal on 07/12/15.
 */
public class ControllerCamembert extends Controller {

    /**
     * Retourne le Model lié au Controller
     *
     * @return ModelCamembert
     */
    public ModelCamembert getModel() {
        return (ModelCamembert) super.getModel();
    }

    /**
     * Crée un échantillon de données
     *
     * @return L'échantillon de données
     */
    public PieDataset createSampleDataset() {
        final DefaultPieDataset result = new DefaultPieDataset();

        Map<String, Integer> map = this.getModel().getStudentsPerDepartements();

        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            result.setValue(entry.getKey(), entry.getValue());
        }

        return result;
    }

}
