package com.opencredo.test.api.acceptance.test.interaction.api.objects;

import com.opencredo.test.api.acceptance.test.interaction.dto.Repository;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

public class GithubApi extends AbstractApiObject {
    public GithubApi(String baseUrl) {
        super(baseUrl);
    }

    public List<Repository> getRepositoryListForOrganisation(String organisation) {
        String url = baseUrl + "/orgs/" + organisation + "/repos";
        ResponseEntity<Repository[]> forEntity = restTemplate.getForEntity(url, Repository[].class);
        return Arrays.asList(forEntity.getBody());
    }
}
