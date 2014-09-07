package icebank;

public class Server {

    public static void main(String[] args) {
	Ice.Communicator ic = null;

	try {

	    ic = Ice.Util.initialize(args);

	    // Ice.PluginManager pluginMgr = ic.getPluginManager();
	    // Ice.Plugin plugin = pluginMgr.getPlugin("IceSSL");
	    // IceSSL.Plugin sslPlugin = (IceSSL.Plugin) plugin;
	    // sslPlugin.setCertificateVerifier(new MyCertificateVerifier());

	    // TODO inna nazwa? bankAdapter?
	    Ice.ObjectAdapter adapter = ic.createObjectAdapter("Adapter");
	    Ice.ServantLocator evictor = new Evictor();

	    // BankManager bankManager = new BankManager(adapter);
	    BankManager bankManager = new BankManager(adapter);
	    Ice.Object bankObj = bankManager;

	    adapter.add(bankObj, ic.stringToIdentity("manager/BankManager"));
	    // adapter.add(premiumObj,
	    // ic.stringToIdentity("account/account_number"));
	    adapter.addServantLocator(evictor, "silver");

	    adapter.activate();

	    System.out.println("Entering event processing loop...");

	    ic.waitForShutdown();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    if (ic != null) {
		try {
		    ic.destroy();
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	}
    }
}
