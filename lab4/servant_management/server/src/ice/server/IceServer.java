package ice.server;

import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;

public class IceServer {
    private final String serverName;
    private final Communicator communicator;
    private final ObjectAdapter adapter;
    private final ServantLocatorImpl servantLocator;

    public IceServer(String[] args, String serverName) {
        this.communicator = Util.initialize(args);
        this.serverName = serverName;
        this.adapter = communicator.createObjectAdapterWithEndpoints("Adapter1", "tcp -h 127.0.0.3 -p 10000 -z : udp -h 127.0.0.3 -p 10000 -z");
        this.servantLocator = new ServantLocatorImpl(this);
        adapter.addServantLocator(servantLocator, "");
        BasicCalculatorImpl basicCalculator = new BasicCalculatorImpl("BS1");
        adapter.add(basicCalculator, new com.zeroc.Ice.Identity(this.serverName, "Basic1"));
        adapter.add(basicCalculator, new com.zeroc.Ice.Identity(this.serverName, "Basic2"));
        ExtendedCalculatorImpl extendedCalculator = new ExtendedCalculatorImpl("ES1");
        adapter.add(extendedCalculator, new com.zeroc.Ice.Identity(this.serverName, "Extended1"));
        adapter.add(extendedCalculator, new com.zeroc.Ice.Identity(this.serverName, "Extended2"));
    }

    public String getServerName() {
        return serverName;
    }

    public void log(String message) {
        System.out.println("[" + this.serverName + "] " + message);
    }

    public void run() {
        int status = 0;
        try {
            adapter.activate();
            this.log("Entering event processing loop...");
            communicator.waitForShutdown();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            status = 1;
        }
        if (communicator != null) {
            try {
                communicator.destroy();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                status = 1;
            }
        }
        System.exit(status);
    }
}
