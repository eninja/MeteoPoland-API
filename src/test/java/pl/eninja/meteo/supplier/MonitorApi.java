package pl.eninja.meteo.supplier;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

class MonitorApi {

    static boolean isAvailable(String urlOfApi) throws IOException {
        URL url = new URL(urlOfApi);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();
        final int responseCode = connection.getResponseCode();
        connection.disconnect();
        return responseCode == HttpURLConnection.HTTP_OK;
    }
}
