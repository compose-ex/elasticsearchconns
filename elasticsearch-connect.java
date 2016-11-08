import java.util.Arrays;

import io.searchbox.client.JestClientFactory;
import io.searchbox.client.JestResult;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.client.JestClient;
import io.searchbox.cluster.Health;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;


public class ElasticsearchConnect {

    public static void main(String[] args) throws IOException {

        // sets up log4j to log the results of the connection to the terminal
        BasicConfigurator.configure();

        // set up a Jest factory
        JestClientFactory factory = new JestClientFactory();

        // configure and build Jest HTTP client with Compose connection strings
        factory.setHttpClientConfig(new HttpClientConfig
                .Builder(Arrays.asList('https://username:password@portal113-2.latest-elasticsearch.compose-3.composedb.com:10113/', 'https://username:password@portal164-1.latest-elasticsearch.compose-3.composedb.com:10164/'))
                .multiThreaded(true)
                .build());

        // create a JestClient
        JestClient client = factory.getObject();
        // create the call for the cluster health
        Health health = new Health.Builder().build();
        // get the cluster health as a JestResult
        JestResult result = client.execute(health);

        // print out the cluster's health
        System.out.printf("\n\n<------ CLUSTER HEALTH ------>\n%s\n\n", result.getJsonObject());
        // shutdown the connection
        client.shutdownClient();
    }

}
