/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto.Aplicativo;

/**
 *
 * @author Douglas
 */

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;


public class RestApp extends Application<Configuration> {
    public static void main(String[] args) throws Exception {
        new RestApp().run(new String[] { "server" });
        
        
    }

    @Override
    public void run(Configuration configuration, Environment environment) {
        DataAccessObjectDB dao = new DataAccessObjectDB();
        environment.jersey().register(new AplicativoResource(dao));
    }
}
