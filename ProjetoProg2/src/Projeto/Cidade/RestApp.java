
package Projeto.Cidade;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class RestApp extends Application<Configuration> {

    public static void main(String[] args) throws Exception {
        new RestApp().run(new String[]{"server"});

    }

    @Override
    public void initialize(final Bootstrap<Configuration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/pagina", "/", "PCidade/createCidade.html"));
    }

    @Override
    public void run(Configuration configuration, Environment environment) {
        DataAccessObjectDB dao = new DataAccessObjectDB();
        environment.jersey().register(new CidadeResource(dao));
        environment.jersey().setUrlPattern("/api/*");
    }
}
