package com.opencredo.test.api.acceptance.test.interaction.api.objects;

/**
 * import java.io.BufferedReader;
 * import java.io.IOException;
 * import java.io.InputStreamReader;
 */

import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

/**
 * import java.net.MalformedURLException;
 */

public class TflApi extends AbstractApiObject {

    public static final List<String> linesListForDisruption = Arrays.asList("central", "victoria", "northern", "jubilee");

    public TflApi(String baseUrl) {
        super(baseUrl);
    }

    public ResponseEntity<Void> getDisruption(String line){
        return restTemplate.getForEntity(baseUrl + "/" + line + "/Disruption", Void.class);
    }

    public String getLineWithoutDisruptions() {
        for (String lineName : linesListForDisruption) {
            getDisruption(lineName);
            System.out.println(lineName);
            if (getDisruption(lineName).getBody() == null) {
                return lineName;
            }
        }

        return null;
    }

}
