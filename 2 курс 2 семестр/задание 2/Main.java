import controller.AdvancedCalculatorController;
import model.AdvancedCalculatorModel;
import view.CalculatorView;

public class Main {
    public static void main(String[] args) {
        AdvancedCalculatorModel model = new AdvancedCalculatorModel();
        CalculatorView view = new CalculatorView();
        AdvancedCalculatorController controller = new AdvancedCalculatorController(model, view);

        controller.run();
    }
}