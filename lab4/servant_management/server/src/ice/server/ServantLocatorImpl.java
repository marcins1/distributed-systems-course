package ice.server;

import com.zeroc.Ice.*;
import com.zeroc.Ice.Object;

public class ServantLocatorImpl implements ServantLocator {
    private final IceServer server;
    private int scientificServantsCounter = 0;
    private int trigonometricServantsCounter = 0;

    public ServantLocatorImpl(IceServer server) {
        this.server = server;
    }

    @Override
    public LocateResult locate(Current current) {
        String name = current.id.name;
        String category = current.id.category;
        ObjectAdapter adapter = current.adapter;
        Object foundServant = adapter.find(new Identity(name, category));
        if (foundServant != null) {
            return new ServantLocator.LocateResult(foundServant, null);
        } else {
            if (name.equals(server.getServerName())) {
                switch (category) {
                    case "Scientific1", "Scientific2" -> {
                        String servant_name = "SS" + ++scientificServantsCounter;
                        server.log("Creating Scientific servant " + servant_name);
                        ScientificCalculatorImpl scientificCalculator = new ScientificCalculatorImpl(servant_name);
                        adapter.add(scientificCalculator, new Identity(name, category));
                        return new LocateResult(scientificCalculator, null);
                    }
                    case "Trigonometric1", "Trigonometric2" -> {
                        String servant_name = "TS" + ++trigonometricServantsCounter;
                        server.log("Creating Trigonometric servant " + servant_name);
                        TrigonometricCalculatorImpl trigonometricCalculator = new TrigonometricCalculatorImpl(servant_name);
                        adapter.add(trigonometricCalculator, new Identity(name, category));
                        return new LocateResult(trigonometricCalculator, null);
                    }
                }
            }
        }
        throw new RuntimeException("Provided servant not found");
    }

    @Override
    public void finished(Current current, Object object, java.lang.Object o) {}

    @Override
    public void deactivate(String s) {}
}
