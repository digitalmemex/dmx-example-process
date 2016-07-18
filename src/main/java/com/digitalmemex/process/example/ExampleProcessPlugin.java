package com.digitalmemex.process.example;

import com.digitalmemex.process.engine.ProcessEngineService;
import com.digitalmemex.process.engine.ProcessInfo;
import de.deepamehta.core.osgi.PluginActivator;
import de.deepamehta.core.service.Inject;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.codehaus.jettison.json.JSONException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.logging.Logger;

@Path("/example")
@Produces("application/json")
public class ExampleProcessPlugin extends PluginActivator {

    @Inject
    ProcessEngineService engine;
    private Logger logger = Logger.getLogger(getClass().getName());

    @Override
    public void init() {
        logger.info("register delegates");
        Hashtable<String, String> properties = new Hashtable<String, String>();
        properties.put("processExpression", "exampleLogDelegate");
        getBundleContext().registerService(JavaDelegate.class, new LogDelegate(), properties);

        logger.info("deploy example process");
        InputStream bpmn = this.getClass().getResourceAsStream("/examplecheck.bpmn");
        ProcessInfo s = engine.deploy("example", "examplecheck.bpmn", bpmn);
        logger.info("deployed process: " + s.getName());
    }

    @GET
    public String getIt() throws JSONException {
        return "use /process/start/...";
    }

}
