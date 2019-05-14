/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto.Cidade;

/**
 *
 * @author mateus
 */
import ch.qos.logback.core.CoreConstants;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RestApp extends Application<Configuration> {
    public static void main(String[] args) throws Exception {
        new RestApp().run(new String[] { "server" });
        
        
    }

    @Override
    public void run(Configuration configuration, Environment environment) {
        DataAccessObjectDB dao = new DataAccessObjectDB();
        environment.jersey().register(new CidadeResource(dao));
    }
}