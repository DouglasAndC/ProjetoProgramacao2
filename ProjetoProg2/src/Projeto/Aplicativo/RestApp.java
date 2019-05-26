
package Projeto.Aplicativo;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.assets.AssetsBundle;

public class RestApp extends Application<Configuration> {
    public static void main(String[] args) throws Exception {
        new RestApp().run(new String[] { "server" });
    }

    @Override
    public void initialize(final Bootstrap<Configuration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/pagina", "/", "PAplicativo/indexAplicativo.html"));
    }
    
    @Override
    public void run(Configuration configuration, Environment environment) {
        DataAccessObjectDB dao = new DataAccessObjectDB();
        environment.jersey().register(new AplicativoResource(dao));
        environment.jersey().setUrlPattern("/api/*");
    }
}
