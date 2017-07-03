package com.opencredo.test.api.acceptance.test.interaction.api.objects;

/**
 * import java.io.BufferedReader;
 * import java.io.IOException;
 * import java.io.InputStreamReader;
 */

import com.opencredo.test.TflLines;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.net.HttpURLConnection;
/**import java.net.MalformedURLException;*/
import java.net.URL;

public class TflApi extends AbstractApiObject {

    public TflApi(String baseUrl) {
        super(baseUrl);
    }

    public ResponseEntity<Void> getDisruption(String line){
        return restTemplate.getForEntity(baseUrl + "/" + line + "/Disruption", Void.class);
    }

    public String getLineWithoutDisruptions() {
        for (String lineName : TflLines.linesListForDisruption) {
            getDisruption(lineName);
            System.out.println(lineName);
            if (getDisruption(lineName).getBody() == null) {
                return lineName;
            }
        }

        return null;
    }

}
